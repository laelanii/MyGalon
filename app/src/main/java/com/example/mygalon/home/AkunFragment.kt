package com.example.mygalon.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.mygalon.LoginActivity
import com.example.mygalon.R

class AkunFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    // HAPUS DATA LOGIN
                    val sharedPref = requireActivity()
                        .getSharedPreferences("USER_LOGIN", Context.MODE_PRIVATE)

                    sharedPref.edit().clear().apply()

                    // PINDAH KE HALAMAN LOGIN
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }
                .setNegativeButton("Batal", null)
                .show()
        }

        return view
    }


}