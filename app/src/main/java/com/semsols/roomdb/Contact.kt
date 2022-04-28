package com.semsols.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: String,
    val name: String,
    val phone: String

)
