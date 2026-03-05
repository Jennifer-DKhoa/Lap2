package com.example.lab4_tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4_tiptime.ui.theme.Baitap_Lap1Theme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Baitap_Lap1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier.padding(40.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tính Tiền Tip", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        EditNumberField(
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth()
        )

        Text(text = "Số tiền tip: $tip", fontSize = 20.sp, style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Developed by Nguyen Dang Khoa", fontSize = 14.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Số tiền hóa đơn") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Chỉ hiện bàn phím số
        modifier = modifier
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}