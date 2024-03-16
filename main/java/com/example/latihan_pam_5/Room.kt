package com.example.latihan_pam_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// YourDao.kt
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
// MyDatabase.kt
import androidx.room.Database
import androidx.room.RoomDatabase
// YourEntity.kt
import androidx.room.Entity
import androidx.room.PrimaryKey


class Room : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
    }
}



@Database(entities = [YourEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun yourDao(): YourDao
}


@Dao
interface YourDao {
    @Query("SELECT * FROM your_table")
    fun getAll(): List<YourEntity>

    @Insert
    fun insert(yourEntity: YourEntity)
}


@Entity(tableName = "your_table")
    data class YourEntity(
        @PrimaryKey val id: Int,
        val data: String
    )
