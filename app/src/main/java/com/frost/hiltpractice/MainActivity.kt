package com.frost.hiltpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.frost.hiltpractice.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButton()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.getRecordsObserver().observe(this, { loadResult(it) })
    }

    private fun loadResult(list: List<UserEntity>?) {
        resultTextView.text = ""
        list?.forEach { user-> resultTextView.append(user.name + "\n") }
    }

    private fun setButton() {
        clearButton.setOnClickListener { viewModel.clearDB() }
        saveButton.setOnClickListener {
            if (descriptionEditText.text.isNotEmpty()){
                val userEntity = UserEntity(name = descriptionEditText.text.toString())
                viewModel.insertRecord(userEntity)
                descriptionEditText.setText("")
            } else{
                Toast.makeText(this, "Must write a description", Toast.LENGTH_SHORT).show()
            }
        }
    }

}