package data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//create database if not existed (singleton)
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class taskDatabase: RoomDatabase() {
    abstract fun taskDao():TaskDao
    companion object{
        @Volatile
        private var INSTANCE:taskDatabase?=null
        fun getDatabase(context: Context):taskDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null)
                return tempInstance
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    taskDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}