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
import com.climapro.app.data.db.entity.EstadoMontaje;
import com.climapro.app.data.db.entity.MetodoPago;
import com.climapro.app.data.db.entity.Montaje;
import com.climapro.app.data.db.entity.TipoMaquina;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
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
public final class MontajeDao_Impl implements MontajeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Montaje> __insertionAdapterOfMontaje;

  private final EntityDeletionOrUpdateAdapter<Montaje> __deletionAdapterOfMontaje;

  private final EntityDeletionOrUpdateAdapter<Montaje> __updateAdapterOfMontaje;

  public MontajeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMontaje = new EntityInsertionAdapter<Montaje>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `montajes` (`id`,`clienteId`,`nombreCliente`,`telefono`,`direccion`,`fecha`,`hora`,`horasEstimadas`,`marcaMaquina`,`modeloMaquina`,`tipoMaquina`,`numMaquinas`,`presupuesto`,`costeMateriales`,`importeCobrado`,`estado`,`estadoCobro`,`metodoPago`,`fechaCobro`,`fechaFinalizacion`,`observaciones`,`firmaPath`,`urgente`,`fechaCreacion`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Montaje entity) {
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
        statement.bindDouble(8, entity.getHorasEstimadas());
        if (entity.getMarcaMaquina() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getMarcaMaquina());
        }
        if (entity.getModeloMaquina() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getModeloMaquina());
        }
        statement.bindString(11, __TipoMaquina_enumToString(entity.getTipoMaquina()));
        statement.bindLong(12, entity.getNumMaquinas());
        statement.bindDouble(13, entity.getPresupuesto());
        statement.bindDouble(14, entity.getCosteMateriales());
        statement.bindDouble(15, entity.getImporteCobrado());
        statement.bindString(16, __EstadoMontaje_enumToString(entity.getEstado()));
        statement.bindString(17, __EstadoCobro_enumToString(entity.getEstadoCobro()));
        statement.bindString(18, __MetodoPago_enumToString(entity.getMetodoPago()));
        if (entity.getFechaCobro() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getFechaCobro());
        }
        if (entity.getFechaFinalizacion() == null) {
          statement.bindNull(20);
        } else {
          statement.bindLong(20, entity.getFechaFinalizacion());
        }
        if (entity.getObservaciones() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getObservaciones());
        }
        if (entity.getFirmaPath() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getFirmaPath());
        }
        final int _tmp = entity.getUrgente() ? 1 : 0;
        statement.bindLong(23, _tmp);
        statement.bindLong(24, entity.getFechaCreacion());
      }
    };
    this.__deletionAdapterOfMontaje = new EntityDeletionOrUpdateAdapter<Montaje>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `montajes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Montaje entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfMontaje = new EntityDeletionOrUpdateAdapter<Montaje>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `montajes` SET `id` = ?,`clienteId` = ?,`nombreCliente` = ?,`telefono` = ?,`direccion` = ?,`fecha` = ?,`hora` = ?,`horasEstimadas` = ?,`marcaMaquina` = ?,`modeloMaquina` = ?,`tipoMaquina` = ?,`numMaquinas` = ?,`presupuesto` = ?,`costeMateriales` = ?,`importeCobrado` = ?,`estado` = ?,`estadoCobro` = ?,`metodoPago` = ?,`fechaCobro` = ?,`fechaFinalizacion` = ?,`observaciones` = ?,`firmaPath` = ?,`urgente` = ?,`fechaCreacion` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Montaje entity) {
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
        statement.bindDouble(8, entity.getHorasEstimadas());
        if (entity.getMarcaMaquina() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getMarcaMaquina());
        }
        if (entity.getModeloMaquina() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getModeloMaquina());
        }
        statement.bindString(11, __TipoMaquina_enumToString(entity.getTipoMaquina()));
        statement.bindLong(12, entity.getNumMaquinas());
        statement.bindDouble(13, entity.getPresupuesto());
        statement.bindDouble(14, entity.getCosteMateriales());
        statement.bindDouble(15, entity.getImporteCobrado());
        statement.bindString(16, __EstadoMontaje_enumToString(entity.getEstado()));
        statement.bindString(17, __EstadoCobro_enumToString(entity.getEstadoCobro()));
        statement.bindString(18, __MetodoPago_enumToString(entity.getMetodoPago()));
        if (entity.getFechaCobro() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getFechaCobro());
        }
        if (entity.getFechaFinalizacion() == null) {
          statement.bindNull(20);
        } else {
          statement.bindLong(20, entity.getFechaFinalizacion());
        }
        if (entity.getObservaciones() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getObservaciones());
        }
        if (entity.getFirmaPath() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getFirmaPath());
        }
        final int _tmp = entity.getUrgente() ? 1 : 0;
        statement.bindLong(23, _tmp);
        statement.bindLong(24, entity.getFechaCreacion());
        statement.bindLong(25, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Montaje montaje, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfMontaje.insertAndReturnId(montaje);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Montaje montaje, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMontaje.handle(montaje);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Montaje montaje, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMontaje.handle(montaje);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Montaje>> getAll() {
    final String _sql = "SELECT * FROM montajes ORDER BY fecha ASC, fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getByEstado(final EstadoMontaje estado) {
    final String _sql = "SELECT * FROM montajes WHERE estado = ? ORDER BY fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, __EstadoMontaje_enumToString(estado));
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getListaEspera() {
    final String _sql = "SELECT * FROM montajes WHERE fecha IS NULL ORDER BY fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getProgramados() {
    final String _sql = "SELECT * FROM montajes WHERE fecha IS NOT NULL ORDER BY fecha ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getRealizados() {
    final String _sql = "SELECT * FROM montajes WHERE estado IN ('REALIZADO','COBRADO') ORDER BY fechaFinalizacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getEnRango(final long inicio, final long fin) {
    final String _sql = "SELECT * FROM montajes WHERE fecha BETWEEN ? AND ? ORDER BY fecha ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, inicio);
    _argIndex = 2;
    _statement.bindLong(_argIndex, fin);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Object getById(final long id, final Continuation<? super Montaje> $completion) {
    final String _sql = "SELECT * FROM montajes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Montaje>() {
      @Override
      @Nullable
      public Montaje call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final Montaje _result;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _result = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> getByCliente(final long clienteId) {
    final String _sql = "SELECT * FROM montajes WHERE clienteId = ? ORDER BY fechaCreacion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, clienteId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
  public Flow<List<Montaje>> buscar(final String q) {
    final String _sql = "\n"
            + "        SELECT * FROM montajes WHERE\n"
            + "        nombreCliente LIKE '%' || ? || '%' OR\n"
            + "        direccion LIKE '%' || ? || '%' OR\n"
            + "        marcaMaquina LIKE '%' || ? || '%' OR\n"
            + "        modeloMaquina LIKE '%' || ? || '%'\n"
            + "        ORDER BY fechaCreacion DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
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
    _argIndex = 3;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    _argIndex = 4;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<List<Montaje>>() {
      @Override
      @NonNull
      public List<Montaje> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfDireccion = CursorUtil.getColumnIndexOrThrow(_cursor, "direccion");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfHorasEstimadas = CursorUtil.getColumnIndexOrThrow(_cursor, "horasEstimadas");
          final int _cursorIndexOfMarcaMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "marcaMaquina");
          final int _cursorIndexOfModeloMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "modeloMaquina");
          final int _cursorIndexOfTipoMaquina = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMaquina");
          final int _cursorIndexOfNumMaquinas = CursorUtil.getColumnIndexOrThrow(_cursor, "numMaquinas");
          final int _cursorIndexOfPresupuesto = CursorUtil.getColumnIndexOrThrow(_cursor, "presupuesto");
          final int _cursorIndexOfCosteMateriales = CursorUtil.getColumnIndexOrThrow(_cursor, "costeMateriales");
          final int _cursorIndexOfImporteCobrado = CursorUtil.getColumnIndexOrThrow(_cursor, "importeCobrado");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfEstadoCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoCobro");
          final int _cursorIndexOfMetodoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "metodoPago");
          final int _cursorIndexOfFechaCobro = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCobro");
          final int _cursorIndexOfFechaFinalizacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaFinalizacion");
          final int _cursorIndexOfObservaciones = CursorUtil.getColumnIndexOrThrow(_cursor, "observaciones");
          final int _cursorIndexOfFirmaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "firmaPath");
          final int _cursorIndexOfUrgente = CursorUtil.getColumnIndexOrThrow(_cursor, "urgente");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Montaje> _result = new ArrayList<Montaje>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Montaje _item;
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
            final float _tmpHorasEstimadas;
            _tmpHorasEstimadas = _cursor.getFloat(_cursorIndexOfHorasEstimadas);
            final String _tmpMarcaMaquina;
            if (_cursor.isNull(_cursorIndexOfMarcaMaquina)) {
              _tmpMarcaMaquina = null;
            } else {
              _tmpMarcaMaquina = _cursor.getString(_cursorIndexOfMarcaMaquina);
            }
            final String _tmpModeloMaquina;
            if (_cursor.isNull(_cursorIndexOfModeloMaquina)) {
              _tmpModeloMaquina = null;
            } else {
              _tmpModeloMaquina = _cursor.getString(_cursorIndexOfModeloMaquina);
            }
            final TipoMaquina _tmpTipoMaquina;
            _tmpTipoMaquina = __TipoMaquina_stringToEnum(_cursor.getString(_cursorIndexOfTipoMaquina));
            final int _tmpNumMaquinas;
            _tmpNumMaquinas = _cursor.getInt(_cursorIndexOfNumMaquinas);
            final double _tmpPresupuesto;
            _tmpPresupuesto = _cursor.getDouble(_cursorIndexOfPresupuesto);
            final double _tmpCosteMateriales;
            _tmpCosteMateriales = _cursor.getDouble(_cursorIndexOfCosteMateriales);
            final double _tmpImporteCobrado;
            _tmpImporteCobrado = _cursor.getDouble(_cursorIndexOfImporteCobrado);
            final EstadoMontaje _tmpEstado;
            _tmpEstado = __EstadoMontaje_stringToEnum(_cursor.getString(_cursorIndexOfEstado));
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
            final Long _tmpFechaFinalizacion;
            if (_cursor.isNull(_cursorIndexOfFechaFinalizacion)) {
              _tmpFechaFinalizacion = null;
            } else {
              _tmpFechaFinalizacion = _cursor.getLong(_cursorIndexOfFechaFinalizacion);
            }
            final String _tmpObservaciones;
            if (_cursor.isNull(_cursorIndexOfObservaciones)) {
              _tmpObservaciones = null;
            } else {
              _tmpObservaciones = _cursor.getString(_cursorIndexOfObservaciones);
            }
            final String _tmpFirmaPath;
            if (_cursor.isNull(_cursorIndexOfFirmaPath)) {
              _tmpFirmaPath = null;
            } else {
              _tmpFirmaPath = _cursor.getString(_cursorIndexOfFirmaPath);
            }
            final boolean _tmpUrgente;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfUrgente);
            _tmpUrgente = _tmp != 0;
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Montaje(_tmpId,_tmpClienteId,_tmpNombreCliente,_tmpTelefono,_tmpDireccion,_tmpFecha,_tmpHora,_tmpHorasEstimadas,_tmpMarcaMaquina,_tmpModeloMaquina,_tmpTipoMaquina,_tmpNumMaquinas,_tmpPresupuesto,_tmpCosteMateriales,_tmpImporteCobrado,_tmpEstado,_tmpEstadoCobro,_tmpMetodoPago,_tmpFechaCobro,_tmpFechaFinalizacion,_tmpObservaciones,_tmpFirmaPath,_tmpUrgente,_tmpFechaCreacion);
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
    final String _sql = "SELECT SUM(presupuesto) FROM montajes WHERE fecha BETWEEN ? AND ?";
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
    final String _sql = "SELECT SUM(importeCobrado) FROM montajes WHERE fecha BETWEEN ? AND ?";
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
  public Flow<Integer> countListaEspera() {
    final String _sql = "SELECT COUNT(*) FROM montajes WHERE fecha IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"montajes"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __TipoMaquina_enumToString(@NonNull final TipoMaquina _value) {
    switch (_value) {
      case SPLIT_PARED: return "SPLIT_PARED";
      case SPLIT_CASSETTE: return "SPLIT_CASSETTE";
      case SPLIT_SUELO_TECHO: return "SPLIT_SUELO_TECHO";
      case MULTI_SPLIT: return "MULTI_SPLIT";
      case CONDUCTOS: return "CONDUCTOS";
      case VRF: return "VRF";
      case OTRO: return "OTRO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __EstadoMontaje_enumToString(@NonNull final EstadoMontaje _value) {
    switch (_value) {
      case LISTA_ESPERA: return "LISTA_ESPERA";
      case PENDIENTE: return "PENDIENTE";
      case EN_CURSO: return "EN_CURSO";
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

  private TipoMaquina __TipoMaquina_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "SPLIT_PARED": return TipoMaquina.SPLIT_PARED;
      case "SPLIT_CASSETTE": return TipoMaquina.SPLIT_CASSETTE;
      case "SPLIT_SUELO_TECHO": return TipoMaquina.SPLIT_SUELO_TECHO;
      case "MULTI_SPLIT": return TipoMaquina.MULTI_SPLIT;
      case "CONDUCTOS": return TipoMaquina.CONDUCTOS;
      case "VRF": return TipoMaquina.VRF;
      case "OTRO": return TipoMaquina.OTRO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private EstadoMontaje __EstadoMontaje_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "LISTA_ESPERA": return EstadoMontaje.LISTA_ESPERA;
      case "PENDIENTE": return EstadoMontaje.PENDIENTE;
      case "EN_CURSO": return EstadoMontaje.EN_CURSO;
      case "REALIZADO": return EstadoMontaje.REALIZADO;
      case "COBRADO": return EstadoMontaje.COBRADO;
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
