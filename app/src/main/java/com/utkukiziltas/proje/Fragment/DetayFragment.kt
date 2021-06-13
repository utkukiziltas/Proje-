package com.utkukiziltas.proje.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.utkukiziltas.proje.Activity.MainActivity
import com.utkukiziltas.proje.Adapter.MovieListAdapter
import com.utkukiziltas.proje.AppLib
import com.utkukiziltas.proje.R
import kotlinx.android.synthetic.main.fragment_liste.*

class DetayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detay, container, false)

        val tvBaslik = view.findViewById<TextView>(R.id.tvBaslik)
        val tvAciklama = view.findViewById<TextView>(R.id.tvAciklama)
        val ivResim = view.findViewById<ImageView>(R.id.ivResim)

        tvBaslik.text = AppLib().VeriGetirString("name", view.context)
        tvAciklama.text = AppLib().VeriGetirString("desc", view.context)

        if (AppLib().VeriGetirString("imageUrl", view.context) != "") {
            Picasso.get().load(AppLib().VeriGetirString("imageUrl", view.context)).into(ivResim)

        }

        return view
    }

}