package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
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
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtApp()
                }
            }
        }
    }
}

@Composable
fun ImageAndDescription(
    currentImage:Int,
    modifier: Modifier = Modifier
) {
    var imagePainter = when(currentImage) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
        .fillMaxWidth()) {
        Image(
            painter = painterResource(id = imagePainter),
            contentDescription = null,
            modifier = modifier.size(500.dp)
        )
        Text(
            text = stringResource(id = R.string.art_description, currentImage),
            fontSize = 36.sp
        )

    }


}

@Composable
fun Buttons(
    currentImage: Int,
    nextImage: () -> Unit,
    previousImage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(onClick = { previousImage() }) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = null)
        }
        Button(onClick = { nextImage() }) {
            Icon(Icons.Rounded.ArrowForward, contentDescription = null)
        }
    }
}

@Composable
fun ArtApp() {
    var currentImage: Int by remember { mutableIntStateOf(1)}
    val nextImage = {
        if(currentImage in (1..5)) {
            currentImage++
        }
    }
    val previousImage = {
        if(currentImage in (2..6)) {
            currentImage--
        }
    }
    LazyColumn {
        item {
            ImageAndDescription(currentImage)
            Buttons(currentImage, nextImage, previousImage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    ArtGalleryTheme {
        ArtApp()
    }
}