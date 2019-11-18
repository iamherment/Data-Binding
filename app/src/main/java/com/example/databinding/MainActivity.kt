package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private  val myName:MyName= MyName("Tang","0123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName

        binding.btnDone.setOnClickListener{
            showName()
        }
    }

    private fun showName() {
        binding.apply {
            myName?.name=editTextName.text.toString()
            myName?.phoneContact=editTextpohne.text.toString()
            this.invalidateAll()   //the last varaible no longer exisit now need to refresh with the new
        }
    }
}
