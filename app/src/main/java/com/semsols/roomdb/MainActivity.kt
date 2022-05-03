package com.semsols.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dataBase: ContactDb
    lateinit var dataBase2: ContactDb

    lateinit var button: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.floatBtn)

        dataBase = ContactDb.getDb(this)
        dataBase2 = ContactDb.getDb(this)

        //Change Status Bar color
        window.statusBarColor = ContextCompat.getColor(this,R.color.statusBar)

            GlobalScope.launch {
                dataBase.contactDao().insertContact(Contact(0,"Annu","07089364480",Date()))
            }
    }

    fun getDataFun(view: View) {
        dataBase.contactDao().getContact().observe(this) {
            Log.d("Database", it.toString())
        }
    }
}