package com.utkukiziltas.proje

import android.content.Context

class AppLib {
    fun VeriKaydetString(key: String, value: String, context: Context) {
        val sharedPreferences = context.getSharedPreferences("AppLib", Context.MODE_PRIVATE)

        sharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    fun VeriGetirString(key: String, context: Context): String {
        val sharedPreferences = context.getSharedPreferences("AppLib", Context.MODE_PRIVATE)
        val value = sharedPreferences?.getString(key, "").toString()
        return value
    }
}