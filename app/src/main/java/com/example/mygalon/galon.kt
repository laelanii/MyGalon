package com.example.mygalon

data class galon (
    val namaGalon: String,
    val harga: String,
    val merkGalon: merkGalon, //Aqua, Le Minerale,Cleo, OASIS
    val ImageProduk: Int // Menampilkan gambar galon
)

enum class merkGalon {
    Aqua,
    LeMinerale,
    Cleo,
    Oasis
}