package com.example.mygalon

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.net.Uri

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
        val email: String = intent.getStringExtra(LoginActivity.KEY_USERNAME) ?:""
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGalon) //bikin recyclerview galon
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listGalon = List<galon> = getData() // ngambil data dari list galon
        recyclerView.adapter = GalonAdapter(listGalon, onClickItemGalon::goToRincianGalon) //belum bikin class rincian galon
    }
}

fun getData(): List<galon>{
    val listGalon = muteableListOf<galon>()
// data galon nanti (nama,harga, merk (enum class))
}