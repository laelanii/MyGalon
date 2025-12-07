package com.example.mygalon.order

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygalon.GalonAdapter
import com.example.mygalon.R
import com.example.mygalon.galon
import com.example.mygalon.merkGalon

class KeranjangFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTotalHarga: TextView
    private lateinit var btnCheckout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keranjang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewKeranjang)
        tvTotalHarga = view.findViewById(R.id.tvTotalHarga)
        btnCheckout = view.findViewById(R.id.btnCheckout)

        // Dummy data keranjang
        val keranjangList = listOf(
            galon("Galon Aqua 19L", "20.000", merkGalon.Aqua, R.drawable.aqua)
        )

        // Menggunakan GalonAdapter
        val adapter = GalonAdapter(keranjangList) { galon ->
            Toast.makeText(requireContext(), "Item: ${galon.namaGalon}", Toast.LENGTH_SHORT).show()
        }
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Harga total (cuma sementara tanpa logika penjumlahan produk)
        tvTotalHarga.text = "Rp 25.000"

        btnCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_keranjangFragment_to_pesananFragment)
        }
    }
}
