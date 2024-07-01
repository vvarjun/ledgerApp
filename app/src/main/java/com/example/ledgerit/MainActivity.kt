package com.example.ledgerit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ledgerit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

            if(username.length != 0
                && email.length !=0
                && firstName.length !=0
                && lastName.length !=0)

                    showToast("Registration successful!")
                    return@setOnClickListener
                    //println(newUser)
        }

    }



    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


