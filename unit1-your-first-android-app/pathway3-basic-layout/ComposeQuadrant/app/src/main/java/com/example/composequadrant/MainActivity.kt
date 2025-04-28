package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun QuadrantScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                modifier = modifier
                    .weight(1f)
            ) {
                QuadrantCard(
                    "Text composable",
                    "Displays text and follows the recommended Material Design guidelines.",
                    modifier = modifier
                        .weight(1f)
                        .background(color = Color(0xFFEADDFF))
                )
                QuadrantCard(
                    "Image composable",
                    "Creates a composable that lays out and draws a given Painter class object.",
                    modifier = modifier
                        .weight(1f)
                        .background(color = Color(0xFFD0BCFF))
                )
            }
            Row(
                modifier = modifier
                    .weight(1f)
            ) {
                QuadrantCard(
                    "Row composable",
                    "A layout composable that places its children in a horizontal sequence.",
                    modifier = modifier
                        .weight(1f)
                        .background(color = Color(0xFFB69DF8))
                )
                QuadrantCard(
                    "Column composable",
                    "A layout composable that places its children in a vertical sequence.",
                    modifier = modifier
                        .weight(1f)
                        .background(color = Color(0xFFEADDFF))
                )
            }
        }
    }

    @Composable
    fun QuadrantCard(title: String, description: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                description,
                textAlign = TextAlign.Justify
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        QuadrantScreen()
    }
}