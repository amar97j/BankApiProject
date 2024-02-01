package com.joincoded.bankapi.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.DarkGreen
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.viewmodel.BankViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen(
    viewModel: BankViewModel,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Welcome to Kuwait Finance House", fontSize = 20.sp)
                        Image(
                            painter = painterResource(id = R.drawable.kfh2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(shape = MaterialTheme.shapes.small)
                        )
                    }


                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkGreen,
                    titleContentColor = Color.White

                )
            )
        }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )

        {
            Button(
                onClick = { onSignInClicked() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Sign In")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onSignUpClicked() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Sign Up")
            }

        }

    }

}


