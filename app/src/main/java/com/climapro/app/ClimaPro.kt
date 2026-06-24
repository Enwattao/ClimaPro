package com.climapro.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ClimaPro : Application(), Configuration.Provider {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        crearCanalesNotificacion()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().setWorkerFactory(workerFactory).build()

    private fun crearCanalesNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(NotificationChannel("climapro_recordatorios", "Recordatorios de trabajo", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Avisos para montajes y mantenimientos programados"
            })
            nm.createNotificationChannel(NotificationChannel("climapro_cobros", "Cobros pendientes", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Avisos de cobros pendientes"
            })
        }
    }
}
