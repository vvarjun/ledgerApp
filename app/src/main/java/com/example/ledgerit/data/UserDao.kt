package com.example.ledgerit.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM Customer")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM Customer WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Customer>

    @Query("SELECT * FROM Customer WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Customer

    @Insert
    fun insertAll(vararg customers: Customer)

    @Delete
    fun delete(customer: Customer)
}