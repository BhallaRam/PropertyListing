package com.assessment.propertylisting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assessment.propertylisting.data.local.dao.InterestDao
import com.assessment.propertylisting.data.local.dao.PropertyDao
import com.assessment.propertylisting.data.local.entity.InterestEntity
import com.assessment.propertylisting.data.local.entity.PropertyEntity

@Database(
    entities = [PropertyEntity::class, InterestEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao
    abstract fun interestDao(): InterestDao

    companion object {
        const val DATABASE_NAME = "property_listing_db"
    }
}
