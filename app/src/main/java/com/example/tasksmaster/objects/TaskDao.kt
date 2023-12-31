package com.example.tasksmaster.objects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: Task)

/*    @Query("SELECT * FROM tasks WHERE taskName = :name")
    fun findTask(name: String): List<Task>*/

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>
}

/*
@Dao
interface StateDao {
@Insert
fun insertState(sate: State)

@Update(onConflict = OnConflictStrategy.REPLACE)
suspend fun updateState(sate: State)

@Query("SELECT * FROM states WHERE stateId = :id")
fun findState(id: Int): List<State>

@Delete
fun deleteState(sate: State)
}*/
