package com.example.mygalon

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_activity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextTextEmailAddress: EditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword: EditText = findViewById<EditText>(R.id.editTextTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        //handle button
        // menggunakan interface
        //buttonLogin.setOnClickListener(this)

        //lambda
        buttonLogin.setOnClickListener{
            val email = editTextTextEmailAddress.text.toString() //proses pengiriman
            val intent = Intent(this, Home::class.java)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonLogin -> {
                Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
            }
        }

    }
    companion object {
        const val  KEY_USERNAME = "userName"
    }

}