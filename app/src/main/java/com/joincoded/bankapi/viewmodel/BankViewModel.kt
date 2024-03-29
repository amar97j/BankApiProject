package com.joincoded.bankapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.ProfileInfo
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.BankApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.launch

class BankViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BankApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)

    var profileInfo3 by mutableStateOf(listOf<ProfileInfo>())


    fun signup(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, image, null))
                token = response.body()

                if (token != null) {
                    apiService.deposit(token = token?.getBearerToken(), AmountChange(0.0))
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun signin(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signin(User(username, password, null, null))
                token = response.body()
                println("singin $token")
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun deposit(amount: Double, param: (Any) -> Unit) {
        viewModelScope.launch {
            try {
                val response =
                    apiService.deposit(token = token?.getBearerToken(), AmountChange(amount))

            } catch (e: Exception) {
                println("Error $e")
            }

        }

        fun withdraw(amount: Double, param: (Any) -> Unit) {
            viewModelScope.launch {
                try {
                    val response =
                        apiService.withdraw(token = token?.getBearerToken(), AmountChange(amount))

                } catch (e: Exception) {
                    println("Error $e")
                }

            }
        }


    }


}












