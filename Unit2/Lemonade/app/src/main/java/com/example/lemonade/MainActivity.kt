package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageAndText()
                }
            }
        }
    }
}

@Composable
fun ImageAndText(modifier: Modifier = Modifier) {
    var stage by remember { mutableIntStateOf(1) }
    val imageResource = when(stage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when(stage) {
        1 -> R.string.select_lemon
        2 -> R.string.tap_the_lemon
        3 -> R.string.drink_it
        else -> R.string.do_it_again
    }
    Column(
        modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Button(
            onClick = {
                var taped = 0;
                val amountOfTaps = (1..4).random()
                if(stage == 2) {
                    taped++
                    if(taped == amountOfTaps) {
                        stage++
                    }
                } else if (stage == 4) {
                    stage = 1
                } else {
                    stage++
                }
            },
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null
            )
        }
        Spacer(
            modifier = modifier.height(16.dp)
        )
        Text(
            text = stringResource(id = textResource),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        ImageAndText()
    }
}