package com.joincoded.bankapi.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.DarkGreen
import com.joincoded.bankapi.viewmodel.BankViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(viewModel: BankViewModel) {
    var amount by remember { mutableStateOf("0.0") }
    var isSuccess by remember { mutableStateOf(false) }

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
                        Text(text = "        KUWAIT FINANCE HOUSE", fontSize = 20.sp)
                        Image(
                            painter = painterResource(id = R.drawable.kfh2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(shape = MaterialTheme.shapes.small)
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
        ) {


            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.kfh2),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(shape = MaterialTheme.shapes.small)

            )


            OutlinedTextField(
                value = amount,
                onValueChange = { newAmount -> amount = newAmount },
                label = { Text("AMOUNT") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(Icons.Default.Menu, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )


            Button(
                onClick = {
                    val amountValue = amount.toDoubleOrNull()
                    if (amountValue != null && amountValue > 0) {
                        viewModel.deposit(amountValue) { result ->
                            isSuccess = result as Boolean
                        }
                    } else {

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Deposit")
            }


            if (isSuccess) {
                Text("Funds added successfully!")
            } else if (!isSuccess && amount.toDoubleOrNull() != null && amount.toDouble() > 0) {
                Text("Failed to add funds. Please try again.")
            }


            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = amount,
                onValueChange = { newAmount -> amount = newAmount },
                label = { Text("AMOUNT") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(Icons.Default.Menu, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )


            Button(
                onClick = {
                    val amountValue = amount.toDoubleOrNull()
                    if (amountValue != null && amountValue > 0) {
                        viewModel.deposit(amountValue) { result ->
                            isSuccess = result as Boolean
                        }
                    } else {

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Withdraw")
            }


            if (isSuccess) {
                Text("Funds added successfully!")
            } else if (!isSuccess && amount.toDoubleOrNull() != null && amount.toDouble() > 0) {
                Text("Failed to add funds. Please try again.")
            }

        }
    }


}
