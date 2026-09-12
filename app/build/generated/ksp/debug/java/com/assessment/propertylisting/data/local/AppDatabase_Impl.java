package com.assessment.propertylisting.data.local;

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
import com.assessment.propertylisting.data.local.dao.InterestDao;
import com.assessment.propertylisting.data.local.dao.InterestDao_Impl;
import com.assessment.propertylisting.data.local.dao.PropertyDao;
import com.assessment.propertylisting.data.local.dao.PropertyDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PropertyDao _propertyDao;

  private volatile InterestDao _interestDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `properties` (`id` TEXT NOT NULL, `propertyName` TEXT NOT NULL, `propertyType` TEXT NOT NULL, `location` TEXT NOT NULL, `price` REAL NOT NULL, `area` INTEGER NOT NULL, `configuration` TEXT NOT NULL, `status` TEXT NOT NULL, `description` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `ownerName` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `interests` (`id` TEXT NOT NULL, `propertyId` TEXT NOT NULL, `propertyName` TEXT NOT NULL, `ownerId` TEXT NOT NULL, `userName` TEXT NOT NULL, `mobileNumber` TEXT NOT NULL, `email` TEXT NOT NULL, `message` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '60e690517159bd0484f68c8b2fc003e2')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `properties`");
        db.execSQL("DROP TABLE IF EXISTS `interests`");
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
        final HashMap<String, TableInfo.Column> _columnsProperties = new HashMap<String, TableInfo.Column>(12);
        _columnsProperties.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("propertyName", new TableInfo.Column("propertyName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("propertyType", new TableInfo.Column("propertyType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("area", new TableInfo.Column("area", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("configuration", new TableInfo.Column("configuration", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("ownerId", new TableInfo.Column("ownerId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProperties.put("ownerName", new TableInfo.Column("ownerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProperties = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProperties = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProperties = new TableInfo("properties", _columnsProperties, _foreignKeysProperties, _indicesProperties);
        final TableInfo _existingProperties = TableInfo.read(db, "properties");
        if (!_infoProperties.equals(_existingProperties)) {
          return new RoomOpenHelper.ValidationResult(false, "properties(com.assessment.propertylisting.data.local.entity.PropertyEntity).\n"
                  + " Expected:\n" + _infoProperties + "\n"
                  + " Found:\n" + _existingProperties);
        }
        final HashMap<String, TableInfo.Column> _columnsInterests = new HashMap<String, TableInfo.Column>(9);
        _columnsInterests.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("propertyId", new TableInfo.Column("propertyId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("propertyName", new TableInfo.Column("propertyName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("ownerId", new TableInfo.Column("ownerId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("userName", new TableInfo.Column("userName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("mobileNumber", new TableInfo.Column("mobileNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInterests.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInterests = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInterests = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInterests = new TableInfo("interests", _columnsInterests, _foreignKeysInterests, _indicesInterests);
        final TableInfo _existingInterests = TableInfo.read(db, "interests");
        if (!_infoInterests.equals(_existingInterests)) {
          return new RoomOpenHelper.ValidationResult(false, "interests(com.assessment.propertylisting.data.local.entity.InterestEntity).\n"
                  + " Expected:\n" + _infoInterests + "\n"
                  + " Found:\n" + _existingInterests);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "60e690517159bd0484f68c8b2fc003e2", "558995bc90f3eba72abe14a20c0397cc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "properties","interests");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `properties`");
      _db.execSQL("DELETE FROM `interests`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
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
    _typeConvertersMap.put(PropertyDao.class, PropertyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(InterestDao.class, InterestDao_Impl.getRequiredConverters());
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
  public PropertyDao propertyDao() {
    if (_propertyDao != null) {
      return _propertyDao;
    } else {
      synchronized(this) {
        if(_propertyDao == null) {
          _propertyDao = new PropertyDao_Impl(this);
        }
        return _propertyDao;
      }
    }
  }

  @Override
  public InterestDao interestDao() {
    if (_interestDao != null) {
      return _interestDao;
    } else {
      synchronized(this) {
        if(_interestDao == null) {
          _interestDao = new InterestDao_Impl(this);
        }
        return _interestDao;
      }
    }
  }
}
