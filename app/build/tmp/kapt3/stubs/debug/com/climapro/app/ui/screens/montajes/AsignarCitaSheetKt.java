package com.climapro.app.ui.screens.montajes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aP\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0018H\u0003\u001a\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u00a8\u0006\u001e"}, d2 = {"AsignarCitaSheet", "", "montaje", "Lcom/climapro/app/data/db/entity/Montaje;", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "fecha", "", "hora", "", "horasEstimadas", "MiniCalendar", "year", "", "month", "selectedDay", "onPrev", "onNext", "onDaySelect", "Lkotlin/Function1;", "SimpleDateFormat", "Ljava/text/SimpleDateFormat;", "pattern", "locale", "Ljava/util/Locale;", "app_debug"})
public final class AsignarCitaSheetKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AsignarCitaSheet(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.Long, ? super java.lang.String, ? super java.lang.Float, kotlin.Unit> onConfirm) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MiniCalendar(int year, int month, int selectedDay, kotlin.jvm.functions.Function0<kotlin.Unit> onPrev, kotlin.jvm.functions.Function0<kotlin.Unit> onNext, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onDaySelect) {
    }
    
    private static final java.text.SimpleDateFormat SimpleDateFormat(java.lang.String pattern, java.util.Locale locale) {
        return null;
    }
}