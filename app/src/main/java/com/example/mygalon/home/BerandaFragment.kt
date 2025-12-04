package com.example.mygalon.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygalon.GalonAdapter
import com.example.mygalon.R
import com.example.mygalon.galon
import com.example.mygalon.merkGalon

class BerandaFragment : Fragment() {
//    Mendeklarasikan RecylerView
    private lateinit var rvProduk: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

// Menghubungkan RecyclerView dengan xml
        rvProduk = view.findViewById(R.id.rvProduk)
// Data list galon
        val listGalon = listOf(
            galon("Galon Aqua 19L", "-", merkGalon.Aqua, R.drawable.aqua),
            galon("Galon Le Minerale 19L", "-", merkGalon.LeMinerale, R.drawable.lemineral),
            galon("Galon Cleo 19L", "-", merkGalon.Cleo, R.drawable.cleo),
            galon("Galon Oasis 19L", "-", merkGalon.Oasis, R.drawable.oasis)
        )

        val adapter = GalonAdapter(listGalon) { galon ->
            Toast.makeText(requireContext(), "Dipilih: ${galon.namaGalon}", Toast.LENGTH_SHORT).show()
        }

        rvProduk.layoutManager = GridLayoutManager(requireContext(), 2)
        rvProduk.adapter = adapter
    }
}
