package com.example.mygalon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GalonAdapter(val listGalon: List<galon>, val onClickItemGalon:(galon)-> Unit): RecyclerView.Adapter<GalonAdapter.GalonViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalonAdapter.GalonViewHolder {
        TODO("layout galon nanti")
    }
}