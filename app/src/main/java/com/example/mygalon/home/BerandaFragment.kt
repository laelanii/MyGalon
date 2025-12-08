package com.example.mygalon.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygalon.GalonAdapter
import com.example.mygalon.R
import com.example.mygalon.galon
import com.example.mygalon.merkGalon

class BerandaFragment : Fragment() {

    private lateinit var rvProduk: RecyclerView
    private lateinit var tvNamaPengguna: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvNamaPengguna = view.findViewById(R.id.tvNamaPengguna)

//        Mengambil username dari shared preferences
        val sharedPref = requireActivity()
            .getSharedPreferences("USER_LOGIN", Context.MODE_PRIVATE)

        val username = sharedPref.getString("USERNAME", "Pengguna")

//        Menampilkan ke textview
        tvNamaPengguna.text = "Halo, $username"

//        Menampilkan Produk Galon dengan recyclerview
        rvProduk = view.findViewById(R.id.rvProduk)

        val listGalon = listOf(
            galon("Galon Aqua 19L", "20.000", merkGalon.Aqua, R.drawable.aqua),
            galon("Galon Le Minerale 19L", "22.000", merkGalon.LeMinerale, R.drawable.lemineral),
            galon("Galon Cleo 19L", "18.000", merkGalon.Cleo, R.drawable.cleo),
            galon("Galon Oasis 19L", "17.000", merkGalon.Oasis, R.drawable.oasis)
        )

        val adapter = GalonAdapter(listGalon) { galon ->
            // Mengirim data ke DetailGalonFragment menggunakan Bundle
            val bundle = bundleOf(
                "nama" to galon.namaGalon,
                "harga" to galon.harga,
                "image" to galon.ImageProduk
            )
            findNavController().navigate(R.id.action_berandaFragment_to_detailGalonFragment, bundle)
        }

        rvProduk.layoutManager = GridLayoutManager(requireContext(), 2)
        rvProduk.adapter = adapter
    }
}
