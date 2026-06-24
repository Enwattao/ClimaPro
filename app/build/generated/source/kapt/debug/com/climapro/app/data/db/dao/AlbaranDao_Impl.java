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
import com.climapro.app.data.db.entity.Albaran;
import com.climapro.app.data.db.entity.TipoTrabajo;
import java.lang.Class;
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
public final class AlbaranDao_Impl implements AlbaranDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Albaran> __insertionAdapterOfAlbaran;

  private final EntityDeletionOrUpdateAdapter<Albaran> __deletionAdapterOfAlbaran;

  public AlbaranDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlbaran = new EntityInsertionAdapter<Albaran>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `albaranes` (`id`,`numero`,`trabajoId`,`tipoTrabajo`,`rutaPdf`,`fechaGeneracion`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Albaran entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNumero() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNumero());
        }
        statement.bindLong(3, entity.getTrabajoId());
        statement.bindString(4, __TipoTrabajo_enumToString(entity.getTipoTrabajo()));
        if (entity.getRutaPdf() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRutaPdf());
        }
        statement.bindLong(6, entity.getFechaGeneracion());
      }
    };
    this.__deletionAdapterOfAlbaran = new EntityDeletionOrUpdateAdapter<Albaran>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `albaranes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Albaran entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Albaran a, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlbaran.insertAndReturnId(a);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Albaran a, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAlbaran.handle(a);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Albaran>> getByTrabajo(final long id, final TipoTrabajo tipo) {
    final String _sql = "SELECT * FROM albaranes WHERE trabajoId = ? AND tipoTrabajo = ? ORDER BY fechaGeneracion DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindString(_argIndex, __TipoTrabajo_enumToString(tipo));
    return CoroutinesRoom.createFlow(__db, false, new String[] {"albaranes"}, new Callable<List<Albaran>>() {
      @Override
      @NonNull
      public List<Albaran> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfTrabajoId = CursorUtil.getColumnIndexOrThrow(_cursor, "trabajoId");
          final int _cursorIndexOfTipoTrabajo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoTrabajo");
          final int _cursorIndexOfRutaPdf = CursorUtil.getColumnIndexOrThrow(_cursor, "rutaPdf");
          final int _cursorIndexOfFechaGeneracion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaGeneracion");
          final List<Albaran> _result = new ArrayList<Albaran>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Albaran _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNumero;
            if (_cursor.isNull(_cursorIndexOfNumero)) {
              _tmpNumero = null;
            } else {
              _tmpNumero = _cursor.getString(_cursorIndexOfNumero);
            }
            final long _tmpTrabajoId;
            _tmpTrabajoId = _cursor.getLong(_cursorIndexOfTrabajoId);
            final TipoTrabajo _tmpTipoTrabajo;
            _tmpTipoTrabajo = __TipoTrabajo_stringToEnum(_cursor.getString(_cursorIndexOfTipoTrabajo));
            final String _tmpRutaPdf;
            if (_cursor.isNull(_cursorIndexOfRutaPdf)) {
              _tmpRutaPdf = null;
            } else {
              _tmpRutaPdf = _cursor.getString(_cursorIndexOfRutaPdf);
            }
            final long _tmpFechaGeneracion;
            _tmpFechaGeneracion = _cursor.getLong(_cursorIndexOfFechaGeneracion);
            _item = new Albaran(_tmpId,_tmpNumero,_tmpTrabajoId,_tmpTipoTrabajo,_tmpRutaPdf,_tmpFechaGeneracion);
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
  public Object getUltimoNumero(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT MAX(CAST(SUBSTR(numero, 4) AS INTEGER)) FROM albaranes WHERE numero LIKE 'ALB%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @Nullable
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
          _statement.release();
        }
      }
    }, $completion);
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

  private TipoTrabajo __TipoTrabajo_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "MONTAJE": return TipoTrabajo.MONTAJE;
      case "MANTENIMIENTO": return TipoTrabajo.MANTENIMIENTO;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
