package com.frost.hiltpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frost.hiltpractice.db.RoomRepository
import com.frost.hiltpractice.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    private var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> = userData

    private fun loadRecords() = userData.postValue(repository.getRecords())

    private fun deleteAll() = repository.deleteAll()

    fun clearDB(){
        deleteAll()
        loadRecords()
    }

    fun insertRecord(userEntity: UserEntity) {
        repository.insertRecord(userEntity)
        loadRecords()
    }
}