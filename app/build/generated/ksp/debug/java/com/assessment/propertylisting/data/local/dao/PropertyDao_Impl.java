package com.assessment.propertylisting.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.assessment.propertylisting.data.local.entity.PropertyEntity;
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
public final class PropertyDao_Impl implements PropertyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PropertyEntity> __insertionAdapterOfPropertyEntity;

  private final EntityDeletionOrUpdateAdapter<PropertyEntity> __updateAdapterOfPropertyEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeletePropertyById;

  public PropertyDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPropertyEntity = new EntityInsertionAdapter<PropertyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `properties` (`id`,`propertyName`,`propertyType`,`location`,`price`,`area`,`configuration`,`status`,`description`,`imageUrl`,`ownerId`,`ownerName`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PropertyEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPropertyName());
        statement.bindString(3, entity.getPropertyType());
        statement.bindString(4, entity.getLocation());
        statement.bindDouble(5, entity.getPrice());
        statement.bindLong(6, entity.getArea());
        statement.bindString(7, entity.getConfiguration());
        statement.bindString(8, entity.getStatus());
        statement.bindString(9, entity.getDescription());
        statement.bindString(10, entity.getImageUrl());
        statement.bindString(11, entity.getOwnerId());
        statement.bindString(12, entity.getOwnerName());
      }
    };
    this.__updateAdapterOfPropertyEntity = new EntityDeletionOrUpdateAdapter<PropertyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `properties` SET `id` = ?,`propertyName` = ?,`propertyType` = ?,`location` = ?,`price` = ?,`area` = ?,`configuration` = ?,`status` = ?,`description` = ?,`imageUrl` = ?,`ownerId` = ?,`ownerName` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PropertyEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getPropertyName());
        statement.bindString(3, entity.getPropertyType());
        statement.bindString(4, entity.getLocation());
        statement.bindDouble(5, entity.getPrice());
        statement.bindLong(6, entity.getArea());
        statement.bindString(7, entity.getConfiguration());
        statement.bindString(8, entity.getStatus());
        statement.bindString(9, entity.getDescription());
        statement.bindString(10, entity.getImageUrl());
        statement.bindString(11, entity.getOwnerId());
        statement.bindString(12, entity.getOwnerName());
        statement.bindString(13, entity.getId());
      }
    };
    this.__preparedStmtOfDeletePropertyById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM properties WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertProperty(final PropertyEntity property,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPropertyEntity.insert(property);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertProperties(final List<PropertyEntity> properties,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPropertyEntity.insert(properties);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateProperty(final PropertyEntity property,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPropertyEntity.handle(property);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePropertyById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePropertyById.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, id);
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
          __preparedStmtOfDeletePropertyById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PropertyEntity>> getAllProperties() {
    final String _sql = "SELECT * FROM properties";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"properties"}, new Callable<List<PropertyEntity>>() {
      @Override
      @NonNull
      public List<PropertyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPropertyName = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyName");
          final int _cursorIndexOfPropertyType = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyType");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfConfiguration = CursorUtil.getColumnIndexOrThrow(_cursor, "configuration");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfOwnerId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerId");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final List<PropertyEntity> _result = new ArrayList<PropertyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PropertyEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPropertyName;
            _tmpPropertyName = _cursor.getString(_cursorIndexOfPropertyName);
            final String _tmpPropertyType;
            _tmpPropertyType = _cursor.getString(_cursorIndexOfPropertyType);
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final int _tmpArea;
            _tmpArea = _cursor.getInt(_cursorIndexOfArea);
            final String _tmpConfiguration;
            _tmpConfiguration = _cursor.getString(_cursorIndexOfConfiguration);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpOwnerId;
            _tmpOwnerId = _cursor.getString(_cursorIndexOfOwnerId);
            final String _tmpOwnerName;
            _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            _item = new PropertyEntity(_tmpId,_tmpPropertyName,_tmpPropertyType,_tmpLocation,_tmpPrice,_tmpArea,_tmpConfiguration,_tmpStatus,_tmpDescription,_tmpImageUrl,_tmpOwnerId,_tmpOwnerName);
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
  public Object getPropertyById(final String id,
      final Continuation<? super PropertyEntity> $completion) {
    final String _sql = "SELECT * FROM properties WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PropertyEntity>() {
      @Override
      @Nullable
      public PropertyEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPropertyName = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyName");
          final int _cursorIndexOfPropertyType = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyType");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfConfiguration = CursorUtil.getColumnIndexOrThrow(_cursor, "configuration");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfOwnerId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerId");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final PropertyEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPropertyName;
            _tmpPropertyName = _cursor.getString(_cursorIndexOfPropertyName);
            final String _tmpPropertyType;
            _tmpPropertyType = _cursor.getString(_cursorIndexOfPropertyType);
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final int _tmpArea;
            _tmpArea = _cursor.getInt(_cursorIndexOfArea);
            final String _tmpConfiguration;
            _tmpConfiguration = _cursor.getString(_cursorIndexOfConfiguration);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpOwnerId;
            _tmpOwnerId = _cursor.getString(_cursorIndexOfOwnerId);
            final String _tmpOwnerName;
            _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            _result = new PropertyEntity(_tmpId,_tmpPropertyName,_tmpPropertyType,_tmpLocation,_tmpPrice,_tmpArea,_tmpConfiguration,_tmpStatus,_tmpDescription,_tmpImageUrl,_tmpOwnerId,_tmpOwnerName);
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
  public Flow<List<PropertyEntity>> getPropertiesByOwner(final String ownerId) {
    final String _sql = "SELECT * FROM properties WHERE ownerId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, ownerId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"properties"}, new Callable<List<PropertyEntity>>() {
      @Override
      @NonNull
      public List<PropertyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPropertyName = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyName");
          final int _cursorIndexOfPropertyType = CursorUtil.getColumnIndexOrThrow(_cursor, "propertyType");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfConfiguration = CursorUtil.getColumnIndexOrThrow(_cursor, "configuration");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfOwnerId = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerId");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final List<PropertyEntity> _result = new ArrayList<PropertyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PropertyEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpPropertyName;
            _tmpPropertyName = _cursor.getString(_cursorIndexOfPropertyName);
            final String _tmpPropertyType;
            _tmpPropertyType = _cursor.getString(_cursorIndexOfPropertyType);
            final String _tmpLocation;
            _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final int _tmpArea;
            _tmpArea = _cursor.getInt(_cursorIndexOfArea);
            final String _tmpConfiguration;
            _tmpConfiguration = _cursor.getString(_cursorIndexOfConfiguration);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            final String _tmpOwnerId;
            _tmpOwnerId = _cursor.getString(_cursorIndexOfOwnerId);
            final String _tmpOwnerName;
            _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            _item = new PropertyEntity(_tmpId,_tmpPropertyName,_tmpPropertyType,_tmpLocation,_tmpPrice,_tmpArea,_tmpConfiguration,_tmpStatus,_tmpDescription,_tmpImageUrl,_tmpOwnerId,_tmpOwnerName);
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
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM properties";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
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
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
