package com.example.guldana.mytodo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.guldana.mytodo.models.User

@Dao
interface UserDao {

    @Insert
    fun register(user : User)

    @Query("Select * from users")
    fun getUsers () : List<User>

    @Query("Select * from users where email = :email")
    fun getUserByEmail(email: String) : User

    @Delete
    fun removeUser(user: User)
}