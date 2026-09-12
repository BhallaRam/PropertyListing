package com.assessment.propertylisting.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.assessment.propertylisting.data.local.AppDatabase
import com.assessment.propertylisting.data.local.dao.InterestDao
import com.assessment.propertylisting.data.local.dao.PropertyDao
import com.assessment.propertylisting.data.local.seed.DatabaseSeeder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        propertyDaoProvider: Provider<PropertyDao>
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    propertyDaoProvider.get().insertProperties(DatabaseSeeder.INITIAL_PROPERTIES)
                }
            }
        }).build()
    }

    @Provides
    @Singleton
    fun providePropertyDao(database: AppDatabase): PropertyDao {
        return database.propertyDao()
    }

    @Provides
    @Singleton
    fun provideInterestDao(database: AppDatabase): InterestDao {
        return database.interestDao()
    }
}
