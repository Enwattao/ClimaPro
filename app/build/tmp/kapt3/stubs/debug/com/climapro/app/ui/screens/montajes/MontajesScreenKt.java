package com.climapro.app.ui.screens.montajes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a:\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003\u001a\u001a\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u001a,\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"Chip", "", "text", "", "bg", "Landroidx/compose/ui/graphics/Color;", "textColor", "Chip-WkMS-hQ", "(Ljava/lang/String;JJ)V", "EsperaCard", "montaje", "Lcom/climapro/app/data/db/entity/Montaje;", "onClick", "Lkotlin/Function0;", "onAsignarCita", "onEliminar", "InfoBanner", "MontajeCard", "MontajesScreen", "navController", "Landroidx/navigation/NavController;", "vm", "Lcom/climapro/app/ui/screens/montajes/MontajesViewModel;", "TabRow", "tab", "Lcom/climapro/app/ui/screens/montajes/MontajesTab;", "onSelect", "Lkotlin/Function1;", "badge", "", "app_debug"})
public final class MontajesScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MontajesScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.climapro.app.ui.screens.montajes.MontajesViewModel vm) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TabRow(com.climapro.app.ui.screens.montajes.MontajesTab tab, kotlin.jvm.functions.Function1<? super com.climapro.app.ui.screens.montajes.MontajesTab, kotlin.Unit> onSelect, int badge) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InfoBanner(java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EsperaCard(com.climapro.app.data.db.entity.Montaje montaje, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, kotlin.jvm.functions.Function0<kotlin.Unit> onAsignarCita, kotlin.jvm.functions.Function0<kotlin.Unit> onEliminar) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MontajeCard(com.climapro.app.data.db.entity.Montaje montaje, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}