package com.example.mygalon.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mygalon.R

class PesananFragment : Fragment() {

    private var selectedPaymentMethod: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesanan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCOD = view.findViewById<Button>(R.id.btnCOD)
        val btnQRIS = view.findViewById<Button>(R.id.btnQRIS)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)

        btnCOD.setOnClickListener {
            selectedPaymentMethod = "COD"
            btnCOD.setBackgroundColor(requireContext().getColor(android.R.color.darker_gray))
            btnQRIS.setBackgroundColor(requireContext().getColor(R.color.white))
            Toast.makeText(requireContext(), "Metode COD Dipilih", Toast.LENGTH_SHORT).show()
        }

        btnQRIS.setOnClickListener {
            selectedPaymentMethod = "QRIS"
            btnQRIS.setBackgroundColor(requireContext().getColor(android.R.color.darker_gray))
            btnCOD.setBackgroundColor(requireContext().getColor(R.color.white))
            Toast.makeText(requireContext(), "Metode QRIS Dipilih", Toast.LENGTH_SHORT).show()
        }

        btnOrder.setOnClickListener {
            when (selectedPaymentMethod) {
                "COD" -> {
                    findNavController().navigate(R.id.action_pesananFragment_to_pembayaranCodFragment)
                }
                "QRIS" -> {
                    try {
                        findNavController().navigate(R.id.action_pesananFragment_to_pembayaranQRISFragment)
                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), "Gagal memuat halaman QRIS: ${e.message}", Toast.LENGTH_LONG).show()
                        e.printStackTrace()
                    }
                }
                else -> {
                    Toast.makeText(requireContext(), "Pilih metode pembayaran terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
