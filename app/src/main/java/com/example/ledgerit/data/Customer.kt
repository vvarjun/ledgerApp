package com.example.ledgerit.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "email") val email: String?

)