package com.climapro.app.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.data.repository.MontajeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class RescheduleWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val montajeRepo: MontajeRepository,
    private val mantRepo: MantenimientoRepository,
    private val scheduler: NotificationScheduler
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val ahora = System.currentTimeMillis()
        montajeRepo.getProgramados().first().filter { it.fecha != null && it.fecha > ahora }.forEach {
            scheduler.scheduleMontaje(it)
        }
        mantRepo.getAll().first().filter { it.fecha != null && it.fecha > ahora }.forEach {
            scheduler.scheduleMantenimiento(it)
        }
        return Result.success()
    }
}
