package com.climapro.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "climapro_prefs")

@Singleton
class AppPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    private object Keys {
        val EMPRESA_NOMBRE = stringPreferencesKey("empresa_nombre")
        val EMPRESA_TELEFONO = stringPreferencesKey("empresa_telefono")
        val EMPRESA_DIRECCION = stringPreferencesKey("empresa_direccion")
        val EMPRESA_LOGO_PATH = stringPreferencesKey("empresa_logo_path")
        val NOTIF_24H = booleanPreferencesKey("notif_24h")
        val NOTIF_1H = booleanPreferencesKey("notif_1h")
        val NOTIF_DIA = booleanPreferencesKey("notif_dia")
        val NOTIF_COBROS = booleanPreferencesKey("notif_cobros")
        val METODOS_PAGO_OCULTOS = stringPreferencesKey("metodos_pago_ocultos")
    }

    val empresaNombre: Flow<String> = context.dataStore.data.map { it[Keys.EMPRESA_NOMBRE] ?: "" }
    val empresaTelefono: Flow<String> = context.dataStore.data.map { it[Keys.EMPRESA_TELEFONO] ?: "" }
    val empresaDireccion: Flow<String> = context.dataStore.data.map { it[Keys.EMPRESA_DIRECCION] ?: "" }
    val empresaLogoPath: Flow<String> = context.dataStore.data.map { it[Keys.EMPRESA_LOGO_PATH] ?: "" }
    val notif24h: Flow<Boolean> = context.dataStore.data.map { it[Keys.NOTIF_24H] ?: true }
    val notif1h: Flow<Boolean> = context.dataStore.data.map { it[Keys.NOTIF_1H] ?: true }
    val notifDia: Flow<Boolean> = context.dataStore.data.map { it[Keys.NOTIF_DIA] ?: true }
    val notifCobros: Flow<Boolean> = context.dataStore.data.map { it[Keys.NOTIF_COBROS] ?: true }

    suspend fun setEmpresaNombre(v: String) = context.dataStore.edit { it[Keys.EMPRESA_NOMBRE] = v }
    suspend fun setEmpresaTelefono(v: String) = context.dataStore.edit { it[Keys.EMPRESA_TELEFONO] = v }
    suspend fun setEmpresaDireccion(v: String) = context.dataStore.edit { it[Keys.EMPRESA_DIRECCION] = v }
    suspend fun setEmpresaLogoPath(v: String) = context.dataStore.edit { it[Keys.EMPRESA_LOGO_PATH] = v }
    suspend fun setNotif24h(v: Boolean) = context.dataStore.edit { it[Keys.NOTIF_24H] = v }
    suspend fun setNotif1h(v: Boolean) = context.dataStore.edit { it[Keys.NOTIF_1H] = v }
    suspend fun setNotifDia(v: Boolean) = context.dataStore.edit { it[Keys.NOTIF_DIA] = v }
    suspend fun setNotifCobros(v: Boolean) = context.dataStore.edit { it[Keys.NOTIF_COBROS] = v }
}
