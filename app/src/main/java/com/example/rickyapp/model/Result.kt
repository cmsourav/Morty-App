package com.example.rickyapp.model

data class Result(
    var created: String? = null,
    var episode: List<String?>?,
    var gender: String?,
    var id: Int?,
    var image: String? = null,
    var location: Location?,
    var name: String? = null,
    var origin: Origin?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?
)