package com.climapro.app.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.climapro.app.data.db.dao.AlbaranDao;
import com.climapro.app.data.db.dao.AlbaranDao_Impl;
import com.climapro.app.data.db.dao.ClienteDao;
import com.climapro.app.data.db.dao.ClienteDao_Impl;
import com.climapro.app.data.db.dao.FotoDao;
import com.climapro.app.data.db.dao.FotoDao_Impl;
import com.climapro.app.data.db.dao.MantenimientoDao;
import com.climapro.app.data.db.dao.MantenimientoDao_Impl;
import com.climapro.app.data.db.dao.MontajeDao;
import com.climapro.app.data.db.dao.MontajeDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ClienteDao _clienteDao;

  private volatile MontajeDao _montajeDao;

  private volatile MantenimientoDao _mantenimientoDao;

  private volatile FotoDao _fotoDao;

  private volatile AlbaranDao _albaranDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `clientes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `telefono` TEXT NOT NULL, `direccion` TEXT NOT NULL, `email` TEXT NOT NULL, `notas` TEXT NOT NULL, `fechaCreacion` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `montajes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `clienteId` INTEGER, `nombreCliente` TEXT NOT NULL, `telefono` TEXT NOT NULL, `direccion` TEXT NOT NULL, `fecha` INTEGER, `hora` TEXT NOT NULL, `horasEstimadas` REAL NOT NULL, `marcaMaquina` TEXT NOT NULL, `modeloMaquina` TEXT NOT NULL, `tipoMaquina` TEXT NOT NULL, `numMaquinas` INTEGER NOT NULL, `presupuesto` REAL NOT NULL, `costeMateriales` REAL NOT NULL, `importeCobrado` REAL NOT NULL, `estado` TEXT NOT NULL, `estadoCobro` TEXT NOT NULL, `metodoPago` TEXT NOT NULL, `fechaCobro` INTEGER, `fechaFinalizacion` INTEGER, `observaciones` TEXT NOT NULL, `firmaPath` TEXT, `urgente` INTEGER NOT NULL, `fechaCreacion` INTEGER NOT NULL, FOREIGN KEY(`clienteId`) REFERENCES `clientes`(`id`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_montajes_clienteId` ON `montajes` (`clienteId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `mantenimientos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `clienteId` INTEGER, `nombreCliente` TEXT NOT NULL, `telefono` TEXT NOT NULL, `direccion` TEXT NOT NULL, `fecha` INTEGER, `hora` TEXT NOT NULL, `tipoMantenimiento` TEXT NOT NULL, `observaciones` TEXT NOT NULL, `precio` REAL NOT NULL, `costeMateriales` REAL NOT NULL, `importeCobrado` REAL NOT NULL, `periodicidad` TEXT NOT NULL, `estado` TEXT NOT NULL, `estadoCobro` TEXT NOT NULL, `metodoPago` TEXT NOT NULL, `fechaCobro` INTEGER, `firmaPath` TEXT, `fechaCreacion` INTEGER NOT NULL, FOREIGN KEY(`clienteId`) REFERENCES `clientes`(`id`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_mantenimientos_clienteId` ON `mantenimientos` (`clienteId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `fotos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `trabajoId` INTEGER NOT NULL, `tipoTrabajo` TEXT NOT NULL, `tipoFoto` TEXT NOT NULL, `rutaArchivo` TEXT NOT NULL, `fechaCaptura` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `albaranes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `numero` TEXT NOT NULL, `trabajoId` INTEGER NOT NULL, `tipoTrabajo` TEXT NOT NULL, `rutaPdf` TEXT NOT NULL, `fechaGeneracion` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dbe23a97e6df993bcb6423b21277ac28')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `clientes`");
        db.execSQL("DROP TABLE IF EXISTS `montajes`");
        db.execSQL("DROP TABLE IF EXISTS `mantenimientos`");
        db.execSQL("DROP TABLE IF EXISTS `fotos`");
        db.execSQL("DROP TABLE IF EXISTS `albaranes`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsClientes = new HashMap<String, TableInfo.Column>(7);
        _columnsClientes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("telefono", new TableInfo.Column("telefono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("direccion", new TableInfo.Column("direccion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("notas", new TableInfo.Column("notas", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("fechaCreacion", new TableInfo.Column("fechaCreacion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientes = new TableInfo("clientes", _columnsClientes, _foreignKeysClientes, _indicesClientes);
        final TableInfo _existingClientes = TableInfo.read(db, "clientes");
        if (!_infoClientes.equals(_existingClientes)) {
          return new RoomOpenHelper.ValidationResult(false, "clientes(com.climapro.app.data.db.entity.Cliente).\n"
                  + " Expected:\n" + _infoClientes + "\n"
                  + " Found:\n" + _existingClientes);
        }
        final HashMap<String, TableInfo.Column> _columnsMontajes = new HashMap<String, TableInfo.Column>(24);
        _columnsMontajes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("clienteId", new TableInfo.Column("clienteId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("nombreCliente", new TableInfo.Column("nombreCliente", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("telefono", new TableInfo.Column("telefono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("direccion", new TableInfo.Column("direccion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("fecha", new TableInfo.Column("fecha", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("hora", new TableInfo.Column("hora", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("horasEstimadas", new TableInfo.Column("horasEstimadas", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("marcaMaquina", new TableInfo.Column("marcaMaquina", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("modeloMaquina", new TableInfo.Column("modeloMaquina", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("tipoMaquina", new TableInfo.Column("tipoMaquina", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("numMaquinas", new TableInfo.Column("numMaquinas", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("presupuesto", new TableInfo.Column("presupuesto", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("costeMateriales", new TableInfo.Column("costeMateriales", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("importeCobrado", new TableInfo.Column("importeCobrado", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("estado", new TableInfo.Column("estado", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("estadoCobro", new TableInfo.Column("estadoCobro", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("metodoPago", new TableInfo.Column("metodoPago", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("fechaCobro", new TableInfo.Column("fechaCobro", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("fechaFinalizacion", new TableInfo.Column("fechaFinalizacion", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("observaciones", new TableInfo.Column("observaciones", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("firmaPath", new TableInfo.Column("firmaPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("urgente", new TableInfo.Column("urgente", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMontajes.put("fechaCreacion", new TableInfo.Column("fechaCreacion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMontajes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMontajes.add(new TableInfo.ForeignKey("clientes", "SET NULL", "NO ACTION", Arrays.asList("clienteId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMontajes = new HashSet<TableInfo.Index>(1);
        _indicesMontajes.add(new TableInfo.Index("index_montajes_clienteId", false, Arrays.asList("clienteId"), Arrays.asList("ASC")));
        final TableInfo _infoMontajes = new TableInfo("montajes", _columnsMontajes, _foreignKeysMontajes, _indicesMontajes);
        final TableInfo _existingMontajes = TableInfo.read(db, "montajes");
        if (!_infoMontajes.equals(_existingMontajes)) {
          return new RoomOpenHelper.ValidationResult(false, "montajes(com.climapro.app.data.db.entity.Montaje).\n"
                  + " Expected:\n" + _infoMontajes + "\n"
                  + " Found:\n" + _existingMontajes);
        }
        final HashMap<String, TableInfo.Column> _columnsMantenimientos = new HashMap<String, TableInfo.Column>(19);
        _columnsMantenimientos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("clienteId", new TableInfo.Column("clienteId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("nombreCliente", new TableInfo.Column("nombreCliente", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("telefono", new TableInfo.Column("telefono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("direccion", new TableInfo.Column("direccion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("fecha", new TableInfo.Column("fecha", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("hora", new TableInfo.Column("hora", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("tipoMantenimiento", new TableInfo.Column("tipoMantenimiento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("observaciones", new TableInfo.Column("observaciones", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("precio", new TableInfo.Column("precio", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("costeMateriales", new TableInfo.Column("costeMateriales", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("importeCobrado", new TableInfo.Column("importeCobrado", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("periodicidad", new TableInfo.Column("periodicidad", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("estado", new TableInfo.Column("estado", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("estadoCobro", new TableInfo.Column("estadoCobro", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("metodoPago", new TableInfo.Column("metodoPago", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("fechaCobro", new TableInfo.Column("fechaCobro", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("firmaPath", new TableInfo.Column("firmaPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMantenimientos.put("fechaCreacion", new TableInfo.Column("fechaCreacion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMantenimientos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMantenimientos.add(new TableInfo.ForeignKey("clientes", "SET NULL", "NO ACTION", Arrays.asList("clienteId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMantenimientos = new HashSet<TableInfo.Index>(1);
        _indicesMantenimientos.add(new TableInfo.Index("index_mantenimientos_clienteId", false, Arrays.asList("clienteId"), Arrays.asList("ASC")));
        final TableInfo _infoMantenimientos = new TableInfo("mantenimientos", _columnsMantenimientos, _foreignKeysMantenimientos, _indicesMantenimientos);
        final TableInfo _existingMantenimientos = TableInfo.read(db, "mantenimientos");
        if (!_infoMantenimientos.equals(_existingMantenimientos)) {
          return new RoomOpenHelper.ValidationResult(false, "mantenimientos(com.climapro.app.data.db.entity.Mantenimiento).\n"
                  + " Expected:\n" + _infoMantenimientos + "\n"
                  + " Found:\n" + _existingMantenimientos);
        }
        final HashMap<String, TableInfo.Column> _columnsFotos = new HashMap<String, TableInfo.Column>(6);
        _columnsFotos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFotos.put("trabajoId", new TableInfo.Column("trabajoId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFotos.put("tipoTrabajo", new TableInfo.Column("tipoTrabajo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFotos.put("tipoFoto", new TableInfo.Column("tipoFoto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFotos.put("rutaArchivo", new TableInfo.Column("rutaArchivo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFotos.put("fechaCaptura", new TableInfo.Column("fechaCaptura", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFotos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFotos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFotos = new TableInfo("fotos", _columnsFotos, _foreignKeysFotos, _indicesFotos);
        final TableInfo _existingFotos = TableInfo.read(db, "fotos");
        if (!_infoFotos.equals(_existingFotos)) {
          return new RoomOpenHelper.ValidationResult(false, "fotos(com.climapro.app.data.db.entity.Foto).\n"
                  + " Expected:\n" + _infoFotos + "\n"
                  + " Found:\n" + _existingFotos);
        }
        final HashMap<String, TableInfo.Column> _columnsAlbaranes = new HashMap<String, TableInfo.Column>(6);
        _columnsAlbaranes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbaranes.put("numero", new TableInfo.Column("numero", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbaranes.put("trabajoId", new TableInfo.Column("trabajoId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbaranes.put("tipoTrabajo", new TableInfo.Column("tipoTrabajo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbaranes.put("rutaPdf", new TableInfo.Column("rutaPdf", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlbaranes.put("fechaGeneracion", new TableInfo.Column("fechaGeneracion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlbaranes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlbaranes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlbaranes = new TableInfo("albaranes", _columnsAlbaranes, _foreignKeysAlbaranes, _indicesAlbaranes);
        final TableInfo _existingAlbaranes = TableInfo.read(db, "albaranes");
        if (!_infoAlbaranes.equals(_existingAlbaranes)) {
          return new RoomOpenHelper.ValidationResult(false, "albaranes(com.climapro.app.data.db.entity.Albaran).\n"
                  + " Expected:\n" + _infoAlbaranes + "\n"
                  + " Found:\n" + _existingAlbaranes);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dbe23a97e6df993bcb6423b21277ac28", "96a372456b21a32b4b57d3e065d41edc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "clientes","montajes","mantenimientos","fotos","albaranes");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `clientes`");
      _db.execSQL("DELETE FROM `montajes`");
      _db.execSQL("DELETE FROM `mantenimientos`");
      _db.execSQL("DELETE FROM `fotos`");
      _db.execSQL("DELETE FROM `albaranes`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ClienteDao.class, ClienteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MontajeDao.class, MontajeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MantenimientoDao.class, MantenimientoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FotoDao.class, FotoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlbaranDao.class, AlbaranDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ClienteDao clienteDao() {
    if (_clienteDao != null) {
      return _clienteDao;
    } else {
      synchronized(this) {
        if(_clienteDao == null) {
          _clienteDao = new ClienteDao_Impl(this);
        }
        return _clienteDao;
      }
    }
  }

  @Override
  public MontajeDao montajeDao() {
    if (_montajeDao != null) {
      return _montajeDao;
    } else {
      synchronized(this) {
        if(_montajeDao == null) {
          _montajeDao = new MontajeDao_Impl(this);
        }
        return _montajeDao;
      }
    }
  }

  @Override
  public MantenimientoDao mantenimientoDao() {
    if (_mantenimientoDao != null) {
      return _mantenimientoDao;
    } else {
      synchronized(this) {
        if(_mantenimientoDao == null) {
          _mantenimientoDao = new MantenimientoDao_Impl(this);
        }
        return _mantenimientoDao;
      }
    }
  }

  @Override
  public FotoDao fotoDao() {
    if (_fotoDao != null) {
      return _fotoDao;
    } else {
      synchronized(this) {
        if(_fotoDao == null) {
          _fotoDao = new FotoDao_Impl(this);
        }
        return _fotoDao;
      }
    }
  }

  @Override
  public AlbaranDao albaranDao() {
    if (_albaranDao != null) {
      return _albaranDao;
    } else {
      synchronized(this) {
        if(_albaranDao == null) {
          _albaranDao = new AlbaranDao_Impl(this);
        }
        return _albaranDao;
      }
    }
  }
}
