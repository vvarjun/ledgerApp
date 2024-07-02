package com.example.ledgerit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.ledgerit.data.AppDatabase
import com.example.ledgerit.data.Customer
import com.example.ledgerit.data.UserDao
import com.example.ledgerit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "test_database"
        ).build()

        // Accessing views using View Binding
        val usernameEditText = binding.editTextUsername
        val firstnameEditText = binding.editTextFirstname
        val lastnameEditText = binding.editTextLastname
        val confirmPassword = binding.editTextConfirmPassword
        val emailEditText = binding.editTextEmail
        val passwordEditText = binding.editTextPassword
        val registerButton = binding.buttonRegister
        // Set up click listener for the register button
        registerButton.setOnClickListener {
            // Retrieve user inputs
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPass = confirmPassword.text.toString()
            val firstName = firstnameEditText.text.toString()
            val lastName = lastnameEditText.text.toString()
            if(!password.equals(confirmPassword))
                showToast("Passwords does not match")
                return@setOnClickListener

            if (username.isNotEmpty() && email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()) {
                val newUser = Customer(1, firstName, lastName, username, password, email)
                MainActivity.database.userDao().insertAll(newUser)
                showToast("Registration successful!")
                // println(newUser) // Uncomment this if you want to print the new user details
            } else {
                showToast("Please fill out all fields")
            }

        }

    }



    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


