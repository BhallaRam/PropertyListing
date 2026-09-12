package com.assessment.propertylisting.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.assessment.propertylisting.data.local.entity.InterestEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class InterestDao_Impl implements InterestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InterestEntity> __insertionAdapterOfInterestEntity;

  public InterestDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInterestEntity = new EntityInsertionAdapter<InterestEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `interests` (`id`,`propertyId`,`propertyName`,`ownerId`,`userName`,`mobileNumber`,`email`,`message`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InterestEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPropertyId());
        statement.bindString(3, entity.getPropertyName());
        statement.bindString(4, entity.getOwnerId());
        statement.bindString(5, entity.getUserName());
        statement.bindString(6, entity.getMobileNumber());
        statement.bindString(7, entity.getEmail());
        statement.bindString(8, entity.getMessage());
        statement.bindLong(9, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object insertInterest(final InterestEntity interest,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInterestEntity.insert(interest);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<InterestEntity>> getInterestsForOwner(final String ownerId) {
    final String _sql = "SELECT * FROM interests WHERE ownerId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, ownerId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"interests"}, new Callable<List<InterestEntity>>() {
      @Override
      @NonNull
      public List<InterestEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPropertyId = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyId");
          final int _cursorIndexOfPropertyName = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyName");
          final int _cursorIndexOfOwnerId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerId");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfMobileNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "mobileNumber");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<InterestEntity> _result = new ArrayList<InterestEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InterestEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPropertyId;
            _tmpPropertyId = _cursor.getString(_cursorIndexOfPropertyId);
            final String _tmpPropertyName;
            _tmpPropertyName = _cursor.getString(_cursorIndexOfPropertyName);
            final String _tmpOwnerId;
            _tmpOwnerId = _cursor.getString(_cursorIndexOfOwnerId);
            final String _tmpUserName;
            _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            final String _tmpMobileNumber;
            _tmpMobileNumber = _cursor.getString(_cursorIndexOfMobileNumber);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpMessage;
            _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new InterestEntity(_tmpId,_tmpPropertyId,_tmpPropertyName,_tmpOwnerId,_tmpUserName,_tmpMobileNumber,_tmpEmail,_tmpMessage,_tmpCreatedAt);
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
  public Flow<List<InterestEntity>> getInterestsForProperty(final String propertyId) {
    final String _sql = "SELECT * FROM interests WHERE propertyId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, propertyId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"interests"}, new Callable<List<InterestEntity>>() {
      @Override
      @NonNull
      public List<InterestEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPropertyId = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyId");
          final int _cursorIndexOfPropertyName = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyName");
          final int _cursorIndexOfOwnerId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerId");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfMobileNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "mobileNumber");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<InterestEntity> _result = new ArrayList<InterestEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InterestEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPropertyId;
            _tmpPropertyId = _cursor.getString(_cursorIndexOfPropertyId);
            final String _tmpPropertyName;
            _tmpPropertyName = _cursor.getString(_cursorIndexOfPropertyName);
            final String _tmpOwnerId;
            _tmpOwnerId = _cursor.getString(_cursorIndexOfOwnerId);
            final String _tmpUserName;
            _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            final String _tmpMobileNumber;
            _tmpMobileNumber = _cursor.getString(_cursorIndexOfMobileNumber);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpMessage;
            _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new InterestEntity(_tmpId,_tmpPropertyId,_tmpPropertyName,_tmpOwnerId,_tmpUserName,_tmpMobileNumber,_tmpEmail,_tmpMessage,_tmpCreatedAt);
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
  public Flow<Integer> getInterestCountForProperty(final String propertyId) {
    final String _sql = "SELECT COUNT(*) FROM interests WHERE propertyId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, propertyId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"interests"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
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
}
