package com.example.mtggametracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Rule: @Database annotation Rule: Add entities
@Database(entities = [Player::class], version = 1, exportSchema = false)

//Rule:Always abstract and extend RoomDB
abstract class AppDatabase : RoomDatabase(){

    //Rule: Need abstract return Dao(Data Access Object)
    abstract fun getDao(): PlayerDAO

    //Rule: Singleton as to not create many db communicators
    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) :AppDatabase?{
            //If not created, create it
            if( INSTANCE == null){
                //Rule: Acquire instance of RoomDB
                //We are acquiring an instance of RoomDB Builder
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "players.db")
                        .allowMainThreadQueries().build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }
}