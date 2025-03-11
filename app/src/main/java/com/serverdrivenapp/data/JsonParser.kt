package com.serverdrivenapp.data

import com.google.gson.Gson

object JsonParser {
    inline fun <reified T> fromJson(json: String): T {
        return Gson().fromJson(json, T::class.java)
    }
}