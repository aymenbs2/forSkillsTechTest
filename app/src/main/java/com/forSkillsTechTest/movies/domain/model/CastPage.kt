package com.forSkillsTechTest.movies.domain.model

import com.google.gson.annotations.SerializedName


data class CastPage (

  @SerializedName("id"   ) var id   : Int?            = null,
  @SerializedName("cast" ) var cast : ArrayList<Cast> = arrayListOf(),

  )