# Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.paging.**

# Hilt
-dontwarn dagger.hilt.**

# Retrofit + Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep class retrofit2.** { *; }
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# iText PDF
-keep class com.itextpdf.** { *; }
-dontwarn com.itextpdf.**

# Modelos de datos
-keep class com.climapro.app.data.db.entity.** { *; }
-keep class com.climapro.app.util.UpdateChecker.** { *; }
