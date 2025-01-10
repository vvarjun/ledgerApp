package com.example.ledgerit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.example.ledgerit.data.AppDatabase
import com.example.ledgerit.data.Customer
import com.example.ledgerit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adminLoginButton = findViewById<Button>(R.id.buttonAdminLogin)
        val customerLoginButton = findViewById<Button>(R.id.buttonCustomerLogin)

        adminLoginButton.setOnClickListener {
            // Navigate to AdminActivity
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }

        customerLoginButton.setOnClickListener {
            // Navigate to CustomerActivity
            val intent = Intent(this, CustomerActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
