package com.climapro.app.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/climapro/app/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "albaranDao", "Lcom/climapro/app/data/db/dao/AlbaranDao;", "clienteDao", "Lcom/climapro/app/data/db/dao/ClienteDao;", "fotoDao", "Lcom/climapro/app/data/db/dao/FotoDao;", "mantenimientoDao", "Lcom/climapro/app/data/db/dao/MantenimientoDao;", "montajeDao", "Lcom/climapro/app/data/db/dao/MontajeDao;", "app_debug"})
@androidx.room.Database(entities = {com.climapro.app.data.db.entity.Cliente.class, com.climapro.app.data.db.entity.Montaje.class, com.climapro.app.data.db.entity.Mantenimiento.class, com.climapro.app.data.db.entity.Foto.class, com.climapro.app.data.db.entity.Albaran.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.climapro.app.data.db.dao.ClienteDao clienteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.climapro.app.data.db.dao.MontajeDao montajeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.climapro.app.data.db.dao.MantenimientoDao mantenimientoDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.climapro.app.data.db.dao.FotoDao fotoDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.climapro.app.data.db.dao.AlbaranDao albaranDao();
}