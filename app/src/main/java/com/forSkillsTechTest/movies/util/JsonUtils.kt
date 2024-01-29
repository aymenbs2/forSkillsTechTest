package com.forSkillsTechTest.movies.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object JsonUtils {
    val gson: Gson = GsonBuilder().create()
    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }

    // Parse a JSON string into an object of the specified class
    inline fun <reified T> fromJson(json: String): T {
        return gson.fromJson(json, T::class.java)
    }

}