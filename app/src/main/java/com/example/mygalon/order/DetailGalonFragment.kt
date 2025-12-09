package com.example.mygalon.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.mygalon.R

class DetailGalonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_galon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Tombol Back
        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener { findNavController().navigateUp() }
        
        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
        txtTitle.setOnClickListener { findNavController().navigateUp() }

        // TOMBOL ORDER -> Navigasi ke Keranjang (masih belum mengirim data)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            findNavController().navigate(R.id.action_detailGalonFragment_to_keranjangFragment)
        }
    }
}
