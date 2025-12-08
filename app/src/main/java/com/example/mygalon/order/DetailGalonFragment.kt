package com.example.mygalon.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.mygalon.R

class DetailGalonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_galon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menerima data dari Bundle
        val namaGalon = arguments?.getString("nama") ?: "Aqua Galon"
        val hargaGalon = arguments?.getString("harga") ?: "20.000"
        val imageGalon = arguments?.getInt("image") ?: R.drawable.aqua

        // Binding View
        val imgGalon = view.findViewById<ImageView>(R.id.Galon)
        val txtNama = view.findViewById<TextView>(R.id.txtNamaProduk)
        val txtHarga = view.findViewById<TextView>(R.id.txtHarga)

        // Set Data ke UI
        imgGalon.setImageResource(imageGalon)
        txtNama.text = "Nama Produk : $namaGalon"
        txtHarga.text = "Harga Isi Ulang / Galon : Rp. $hargaGalon"

        // Tombol Back
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
        txtTitle.setOnClickListener {
            findNavController().navigateUp()
        }

        // Tombol Order -> Kirim data ke Keranjang
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val bundle = bundleOf(
                "nama" to namaGalon,
                "harga" to hargaGalon,
                "image" to imageGalon
            )
            findNavController().navigate(R.id.action_detailGalonFragment_to_keranjangFragment, bundle)
        }
    }
}
