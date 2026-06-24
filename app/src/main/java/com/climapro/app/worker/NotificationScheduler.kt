package com.climapro.app.worker

import android.content.Context
import androidx.work.*
import com.climapro.app.data.db.entity.Mantenimiento
import com.climapro.app.data.db.entity.Montaje
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationScheduler @Inject constructor(@ApplicationContext private val context: Context) {

    fun scheduleMontaje(montaje: Montaje) {
        val fecha = montaje.fecha ?: return
        val ahora = System.currentTimeMillis()

        // 24 horas antes
        val delay24h = fecha - ahora - TimeUnit.HOURS.toMillis(24)
        if (delay24h > 0) enqueue("montaje_24h_${montaje.id}", delay24h, montaje.id, "montaje", "Montaje mañana", montaje.nombreCliente)

        // 1 hora antes
        val delay1h = fecha - ahora - TimeUnit.HOURS.toMillis(1)
        if (delay1h > 0) enqueue("montaje_1h_${montaje.id}", delay1h, montaje.id, "montaje", "Montaje en 1 hora", montaje.nombreCliente)

        // El mismo día (a las 7:00)
        val delayDia = fecha - ahora - TimeUnit.HOURS.toMillis(9)
        if (delayDia > 0) enqueue("montaje_dia_${montaje.id}", delayDia, montaje.id, "montaje", "Montaje hoy", montaje.nombreCliente)
    }

    fun scheduleMantenimiento(m: Mantenimiento) {
        val fecha = m.fecha ?: return
        val ahora = System.currentTimeMillis()

        val delay24h = fecha - ahora - TimeUnit.HOURS.toMillis(24)
        if (delay24h > 0) enqueue("mant_24h_${m.id}", delay24h, m.id, "mantenimiento", "Mantenimiento mañana", m.nombreCliente)

        val delay1h = fecha - ahora - TimeUnit.HOURS.toMillis(1)
        if (delay1h > 0) enqueue("mant_1h_${m.id}", delay1h, m.id, "mantenimiento", "Mantenimiento en 1 hora", m.nombreCliente)
    }

    fun cancelMontaje(id: Long) {
        WorkManager.getInstance(context).cancelUniqueWork("montaje_24h_$id")
        WorkManager.getInstance(context).cancelUniqueWork("montaje_1h_$id")
        WorkManager.getInstance(context).cancelUniqueWork("montaje_dia_$id")
    }

    private fun enqueue(tag: String, delayMs: Long, trabajoId: Long, tipo: String, titulo: String, cliente: String) {
        val data = workDataOf(
            NotificationWorker.KEY_TITULO to titulo,
            NotificationWorker.KEY_MENSAJE to cliente,
            NotificationWorker.KEY_TRABAJO_ID to trabajoId,
            NotificationWorker.KEY_TIPO to tipo
        )
        val request = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(delayMs, TimeUnit.MILLISECONDS)
            .setInputData(data)
            .build()
        WorkManager.getInstance(context).enqueueUniqueWork(tag, ExistingWorkPolicy.REPLACE, request)
    }
}
