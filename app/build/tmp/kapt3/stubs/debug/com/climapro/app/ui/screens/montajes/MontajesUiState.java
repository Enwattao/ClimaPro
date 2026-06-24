package com.climapro.app.ui.screens.montajes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/climapro/app/ui/screens/montajes/MontajesUiState;", "", "tab", "Lcom/climapro/app/ui/screens/montajes/MontajesTab;", "programados", "", "Lcom/climapro/app/data/db/entity/Montaje;", "listaEspera", "realizados", "listaEsperaBadge", "", "(Lcom/climapro/app/ui/screens/montajes/MontajesTab;Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getListaEspera", "()Ljava/util/List;", "getListaEsperaBadge", "()I", "getProgramados", "getRealizados", "getTab", "()Lcom/climapro/app/ui/screens/montajes/MontajesTab;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class MontajesUiState {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.ui.screens.montajes.MontajesTab tab = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.climapro.app.data.db.entity.Montaje> programados = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.climapro.app.data.db.entity.Montaje> listaEspera = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.climapro.app.data.db.entity.Montaje> realizados = null;
    private final int listaEsperaBadge = 0;
    
    public MontajesUiState(@org.jetbrains.annotations.NotNull()
    com.climapro.app.ui.screens.montajes.MontajesTab tab, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> programados, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> listaEspera, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> realizados, int listaEsperaBadge) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.ui.screens.montajes.MontajesTab getTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> getProgramados() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> getListaEspera() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> getRealizados() {
        return null;
    }
    
    public final int getListaEsperaBadge() {
        return 0;
    }
    
    public MontajesUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.ui.screens.montajes.MontajesTab component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.climapro.app.data.db.entity.Montaje> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.ui.screens.montajes.MontajesUiState copy(@org.jetbrains.annotations.NotNull()
    com.climapro.app.ui.screens.montajes.MontajesTab tab, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> programados, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> listaEspera, @org.jetbrains.annotations.NotNull()
    java.util.List<com.climapro.app.data.db.entity.Montaje> realizados, int listaEsperaBadge) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}