package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridCard()

                }
            }
        }
    }
}

@Composable
fun GridCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(68.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.architecture),
                contentDescription = null,
                modifier
                    .height(68.dp)

            )
            Column {
                Text(text = stringResource(
                    id = R.string.architecture),
                    modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                )
                Row(modifier = modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)) {
                    Icon(Icons.Rounded.Check, contentDescription = null )
                    Text(text = "321")
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    GridCard()
}