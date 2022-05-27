package data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): WordDao

    companion object {
        var db: AppDatabase? = null
        var INSTANCE: AppDatabase? = null
        fun getAppDataBase(context: Context): AppDatabase {
            val db : AppDatabase by lazy {
                Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "myDB")
                    .build()
            }
            return db
        }
        fun destroyDataBase() {
            db = null
        }
    }
}