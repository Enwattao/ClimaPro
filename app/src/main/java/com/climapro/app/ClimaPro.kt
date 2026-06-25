package com.climapro.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.AudioAttributes
import android.os.Build
import android.provider.Settings
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
            val audioAttr = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            val sonido = Settings.System.DEFAULT_NOTIFICATION_URI

            nm.createNotificationChannel(NotificationChannel("climapro_recordatorios", "Recordatorios de trabajo", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Avisos para montajes y mantenimientos programados"
                setSound(sonido, audioAttr)
                enableVibration(true)
                vibrationPattern = longArrayOf(0, 300, 200, 300)
            })
            nm.createNotificationChannel(NotificationChannel("climapro_notas", "Notas y recordatorios", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Recordatorios de notas personales"
                setSound(sonido, audioAttr)
                enableVibration(true)
                vibrationPattern = longArrayOf(0, 200, 100, 200)
            })
            nm.createNotificationChannel(NotificationChannel("climapro_cobros", "Cobros pendientes", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Avisos de cobros pendientes"
                setSound(sonido, audioAttr)
                enableVibration(true)
            })
        }
    }
}
