package com.joincoded.bankapi.data

data class User(
    var username: String,
    var password: String,
    var image: String?,
    var token: String?

) {
    constructor (username: String, password: String) : this(username, password, null, null) {

    }
}

