package com.example.bussinesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun MainPart(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.untitled_artwork),
            contentDescription = null
        )
        Text(
            text = "Korniiko Maksym",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Android Developer",
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Icon(Icons.Rounded.Phone, contentDescription = "Phone icon", tint = Color.White)
            Icon(Icons.Rounded.Share, contentDescription = "Share icon", tint = Color.White)
            Icon(Icons.Rounded.Email, contentDescription = "Email icon", tint = Color.White)
        }
        Column(modifier = modifier.padding(8.dp)) {
            Row {
                Text(
                text = stringResource(R.string.phone_number),
                color = Color.White,
                modifier = modifier.padding(1.5.dp)
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.share),
                    color = Color.White,
                    modifier = modifier.padding(1.5.dp)
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.email),
                    color = Color.White,
                    modifier = modifier.padding(1.5.dp)
                )
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xff1a1a20)),
       ) {
        MainPart(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.weight(1f))
        Footer()
    }
}
@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BusinessCard()
    }
}