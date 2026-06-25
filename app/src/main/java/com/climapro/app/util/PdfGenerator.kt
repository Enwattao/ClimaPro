package com.climapro.app.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.itextpdf.text.*
import com.itextpdf.text.pdf.*
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.db.entity.Mantenimiento
import com.climapro.app.data.db.entity.TipoTrabajo
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PdfGenerator @Inject constructor(@ApplicationContext private val context: Context) {

    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("es"))
    private val colHeaderFont = Font(Font.FontFamily.HELVETICA, 9f, Font.BOLD, BaseColor.WHITE)
    private val colBodyFont = Font(Font.FontFamily.HELVETICA, 9f, Font.NORMAL, BaseColor.DARK_GRAY)
    private val titleFont = Font(Font.FontFamily.HELVETICA, 18f, Font.BOLD, BaseColor(26, 31, 58))
    private val subtitleFont = Font(Font.FontFamily.HELVETICA, 10f, Font.BOLD, BaseColor(74, 108, 247))
    private val normalFont = Font(Font.FontFamily.HELVETICA, 9f)
    private val boldFont = Font(Font.FontFamily.HELVETICA, 9f, Font.BOLD)
    private val smallFont = Font(Font.FontFamily.HELVETICA, 8f, Font.NORMAL, BaseColor.GRAY)

    private fun albaranesDir(): File =
        File(context.getExternalFilesDir(null) ?: context.filesDir, "Albaranes").apply { mkdirs() }

    fun generarAlbaranMontaje(
        montaje: Montaje,
        numeroAlbaran: String,
        empresaNombre: String,
        empresaTelefono: String,
        empresaDireccion: String,
        logoPath: String? = null,
        firmaPath: String? = null
    ): File {
        val dir = albaranesDir()
        val file = File(dir, "albaran_$numeroAlbaran.pdf")
        val doc = Document(PageSize.A4, 40f, 40f, 40f, 40f)
        PdfWriter.getInstance(doc, FileOutputStream(file))
        doc.open()

        // Cabecera empresa
        cabecera(doc, empresaNombre, empresaTelefono, empresaDireccion, logoPath, numeroAlbaran)

        // Datos cliente
        seccion(doc, "DATOS DEL CLIENTE")
        tabla2col(doc, listOf("Nombre" to montaje.nombreCliente, "Teléfono" to montaje.telefono, "Dirección" to montaje.direccion))

        // Datos del trabajo
        seccion(doc, "DATOS DEL TRABAJO")
        tabla2col(doc, buildList {
            add("Tipo de trabajo" to "Montaje de climatización")
            add("Fecha" to (montaje.fecha?.let { sdf.format(Date(it)) } ?: "-"))
            if (montaje.marcaMaquina.isNotEmpty()) add("Marca" to montaje.marcaMaquina)
            if (montaje.modeloMaquina.isNotEmpty()) add("Modelo" to montaje.modeloMaquina)
            add("Tipo de equipo" to montaje.tipoMaquina.label())
            add("Cantidad" to "${montaje.numMaquinas} unidad(es)")
        })

        if (montaje.observaciones.isNotEmpty()) {
            seccion(doc, "TRABAJOS REALIZADOS / OBSERVACIONES")
            doc.add(Paragraph(montaje.observaciones, normalFont).apply { spacingAfter = 10f })
        }

        // Importes
        seccion(doc, "IMPORTES")
        tablaImportes(doc, montaje.presupuesto, montaje.costeMateriales, montaje.importeCobrado)

        // Firma
        firmaSection(doc, firmaPath)

        doc.close()
        return file
    }

    fun generarAlbaranMantenimiento(
        m: Mantenimiento,
        numeroAlbaran: String,
        empresaNombre: String,
        empresaTelefono: String,
        empresaDireccion: String,
        logoPath: String? = null,
        firmaPath: String? = null
    ): File {
        val dir = albaranesDir()
        val file = File(dir, "albaran_$numeroAlbaran.pdf")
        val doc = Document(PageSize.A4, 40f, 40f, 40f, 40f)
        PdfWriter.getInstance(doc, FileOutputStream(file))
        doc.open()

        cabecera(doc, empresaNombre, empresaTelefono, empresaDireccion, logoPath, numeroAlbaran)

        seccion(doc, "DATOS DEL CLIENTE")
        tabla2col(doc, listOf("Nombre" to m.nombreCliente, "Teléfono" to m.telefono, "Dirección" to m.direccion))

        seccion(doc, "DATOS DEL TRABAJO")
        tabla2col(doc, buildList {
            add("Tipo de trabajo" to "Mantenimiento de climatización")
            add("Tipo de mantenimiento" to m.tipoMantenimiento.label())
            add("Fecha" to (m.fecha?.let { sdf.format(Date(it)) } ?: "-"))
            add("Periodicidad" to m.periodicidad.label())
        })

        if (m.observaciones.isNotEmpty()) {
            seccion(doc, "OBSERVACIONES")
            doc.add(Paragraph(m.observaciones, normalFont).apply { spacingAfter = 10f })
        }

        seccion(doc, "IMPORTES")
        tablaImportes(doc, m.precio, m.costeMateriales, m.importeCobrado)

        firmaSection(doc, firmaPath)
        doc.close()
        return file
    }

    private fun cabecera(doc: Document, nombre: String, tel: String, dir: String, logoPath: String?, numAlbaran: String) {
        val table = PdfPTable(2).apply { widthPercentage = 100f; setWidths(floatArrayOf(1f, 1f)); spacingAfter = 16f }

        // Logo o nombre empresa
        val cellLeft = PdfPCell().apply { border = Rectangle.NO_BORDER; paddingBottom = 8f }
        if (logoPath != null && File(logoPath).exists()) {
            val img = Image.getInstance(logoPath).apply { scaleToFit(120f, 60f) }
            cellLeft.addElement(img)
        } else {
            cellLeft.addElement(Paragraph(nombre.ifEmpty { "Mi Empresa" }, titleFont))
        }
        if (tel.isNotEmpty()) cellLeft.addElement(Paragraph(tel, normalFont))
        if (dir.isNotEmpty()) cellLeft.addElement(Paragraph(dir, smallFont))
        table.addCell(cellLeft)

        // Datos albarán
        val cellRight = PdfPCell().apply {
            border = Rectangle.NO_BORDER; horizontalAlignment = Element.ALIGN_RIGHT; paddingBottom = 8f
        }
        cellRight.addElement(Paragraph("ALBARÁN", Font(Font.FontFamily.HELVETICA, 14f, Font.BOLD, BaseColor(74, 108, 247))).apply { alignment = Element.ALIGN_RIGHT })
        cellRight.addElement(Paragraph("Nº $numAlbaran", boldFont).apply { alignment = Element.ALIGN_RIGHT })
        cellRight.addElement(Paragraph("Fecha: ${sdf.format(Date())}", normalFont).apply { alignment = Element.ALIGN_RIGHT })
        table.addCell(cellRight)

        doc.add(table)

        // Línea separadora
        val line = PdfPTable(1).apply { widthPercentage = 100f; spacingAfter = 12f }
        line.addCell(PdfPCell().apply { backgroundColor = BaseColor(74, 108, 247); fixedHeight = 2f; border = Rectangle.NO_BORDER })
        doc.add(line)
    }

    private fun seccion(doc: Document, titulo: String) {
        doc.add(Paragraph(titulo, subtitleFont).apply { spacingBefore = 10f; spacingAfter = 4f })
    }

    private fun tabla2col(doc: Document, rows: List<Pair<String, String>>) {
        val table = PdfPTable(2).apply { widthPercentage = 100f; setWidths(floatArrayOf(1f, 2f)); spacingAfter = 10f }
        rows.forEach { (k, v) ->
            table.addCell(PdfPCell(Phrase(k, boldFont)).apply { backgroundColor = BaseColor(240, 242, 247); border = Rectangle.BOX; borderColor = BaseColor(220, 224, 236); setPadding(5f) })
            table.addCell(PdfPCell(Phrase(v, normalFont)).apply { border = Rectangle.BOX; borderColor = BaseColor(220, 224, 236); setPadding(5f) })
        }
        doc.add(table)
    }

    private fun tablaImportes(doc: Document, presupuesto: Double, materiales: Double, cobrado: Double) {
        val table = PdfPTable(2).apply { widthPercentage = 60f; horizontalAlignment = Element.ALIGN_RIGHT; spacingAfter = 20f }
        fun row(k: String, v: String, bold: Boolean = false) {
            val f = if (bold) boldFont else normalFont
            table.addCell(PdfPCell(Phrase(k, f)).apply { border = Rectangle.BOX; borderColor = BaseColor(220, 224, 236); setPadding(5f) })
            table.addCell(PdfPCell(Phrase(v, f)).apply { border = Rectangle.BOX; borderColor = BaseColor(220, 224, 236); setPadding(5f); horizontalAlignment = Element.ALIGN_RIGHT })
        }
        if (presupuesto > 0) row("Precio trabajo", presupuesto.toEuros())
        if (materiales > 0) row("Materiales", materiales.toEuros())
        row("TOTAL", cobrado.toEuros(), bold = true)
        doc.add(table)
    }

    private fun firmaSection(doc: Document, firmaPath: String?) {
        seccion(doc, "FIRMA DEL CLIENTE")
        val table = PdfPTable(1).apply { widthPercentage = 50f }
        val cell = PdfPCell().apply { fixedHeight = 80f; border = Rectangle.BOX; borderColor = BaseColor(200, 200, 210) }
        if (firmaPath != null && File(firmaPath).exists()) {
            val img = Image.getInstance(firmaPath).apply { scaleToFit(180f, 70f) }
            cell.addElement(img)
        } else {
            cell.addElement(Paragraph("Firma:", smallFont))
        }
        table.addCell(cell)
        doc.add(table)
        doc.add(Paragraph("\n\nDocumento de entrega. No es una factura.", smallFont))
    }
}
