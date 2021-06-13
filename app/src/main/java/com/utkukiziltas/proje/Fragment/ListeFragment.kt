package com.utkukiziltas.proje.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utkukiziltas.proje.Activity.MainActivity
import com.utkukiziltas.proje.Adapter.MovieListAdapter
import com.utkukiziltas.proje.R

class ListeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_liste, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rcycMovieList)

        recyclerView.apply {

            layoutManager = LinearLayoutManager(view.context)
            adapter = MovieListAdapter(view.context ,MainActivity.movieList)
        }
    }
}