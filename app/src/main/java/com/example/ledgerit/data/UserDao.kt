package com.example.ledgerit.data
import android.os.Parcel
import android.os.Parcelable
import androidx.room.*

@Database(entities = [Customer::class, Payment::class,  Admin::class], version = 2)
abstract class AppDatabase() : RoomDatabase() {


    abstract fun customerDao(): CustomerDao
    abstract fun paymentDao(): PaymentDao
    abstract fun adminDao(): AdminDao




}
@Dao
interface AdminDao {
    @Insert
    suspend fun insertAdmin(admin: Admin)

    @Query("SELECT * FROM Admin WHERE username = :username AND password = :password")
    suspend fun getAdmin(username: String, password: String): Admin?
}
@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM Customer")
    suspend fun getAllCustomers(): List<Customer>
}

@Dao
interface PaymentDao {
    @Insert
    suspend fun insertPayment(payment: Payment)

    @Query("SELECT * FROM Payment WHERE customerId = :customerId")
    suspend fun getPaymentsForCustomer(customerId: Int): List<Payment>
}
