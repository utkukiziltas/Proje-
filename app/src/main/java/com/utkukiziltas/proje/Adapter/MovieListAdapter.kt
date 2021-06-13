package com.utkukiziltas.proje.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utkukiziltas.proje.AppLib
import com.utkukiziltas.proje.R
import kotlinx.android.synthetic.main.row_movielist.view.*

class MovieListAdapter(private val context: Context, private val movieList:ArrayList<HashMap<String, String>>): RecyclerView.Adapter<MovieListAdapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val category: TextView = view.findViewById<TextView>(R.id.tvKategori)
        val name: TextView = view.findViewById(R.id.tvIsim)
        val desc: TextView = view.findViewById(R.id.tvAciklama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_movielist, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
         holder.category.text = movieList[position]["category"]
         holder.name.text = movieList[position]["name"]
         holder.desc.text = movieList[position]["desc"]

        holder.itemView.setOnClickListener {
            AppLib().VeriKaydetString("name", movieList[position]["name"].toString(), context)
            AppLib().VeriKaydetString("desc", movieList[position]["desc"].toString(), context)
            AppLib().VeriKaydetString("imageUrl", movieList[position]["imageUrl"].toString(), context)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}