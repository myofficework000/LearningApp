package com.example.learningapp.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningapp.modal.dto.UserAddress

@Composable
fun UserAddressScreen() {
    var userAddress by remember { mutableStateOf(UserAddress()) }

    Column {
        AddressTextField("Pincode", userAddress.pinCode) { value ->
            userAddress = userAddress.copy(pinCode = value)
        }
        AddressTextField("State", userAddress.state) { value ->
            userAddress = userAddress.copy(state = value)
        }
        AddressTextField("Country", userAddress.country) { value ->
            userAddress = userAddress.copy(country = value)
        }
        AddressTextField("City", userAddress.city) { value ->
            userAddress = userAddress.copy(city = value)
        }
        AddressTextField("Street", userAddress.street) { value ->
            userAddress = userAddress.copy(street = value)
        }

        Button(onClick = {
            // viewModel.saveUserAddress(userId, userAddress)
        }) {
            Text("Save Address")
        }
    }
}

@Composable
fun AddressTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = { newValue -> onValueChange(newValue) },
        modifier = Modifier.fillMaxWidth()
    )
    Text(text = label)
}

@Preview
@Composable
fun UserAddressScreenPreview() {
    UserAddressScreen()
}
