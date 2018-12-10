package com.example.guldana.mytodo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.guldana.mytodo.models.Todo

@Dao
interface TodoDao {

    @Insert
    fun insert (todo: Todo)

    @Query("Select count(*) from todos")
    fun getTodosCount() : Int

    @Update
    fun update(todo: Todo)

    @Query("Select * from todos where user_id = :user_id")
    fun getTodosByUserId (user_id : Int) : List<Todo>

    @Query("Select * from todos where user_id = :user_id and done = :status")
    fun getTodosByStatus (user_id : Int, status: Boolean) : List<Todo>

}