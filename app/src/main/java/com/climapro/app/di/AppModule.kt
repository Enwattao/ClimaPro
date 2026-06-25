package com.climapro.app.di

import android.content.Context
import androidx.room.Room
import com.climapro.app.data.db.AppDatabase
import com.climapro.app.data.db.dao.*
import com.climapro.app.data.db.AppDatabase.Companion.MIGRATION_1_2
import com.climapro.app.data.db.AppDatabase.Companion.MIGRATION_2_3
import com.climapro.app.data.db.AppDatabase.Companion.MIGRATION_3_4
import com.climapro.app.util.UpdateApi
import com.climapro.app.util.UpdateChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, "climapro.db")
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
            .build()

    @Provides fun provideClienteDao(db: AppDatabase): ClienteDao = db.clienteDao()
    @Provides fun provideMontajeDao(db: AppDatabase): MontajeDao = db.montajeDao()
    @Provides fun provideMantenimientoDao(db: AppDatabase): MantenimientoDao = db.mantenimientoDao()
    @Provides fun provideFotoDao(db: AppDatabase): FotoDao = db.fotoDao()
    @Provides fun provideAlbaranDao(db: AppDatabase): AlbaranDao = db.albaranDao()
    @Provides fun provideAveriaDao(db: AppDatabase): AveriaDao = db.averiaDao()
    @Provides fun provideGastoDao(db: AppDatabase): GastoDao = db.gastoDao()
    @Provides fun provideNotaDao(db: AppDatabase): NotaDao = db.notaDao()

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideUpdateApi(retrofit: Retrofit): UpdateApi =
        retrofit.create(UpdateApi::class.java)
}
