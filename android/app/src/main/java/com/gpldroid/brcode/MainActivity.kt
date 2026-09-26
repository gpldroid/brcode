package com.gpldroid.brcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    MobileAds.initialize(this)
    setContent {
      MaterialTheme { Surface(modifier = Modifier.fillMaxSize()) { QRScreen() } }
    }
  }
}

@Composable
private fun QRScreen() {
  var value by remember { mutableStateOf("") }
  Column(
    modifier = Modifier.fillMaxSize().padding(24.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Text("BRCode", style = MaterialTheme.typography.headlineLarge)
    Text("QR Code Generator", style = MaterialTheme.typography.titleMedium)
    OutlinedTextField(
      value = value,
      onValueChange = { value = it },
      modifier = Modifier.fillMaxWidth(),
      minLines = 5,
      label = { Text("Text or URL") }
    )
    Button(
      onClick = { /* QR renderer will be added as a dedicated Android service. */ },
      enabled = value.isNotBlank(),
      modifier = Modifier.fillMaxWidth()
    ) { Text("Generate QR") }
  }
}
