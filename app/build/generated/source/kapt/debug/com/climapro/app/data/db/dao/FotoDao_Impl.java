package com.climapro.app.data.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.climapro.app.data.db.entity.Foto;
import com.climapro.app.data.db.entity.TipoFoto;
import com.climapro.app.data.db.entity.TipoTrabajo;
import java.lang.Class;
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
public final class FotoDao_Impl implements FotoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Foto> __insertionAdapterOfFoto;

  private final EntityDeletionOrUpdateAdapter<Foto> __deletionAdapterOfFoto;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByTrabajo;

  public FotoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFoto = new EntityInsertionAdapter<Foto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `fotos` (`id`,`trabajoId`,`tipoTrabajo`,`tipoFoto`,`rutaArchivo`,`fechaCaptura`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Foto entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTrabajoId());
        statement.bindString(3, __TipoTrabajo_enumToString(entity.getTipoTrabajo()));
        statement.bindString(4, __TipoFoto_enumToString(entity.getTipoFoto()));
        if (entity.getRutaArchivo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRutaArchivo());
        }
        statement.bindLong(6, entity.getFechaCaptura());
      }
    };
    this.__deletionAdapterOfFoto = new EntityDeletionOrUpdateAdapter<Foto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `fotos` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Foto entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteByTrabajo = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM fotos WHERE trabajoId = ? AND tipoTrabajo = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Foto foto, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfFoto.insertAndReturnId(foto);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Foto foto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFoto.handle(foto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteByTrabajo(final long id, final TipoTrabajo tipo,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByTrabajo.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        _argIndex = 2;
        _stmt.bindString(_argIndex, __TipoTrabajo_enumToString(tipo));
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByTrabajo.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Foto>> getByTrabajo(final long id, final TipoTrabajo tipo) {
    final String _sql = "SELECT * FROM fotos WHERE trabajoId = ? AND tipoTrabajo = ? ORDER BY tipoFoto ASC, fechaCaptura ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, __TipoTrabajo_enumToString(tipo));
    return CoroutinesRoom.createFlow(__db, false, new String[] {"fotos"}, new Callable<List<Foto>>() {
      @Override
      @NonNull
      public List<Foto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTrabajoId = CursorUtil.getColumnIndexOrThrow(_cursor, "trabajoId");
          final int _cursorIndexOfTipoTrabajo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoTrabajo");
          final int _cursorIndexOfTipoFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoFoto");
          final int _cursorIndexOfRutaArchivo = CursorUtil.getColumnIndexOrThrow(_cursor, "rutaArchivo");
          final int _cursorIndexOfFechaCaptura = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCaptura");
          final List<Foto> _result = new ArrayList<Foto>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Foto _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTrabajoId;
            _tmpTrabajoId = _cursor.getLong(_cursorIndexOfTrabajoId);
            final TipoTrabajo _tmpTipoTrabajo;
            _tmpTipoTrabajo = __TipoTrabajo_stringToEnum(_cursor.getString(_cursorIndexOfTipoTrabajo));
            final TipoFoto _tmpTipoFoto;
            _tmpTipoFoto = __TipoFoto_stringToEnum(_cursor.getString(_cursorIndexOfTipoFoto));
            final String _tmpRutaArchivo;
            if (_cursor.isNull(_cursorIndexOfRutaArchivo)) {
              _tmpRutaArchivo = null;
            } else {
              _tmpRutaArchivo = _cursor.getString(_cursorIndexOfRutaArchivo);
            }
            final long _tmpFechaCaptura;
            _tmpFechaCaptura = _cursor.getLong(_cursorIndexOfFechaCaptura);
            _item = new Foto(_tmpId,_tmpTrabajoId,_tmpTipoTrabajo,_tmpTipoFoto,_tmpRutaArchivo,_tmpFechaCaptura);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __TipoTrabajo_enumToString(@NonNull final TipoTrabajo _value) {
    switch (_value) {
      case MONTAJE: return "MONTAJE";
      case MANTENIMIENTO: return "MANTENIMIENTO";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __TipoFoto_enumToString(@NonNull final TipoFoto _value) {
    switch (_value) {
      case ANTES: return "ANTES";
      case DURANTE: return "DURANTE";
      case DESPUES: return "DESPUES";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private TipoTrabajo __TipoTrabajo_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "MONTAJE": return TipoTrabajo.MONTAJE;
      case "MANTENIMIENTO": return TipoTrabajo.MANTENIMIENTO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private TipoFoto __TipoFoto_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "ANTES": return TipoFoto.ANTES;
      case "DURANTE": return TipoFoto.DURANTE;
      case "DESPUES": return TipoFoto.DESPUES;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
