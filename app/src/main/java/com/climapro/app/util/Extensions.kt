package com.climapro.app.util

import com.climapro.app.data.db.entity.*
import java.text.SimpleDateFormat
import java.util.*

fun Long.toFechaCorta(): String = SimpleDateFormat("dd MMM yyyy", Locale("es")).format(Date(this))
fun Long.toFechaLarga(): String = SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", Locale("es")).format(Date(this))
fun Long.toFechaHora(hora: String): String = "${toFechaCorta()} $hora"

fun EstadoMontaje.label() = when (this) {
    EstadoMontaje.LISTA_ESPERA -> "Lista de espera"
    EstadoMontaje.PENDIENTE -> "Pendiente"
    EstadoMontaje.EN_CURSO -> "En curso"
    EstadoMontaje.REALIZADO -> "Realizado"
    EstadoMontaje.COBRADO -> "Cobrado"
}

fun EstadoMantenimiento.label() = when (this) {
    EstadoMantenimiento.PENDIENTE -> "Pendiente"
    EstadoMantenimiento.REALIZADO -> "Realizado"
    EstadoMantenimiento.COBRADO -> "Cobrado"
}

fun EstadoCobro.label() = when (this) {
    EstadoCobro.PENDIENTE -> "Pendiente"
    EstadoCobro.PARCIAL -> "Parcialmente cobrado"
    EstadoCobro.COBRADO -> "Cobrado"
}

fun MetodoPago.label() = when (this) {
    MetodoPago.EFECTIVO -> "Efectivo"
    MetodoPago.BIZUM -> "Bizum"
    MetodoPago.TRANSFERENCIA -> "Transferencia"
    MetodoPago.TARJETA -> "Tarjeta"
}

fun Periodicidad.label() = when (this) {
    Periodicidad.SIN_REPETIR -> "Sin repetir"
    Periodicidad.MENSUAL -> "Mensual"
    Periodicidad.TRIMESTRAL -> "Trimestral"
    Periodicidad.SEMESTRAL -> "Semestral"
    Periodicidad.ANUAL -> "Anual"
}

fun TipoMantenimiento.label() = when (this) {
    TipoMantenimiento.LIMPIEZA -> "Limpieza"
    TipoMantenimiento.REVISION -> "Revisión"
    TipoMantenimiento.RECARGA_GAS -> "Recarga de gas"
    TipoMantenimiento.REPARACION -> "Reparación"
    TipoMantenimiento.PREVENTIVO -> "Preventivo"
    TipoMantenimiento.COMPLETO -> "Completo"
}

fun TipoMaquina.label() = when (this) {
    TipoMaquina.SPLIT_PARED -> "Split pared"
    TipoMaquina.SPLIT_CASSETTE -> "Split cassette"
    TipoMaquina.SPLIT_SUELO_TECHO -> "Split suelo/techo"
    TipoMaquina.MULTI_SPLIT -> "Multi split"
    TipoMaquina.CONDUCTOS -> "Conductos"
    TipoMaquina.VRF -> "VRF"
    TipoMaquina.OTRO -> "Otro"
}

fun EstadoAveria.label() = when (this) {
    EstadoAveria.PENDIENTE -> "Pendiente"
    EstadoAveria.EN_CURSO -> "En curso"
    EstadoAveria.RESUELTA -> "Resuelta"
    EstadoAveria.COBRADA -> "Cobrada"
}

fun CategoriaGasto.label() = when (this) {
    CategoriaGasto.MATERIALES -> "Materiales"
    CategoriaGasto.SUELDO_AYUDANTE -> "Sueldo ayudante"
    CategoriaGasto.HERRAMIENTAS -> "Herramientas"
    CategoriaGasto.COMBUSTIBLE -> "Combustible"
    CategoriaGasto.SEGUROS -> "Seguros"
    CategoriaGasto.OTROS -> "Otros"
}

fun Double.toEuros(): String = String.format(Locale("es"), "%.2f €", this)

fun iniciales(nombre: String): String {
    val partes = nombre.trim().split(" ")
    return when {
        partes.size >= 2 -> "${partes[0].firstOrNull() ?: ""}${partes[1].firstOrNull() ?: ""}".uppercase()
        partes.size == 1 -> partes[0].take(2).uppercase()
        else -> "??"
    }
}
