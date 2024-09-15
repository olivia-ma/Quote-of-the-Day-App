package com.example.quoteofthedayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.hsv
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteofthedayapp.ui.theme.QuoteOfTheDayAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quote()
                }
            }
        }
    }
}

@Composable
fun Quote() {
    // quote list
    val quotes = listOf(
        "\"You will never win if you never begin.\" - Helen Rowland",
        "\"With the new day comes new strength and new thoughts.\" - Eleanor Roosevelt",
        "\"If you fell down yesterday, stand up today.\" - H. G. Wells",
        "\"Consult not your fears but your hopes and your dreams. Think not about your frustrations, but about your unfulfilled potential. Concern yourself not with what you tried and failed in, but with what it is still possible for you to do.\" - Pope John XXIII",
        "\"We may encounter many defeats but we must not be defeated.\" - Maya Angelou",
        "\"Do not wait; the time will never be 'just right.' Start where you stand, and work with whatever tools you may have at your command, and better tools will be found as you go along.\" - George Herbert",
        "\"You are never too old to set another goal or to dream a new dream.\" - Les Brown",
        "\"In order to succeed, we must first believe that we can.\" - Nikos Kazantzakis",
        "\"I am not afraid... I was born to do this.\" - Joan of Arc",
        "\"Where there is a will, there is a way. If there is a chance in a million that you can do something, anything, to keep what you want from ending, do it. Pry the door open or, if need be, wedge your foot in that door and keep it open.\" - Pauline Kael"
    )

    // state holding curr quote index
    var currIndex by remember { mutableStateOf(0) }

    // randomly select a new quote
    // ensures that same index isnt selected twice in a row
    fun nextQuote() {
        var newIndex = Random.nextInt(quotes.size)

        while (newIndex == currIndex) {
            newIndex = Random.nextInt(quotes.size)
        }

        currIndex = newIndex
    }

    // display quote and button
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = quotes[currIndex],
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.hsv(207.1f, 0.93f, 0.38f),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 35.sp
        )

        Spacer(modifier = Modifier.height(20.dp))


        ElevatedButton(onClick = { nextQuote() },
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.hsv(207.1f, 0.93f, 0.38f))) {
                Text(text = "New Quote", color = Color.White)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    QuoteOfTheDayAppTheme {
        Quote()
    }
}

