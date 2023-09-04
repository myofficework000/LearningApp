package com.example.learningapp.modal.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.learningapp.modal.dto.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM User WHERE  userId = :userId")
    fun findUserById(userId:String):User

    @Query("Select * From User")
    fun getAllUser(): List<User>
}