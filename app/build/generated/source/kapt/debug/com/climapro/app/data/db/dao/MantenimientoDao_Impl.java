package com.climapro.app.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.climapro.app.data.db.entity.EstadoCobro;
import com.climapro.app.data.db.entity.EstadoMantenimiento;
import com.climapro.app.data.db.entity.Mantenimiento;
import com.climapro.app.data.db.entity.MetodoPago;
import com.climapro.app.data.db.entity.Periodicidad;
import com.climapro.app.data.db.entity.TipoMantenimiento;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MantenimientoDao_Impl implements MantenimientoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Mantenimiento> __insertionAdapterOfMantenimiento;

  private final EntityDeletionOrUpdateAdapter<Mantenimiento> __deletionAdapterOfMantenimiento;

  private final EntityDeletionOrUpdateAdapter<Mantenimiento> __updateAdapterOfMantenimiento;

  public MantenimientoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMantenimiento = new EntityInsertionAdapter<Mantenimiento>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `mantenimientos` (`id`,`clienteId`,`nombreCliente`,`telefono`,`direccion`,`fecha`,`hora`,`tipoMantenimiento`,`observaciones`,`precio`,`costeMateriales`,`importeCobrado`,`periodicidad`,`estado`,`estadoCobro`,`metodoPago`,`fechaCobro`,`firmaPath`,`fechaCreacion`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Mantenimiento entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getClienteId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getClienteId());
        }
        if (entity.getNombreCliente() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNombreCliente());
        }
        if (entity.getTelefono() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTelefono());
        }
        if (entity.getDireccion() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDireccion());
        }
        if (entity.getFecha() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getFecha());
        }
        if (entity.getHora() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getHora());
        }
        statement.bindString(8, __TipoMantenimiento_enumToString(entity.getTipoMantenimiento()));
        if (entity.getObservaciones() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getObservaciones());
        }
        statement.bindDouble(10, entity.getPrecio());
        statement.bindDouble(11, entity.getCosteMateriales());
        statement.bindDouble(12, entity.getImporteCobrado());
        statement.bindString(13, __Periodicidad_enumToString(entity.getPeriodicidad()));
        statement.bindString(14, __EstadoMantenimiento_enumToString(entity.getEstado()));
        statement.bindString(15, __EstadoCobro_enumToString(entity.getEstadoCobro()));
        statement.bindString(16, __MetodoPago_enumToString(entity.getMetodoPago()));
        if (entity.getFechaCobro() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getFechaCobro());
        }
        if (entity.getFirmaPath() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getFirmaPath());
        }
        statement.bindLong(19, entity.getFechaCreacion());
      }
    };
    this.__deletionAdapterOfMantenimiento = new EntityDeletionOrUpdateAdapter<Mantenimiento>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `mantenimientos` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Mantenimiento entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfMantenimiento = new EntityDeletionOrUpdateAdapter<Mantenimiento>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `mantenimientos` SET `id` = ?,`clienteId` = ?,`nombreCliente` = ?,`telefono` = ?,`direccion` = ?,`fecha` = ?,`hora` = ?,`tipoMantenimiento` = ?,`observaciones` = ?,`precio` = ?,`costeMateriales` = ?,`importeCobrado` = ?,`periodicidad` = ?,`estado` = ?,`estadoCobro` = ?,`metodoPago` = ?,`fechaCobro` = ?,`firmaPath` = ?,`fechaCreacion` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Mantenimiento entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getClienteId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getClienteId());
        }
        if (entity.getNombreCliente() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNombreCliente());
        }
        if (entity.getTelefono() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTelefono());
        }
        if (entity.getDireccion() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDireccion());
        }
        if (entity.getFecha() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getFecha());
        }
        if (entity.getHora() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getHora());
        }
        statement.bindString(8, __TipoMantenimiento_enumToString(entity.getTipoMantenimiento()));
        if (entity.getObservaciones() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getObservaciones());
        }
        statement.bindDouble(10, entity.getPrecio());
        statement.bindDouble(11, entity.getCosteMateriales());
        statement.bindDouble(12, entity.getImporteCobrado());
        statement.bindString(13, __Periodicidad_enumToString(entity.getPeriodicidad()));
        statement.bindString(14, __EstadoMantenimiento_enumToString(entity.getEstado()));
        statement.bindString(15, __EstadoCobro_enumToString(entity.getEstadoCobro()));
        statement.bindString(16, __MetodoPago_enumToString(entity.getMetodoPago()));
        if (entity.getFechaCobro() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getFechaCobro());
        }
        if (entity.getFirmaPath() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getFirmaPath());
        }
        statement.bindLong(19, entity.getFechaCreacion());
        statement.bindLong(20, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Mantenimiento m, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfMantenimiento.insertAndReturnId(m);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Mantenimiento m, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMantenimiento.handle(m);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Mantenimiento m, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMantenimiento.handle(m);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Mantenimiento>> getAll() {
    final String _sql = "SELECT * FROM mantenimientos ORDER BY fecha ASC, fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"mantenimientos"}, new Callable<List<Mantenimiento>>() {
      @Override
      @NonNull
      public List<Mantenimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Mantenimiento> _result = new ArrayList<Mantenimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Mantenimiento _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Mantenimiento>> getByEstado(final EstadoMantenimiento estado) {
    final String _sql = "SELECT * FROM mantenimientos WHERE estado = ? ORDER BY fecha ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, __EstadoMantenimiento_enumToString(estado));
    return CoroutinesRoom.createFlow(__db, false, new String[] {"mantenimientos"}, new Callable<List<Mantenimiento>>() {
      @Override
      @NonNull
      public List<Mantenimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Mantenimiento> _result = new ArrayList<Mantenimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Mantenimiento _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Mantenimiento>> getEnRango(final long inicio, final long fin) {
    final String _sql = "SELECT * FROM mantenimientos WHERE fecha BETWEEN ? AND ? ORDER BY fecha ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, inicio);
    _argIndex = 2;
    _statement.bindLong(_argIndex, fin);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"mantenimientos"}, new Callable<List<Mantenimiento>>() {
      @Override
      @NonNull
      public List<Mantenimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Mantenimiento> _result = new ArrayList<Mantenimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Mantenimiento _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getById(final long id, final Continuation<? super Mantenimiento> $completion) {
    final String _sql = "SELECT * FROM mantenimientos WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Mantenimiento>() {
      @Override
      @Nullable
      public Mantenimiento call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final Mantenimiento _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _result = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Mantenimiento>> getByCliente(final long clienteId) {
    final String _sql = "SELECT * FROM mantenimientos WHERE clienteId = ? ORDER BY fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, clienteId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"mantenimientos"}, new Callable<List<Mantenimiento>>() {
      @Override
      @NonNull
      public List<Mantenimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Mantenimiento> _result = new ArrayList<Mantenimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Mantenimiento _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Mantenimiento>> buscar(final String q) {
    final String _sql = "\n"
            + "        SELECT * FROM mantenimientos WHERE\n"
            + "        nombreCliente LIKE '%' || ? || '%' OR\n"
            + "        direccion LIKE '%' || ? || '%'\n"
            + "        ORDER BY fecha DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    _argIndex = 2;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"mantenimientos"}, new Callable<List<Mantenimiento>>() {
      @Override
      @NonNull
      public List<Mantenimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfTipoMantenimiento = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMantenimiento");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfPeriodicidad = CursorUtil.getColumnIndexOrThrow(_cursor, "periodicidad");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Mantenimiento> _result = new ArrayList<Mantenimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Mantenimiento _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpClienteId;
            if (_cursor.isNull(_cursorIndexOfClienteId)) {
              _tmpClienteId = null;
            } else {
              _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final String _tmpDireccion;
            if (_cursor.isNull(_cursorIndexOfDireccion)) {
              _tmpDireccion = null;
            } else {
              _tmpDireccion = _cursor.getString(_cursorIndexOfDireccion);
            }
            final Long _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            }
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final TipoMantenimiento _tmpTipoMantenimiento;
            _tmpTipoMantenimiento = __TipoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfTipoMantenimiento));
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final Periodicidad _tmpPeriodicidad;
            _tmpPeriodicidad = __Periodicidad_stringToEnum(_cursor.getString(_cursorIndexOfPeriodicidad));
            final EstadoMantenimiento _tmpEstado;
            _tmpEstado = __EstadoMantenimiento_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
            final EstadoCobro _tmpEstadoCobro;
            _tmpEstadoCobro = __EstadoCobro_stringToEnum(_cursor.getString(_cursorIndexOfEstadoCobro));
            final MetodoPago _tmpMetodoPago;
            _tmpMetodoPago = __MetodoPago_stringToEnum(_cursor.getString(_cursorIndexOfMetodoPago));
            final Long _tmpFechaCobro;
            if (_cursor.isNull(_cursorIndexOfFechaCobro)) {
              _tmpFechaCobro = null;
            } else {
              _tmpFechaCobro = _cursor.getLong(_cursorIndexOfFechaCobro);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Mantenimiento(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpTipoMantenimiento,_tmpObservaciones,_tmpPrecio,_tmpCosteMateriales,_tmpImporteCobrado,_tmpPeriodicidad,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFirmaPath,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object sumPresupuesto(final long inicio, final long fin,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(precio) FROM mantenimientos WHERE fecha BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, inicio);
    _argIndex = 2;
    _statement.bindLong(_argIndex, fin);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object sumCobrado(final long inicio, final long fin,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(importeCobrado) FROM mantenimientos WHERE fecha BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, inicio);
    _argIndex = 2;
    _statement.bindLong(_argIndex, fin);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __TipoMantenimiento_enumToString(@NonNull final TipoMantenimiento _value) {
    switch (_value) {
      case LIMPIEZA: return "LIMPIEZA";
      case REVISION: return "REVISION";
      case RECARGA_GAS: return "RECARGA_GAS";
      case REPARACION: return "REPARACION";
      case PREVENTIVO: return "PREVENTIVO";
      case COMPLETO: return "COMPLETO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Periodicidad_enumToString(@NonNull final Periodicidad _value) {
    switch (_value) {
      case SIN_REPETIR: return "SIN_REPETIR";
      case MENSUAL: return "MENSUAL";
      case TRIMESTRAL: return "TRIMESTRAL";
      case SEMESTRAL: return "SEMESTRAL";
      case ANUAL: return "ANUAL";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __EstadoMantenimiento_enumToString(@NonNull final EstadoMantenimiento _value) {
    switch (_value) {
      case PENDIENTE: return "PENDIENTE";
      case REALIZADO: return "REALIZADO";
      case COBRADO: return "COBRADO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __EstadoCobro_enumToString(@NonNull final EstadoCobro _value) {
    switch (_value) {
      case PENDIENTE: return "PENDIENTE";
      case PARCIAL: return "PARCIAL";
      case COBRADO: return "COBRADO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __MetodoPago_enumToString(@NonNull final MetodoPago _value) {
    switch (_value) {
      case EFECTIVO: return "EFECTIVO";
      case BIZUM: return "BIZUM";
      case TRANSFERENCIA: return "TRANSFERENCIA";
      case TARJETA: return "TARJETA";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private TipoMantenimiento __TipoMantenimiento_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "LIMPIEZA": return TipoMantenimiento.LIMPIEZA;
      case "REVISION": return TipoMantenimiento.REVISION;
      case "RECARGA_GAS": return TipoMantenimiento.RECARGA_GAS;
      case "REPARACION": return TipoMantenimiento.REPARACION;
      case "PREVENTIVO": return TipoMantenimiento.PREVENTIVO;
      case "COMPLETO": return TipoMantenimiento.COMPLETO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Periodicidad __Periodicidad_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "SIN_REPETIR": return Periodicidad.SIN_REPETIR;
      case "MENSUAL": return Periodicidad.MENSUAL;
      case "TRIMESTRAL": return Periodicidad.TRIMESTRAL;
      case "SEMESTRAL": return Periodicidad.SEMESTRAL;
      case "ANUAL": return Periodicidad.ANUAL;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private EstadoMantenimiento __EstadoMantenimiento_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PENDIENTE": return EstadoMantenimiento.PENDIENTE;
      case "REALIZADO": return EstadoMantenimiento.REALIZADO;
      case "COBRADO": return EstadoMantenimiento.COBRADO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private EstadoCobro __EstadoCobro_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PENDIENTE": return EstadoCobro.PENDIENTE;
      case "PARCIAL": return EstadoCobro.PARCIAL;
      case "COBRADO": return EstadoCobro.COBRADO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private MetodoPago __MetodoPago_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "EFECTIVO": return MetodoPago.EFECTIVO;
      case "BIZUM": return MetodoPago.BIZUM;
      case "TRANSFERENCIA": return MetodoPago.TRANSFERENCIA;
      case "TARJETA": return MetodoPago.TARJETA;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
