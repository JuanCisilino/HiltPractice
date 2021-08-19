package com.frost.hiltpractice.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getRecords(): List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)

    @Query("DELETE FROM user")
    fun deleteAll()
}