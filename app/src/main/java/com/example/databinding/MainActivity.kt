package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding; //lateinit = late initialise
    private val myName: MyName = MyName("Rachel")
    private val myContact: MyContact = MyContact("01127210802")
            
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonSetName.setOnClickListener{
            //it = object(button) associated to an event
            addNickName(it) // an event handler of that button
            addContact(it)
        }

       binding.myName = myName
       binding.myContact = myContact
    }

    private fun addNickName(it: View?){
        binding.apply {
            myName?.name = editTextName.text.toString()
            this.invalidateAll()
        }
    }


    private fun addContact(it: View?){
        binding.apply {
            myContact?.contact = editTextContact.text.toString()
            this.invalidateAll()
        }
    }
}
