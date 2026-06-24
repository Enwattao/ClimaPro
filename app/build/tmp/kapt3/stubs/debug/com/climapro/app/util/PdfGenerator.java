package com.climapro.app.util;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J:\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0002JF\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014JF\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020\u0014H\u0002J*\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140+0*H\u0002J(\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/climapro/app/util/PdfGenerator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "boldFont", "Lcom/itextpdf/text/Font;", "colBodyFont", "colHeaderFont", "normalFont", "sdf", "Ljava/text/SimpleDateFormat;", "smallFont", "subtitleFont", "titleFont", "cabecera", "", "doc", "Lcom/itextpdf/text/Document;", "nombre", "", "tel", "dir", "logoPath", "numAlbaran", "firmaSection", "firmaPath", "generarAlbaranMantenimiento", "Ljava/io/File;", "m", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "numeroAlbaran", "empresaNombre", "empresaTelefono", "empresaDireccion", "generarAlbaranMontaje", "montaje", "Lcom/climapro/app/data/db/entity/Montaje;", "seccion", "titulo", "tabla2col", "rows", "", "Lkotlin/Pair;", "tablaImportes", "presupuesto", "", "materiales", "cobrado", "app_debug"})
public final class PdfGenerator {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat sdf = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font colHeaderFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font colBodyFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font titleFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font subtitleFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font normalFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font boldFont = null;
    @org.jetbrains.annotations.NotNull()
    private final com.itextpdf.text.Font smallFont = null;
    
    @javax.inject.Inject()
    public PdfGenerator(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File generarAlbaranMontaje(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, @org.jetbrains.annotations.NotNull()
    java.lang.String numeroAlbaran, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaNombre, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaTelefono, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaDireccion, @org.jetbrains.annotations.Nullable()
    java.lang.String logoPath, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File generarAlbaranMantenimiento(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, @org.jetbrains.annotations.NotNull()
    java.lang.String numeroAlbaran, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaNombre, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaTelefono, @org.jetbrains.annotations.NotNull()
    java.lang.String empresaDireccion, @org.jetbrains.annotations.Nullable()
    java.lang.String logoPath, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath) {
        return null;
    }
    
    private final void cabecera(com.itextpdf.text.Document doc, java.lang.String nombre, java.lang.String tel, java.lang.String dir, java.lang.String logoPath, java.lang.String numAlbaran) {
    }
    
    private final void seccion(com.itextpdf.text.Document doc, java.lang.String titulo) {
    }
    
    private final void tabla2col(com.itextpdf.text.Document doc, java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> rows) {
    }
    
    private final void tablaImportes(com.itextpdf.text.Document doc, double presupuesto, double materiales, double cobrado) {
    }
    
    private final void firmaSection(com.itextpdf.text.Document doc, java.lang.String firmaPath) {
    }
}