package com.example.mygalon.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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
        return inflater.inflate(R.layout.fragment_keranjang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewKeranjang)
        tvTotalHarga = view.findViewById(R.id.tvTotalHarga)
        btnCheckout = view.findViewById(R.id.btnCheckout)

        // DATA DUMMY (untuk ditampilkan di keranjangfragment)
        val dummyNama = "Galon Aqua 19L"
        val dummyHarga = "20.000"
        val dummyImage = R.drawable.aqua
        
        val keranjangList = listOf(
            galon(dummyNama, dummyHarga, merkGalon.Aqua, dummyImage)
        )
        
        // Tampilkan total harga dummy
        tvTotalHarga.text = "Rp $dummyHarga"

        // SETUP RECYCLERVIEW
        val adapter = GalonAdapter(keranjangList, isKeranjang = true) {
            // Klik item (tidak ada aksi)
        }
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // CHECKOUT -> NAVIGASI KE PESANAN
        btnCheckout.setOnClickListener {
            findNavController().navigate(R.id.action_keranjangFragment_to_pesananFragment)
        }
    }
}
