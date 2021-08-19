package com.frost.hiltpractice.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecords(): List<UserEntity> = appDao.getRecords()

    fun insertRecord(userEntity: UserEntity) = appDao.insertRecord(userEntity)

    fun deleteAll() = appDao.deleteAll()

}