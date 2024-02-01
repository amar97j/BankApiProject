package com.joincoded.bankapi.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.R
import com.joincoded.bankapi.viewmodel.BankViewModel

@Composable
fun ProfileScreen(viewModel: BankViewModel) {
    val profileInfo = viewModel.profileInfo3

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.kfh2),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .padding(8.dp)
        )



        Spacer(modifier = Modifier.height(16.dp))
        Text(text = profileInfo[0].user.username)


        Text(text = profileInfo[0].user.password)

        Spacer(modifier = Modifier.height(8.dp))


          Text("Failed to fetch profile information.")
    }
}

