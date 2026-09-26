package com.gpldroid.brcode

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme { Surface(modifier = Modifier.fillMaxSize()) { QRScreen() } }
    }
  }
}

private fun createQrBitmap(value: String, size: Int = 720): Bitmap {
  val matrix = QRCodeWriter().encode(value, BarcodeFormat.QR_CODE, size, size)
  val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
  for (x in 0 until size) for (y in 0 until size) {
    bitmap.setPixel(x, y, if (matrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
  }
  return bitmap
}

@Composable
private fun QRScreen() {
  var value by remember { mutableStateOf("") }
  var bitmap by remember { mutableStateOf<Bitmap?>(null) }

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
      minLines = 4,
      label = { Text("Text or URL") }
    )
    Button(
      onClick = { bitmap = createQrBitmap(value.trim()) },
      enabled = value.isNotBlank(),
      modifier = Modifier.fillMaxWidth()
    ) { Text("Generate QR") }
    bitmap?.let {
      Image(
        bitmap = it.asImageBitmap(),
        contentDescription = "Generated QR code",
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}
