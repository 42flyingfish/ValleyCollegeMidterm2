package com.example.valleycollegemidterm2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val helloSBVC = findViewById<Button>(R.id.makeToast)
        helloSBVC.setOnClickListener {
            val text = "Hello SBVC!"
            val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
            toast.show()
        }

        val sendEmailButton = findViewById<Button>(R.id.sendEmail)
        sendEmailButton.setOnClickListener {
            intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                println("Failed to compose email")
            }
        }

        val viewHomepageButton = findViewById<Button>(R.id.viewHomepage)
        viewHomepageButton.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.valleycollege.edu")
            }
            startActivity(intent)
        }

        val fakeLoginButton = findViewById<Button>(R.id.fakeLogin)
        fakeLoginButton.setOnClickListener {
            val text = "Login Successful?"
            val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

}