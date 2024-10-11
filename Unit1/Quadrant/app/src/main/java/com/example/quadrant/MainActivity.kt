package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FourQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .background(color)
        .padding(12.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = title,
            modifier = Modifier.padding(12.dp),
            color = Color.Black
        )
        Text(
            text = description,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
fun FourQuadrant(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.title1),
                description = stringResource(id = R.string.description1),
                color = Color(0xFFEADDFF),
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.title2),
                description = stringResource(id = R.string.description2),
                color = Color(0xFFD0BCFF),
                modifier = modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(id = R.string.title3),
                description = stringResource(id = R.string.description3),
                color = Color(0xFFB69DF8),
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.title4),
                description = stringResource(id = R.string.description4),
                color = Color(0xFFF6EDFF),
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        FourQuadrant()
    }
}