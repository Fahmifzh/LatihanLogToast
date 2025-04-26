package com.example.latihanlogtoast

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihanlogtoast.ui.theme.LatihanLogToastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appContext = applicationContext // ⬅️ ambil applicationContext di sini

        setContent {
            LatihanLogToastTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CuteGreeting(context = appContext) // ⬅️ lempar ke Composable
                }
            }
        }
    }
}

@Composable
fun CuteGreeting(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halo kamu! 👋",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Pakai applicationContext yang dilempar dari atas
                Toast.makeText(context, "Hai, kamu lucu banget hari ini! 🍭", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity", "Tombol diklik: Toast lucu ditampilkan! 🌸")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Text(text = "Klik Aku! 💖")
        }
    }
}
