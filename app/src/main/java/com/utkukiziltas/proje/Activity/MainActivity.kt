package com.utkukiziltas.proje.Activity

import android.app.Dialog
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.utkukiziltas.proje.R
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup


class MainActivity : AppCompatActivity() {

    companion object {
        var movieList: ArrayList<HashMap<String, String>> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        setupBottomNavMenu(navController)

        JsonParse()
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(
            item
        )
    }

    fun onHakkindaClick(view: View) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_hakkinda)
        dialog.show()
    }

    fun JsonParse() {
        movieList.clear()

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val jsonUrl = "https://howtodoandroid.com/movielist.json"
        val data = Jsoup.connect(jsonUrl).ignoreContentType(true).execute().body()

        val stringBuilder: StringBuilder = StringBuilder(data)
        val json = JSONArray(stringBuilder.toString())

        for (i in 0 until json.length()) {
            val map = HashMap<String, String>()
            val jsonObject: JSONObject = json.getJSONObject(i)
            map["category"] = jsonObject.getString("category")
            map["imageUrl"] = jsonObject.getString("imageUrl")
            map["name"] = jsonObject.getString("name")
            map["desc"] = jsonObject.getString("desc")
            movieList.add(map)
        }
    }
}