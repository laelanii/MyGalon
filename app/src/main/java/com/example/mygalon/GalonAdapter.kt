package com.example.mygalon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GalonAdapter(
    private val listGalon: List<galon>,
    private val isKeranjang: Boolean = false, // Parameter baru untuk mode keranjang
    private val onClickItemGalon: (galon) -> Unit
) : RecyclerView.Adapter<GalonAdapter.GalonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk, parent, false)
        return GalonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGalon.size
    }

    override fun onBindViewHolder(holder: GalonViewHolder, position: Int) {
        val galon = listGalon[position]
        holder.bind(galon)
    }

    inner class GalonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaProduk: TextView = itemView.findViewById(R.id.tvNamaProduk)
        private val imgProduk: ImageView = itemView.findViewById(R.id.imageProduk)

        fun bind(galon: galon) {
            tvNamaProduk.text = galon.namaGalon

            // Mengatur gambar berdasarkan merk Galon atau properti image (jika sudah diupdate di galon.kt)
            // Menggunakan resource yang dikirim di imageProduk jika ada (dari revisi sebelumnya)
            // Atau fallback ke when clause

            if (galon.ImageProduk != 0) {
                imgProduk.setImageResource(galon.ImageProduk)
            } else {
                val imageResource = when (galon.merkGalon) {
                    merkGalon.Aqua -> R.drawable.aqua
                    merkGalon.LeMinerale -> R.drawable.lemineral
                    merkGalon.Cleo -> R.drawable.cleo
                    merkGalon.Oasis -> R.drawable.oasis
                }
                imgProduk.setImageResource(imageResource)
            }

            itemView.setOnClickListener {
                onClickItemGalon(galon)
            }
        }
    }
}
