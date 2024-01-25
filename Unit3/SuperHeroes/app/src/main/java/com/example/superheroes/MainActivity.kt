package com.example.superheroes

import android.os.Bundle
import androidx.compose.foundation.lazy.items
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superheroes.data.Hero
import com.example.superheroes.data.heroes
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    
                            ListOfHeroCards()
                        
                    }
                
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
            .clip(Shapes.medium)
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)) {

            Column(

                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = hero.title),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier
                .weight(1f)
            )
            Box(modifier = Modifier
                .padding(8.dp)) {
                Image(
                    painter = painterResource(id = hero.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(Shapes.small)
                        .size(56.dp)

                )
            }
        }

    }
}

@Composable
fun ListOfHeroCards(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HeroesTopBar(modifier = Modifier
            .padding(24.dp)
        )}
    ) {
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroCard(hero = it)
            }
        }
    }
}

@Composable
fun HeroesTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Heroes",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun PreviewCard() {
    ListOfHeroCards()
}