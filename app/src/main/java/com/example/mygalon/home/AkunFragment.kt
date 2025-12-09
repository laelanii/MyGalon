package com.example.mygalon.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.mygalon.LoginActivity
import com.example.mygalon.R

class AkunFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Menampilkan layout fragment_akun.xml
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        // Mengambil tombol logout dari layout
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        //intent implicit fungsi button customerservice
        // menggunakan view.findViewByID
        val imgbtnCS = view.findViewById<ImageButton>(R.id.imgbtnCS)
        imgbtnCS.setOnClickListener {
            // Nomor WhatsApp sebaiknya format internasional tanpa + atau 0 di depan (62...)
            val implicitWhatsapp = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6285947114647"))
            startActivity(implicitWhatsapp)
        }

        // Fungsi tombol logout tanpa AlertDialog
        btnLogout.setOnClickListener {

            // Menghapus data login dari SharedPreferences
            val sharedPref = requireActivity()
                .getSharedPreferences("USER_LOGIN", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // Pindah ke halaman Login
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }
}
