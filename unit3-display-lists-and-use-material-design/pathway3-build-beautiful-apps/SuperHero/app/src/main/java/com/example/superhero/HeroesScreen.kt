package com.example.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.RemeasurementModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository

@Composable
fun HeroesScreen() {
}

@Composable
fun HeroList(modifier: Modifier = Modifier, heroes: List<Hero>) {
    LazyColumn {
        items(heroes) { hero ->
            HeroItem(
                nameResId = hero.nameRes,
                descriptionResId = hero.descriptionRes,
                imageResId = hero.imageRes
                )
        }
    }
}


@Composable
fun HeroItem(
    modifier: Modifier = Modifier,
    @StringRes nameResId: Int,
    @StringRes descriptionResId: Int,
    @DrawableRes imageResId: Int
) {
    Row {
        Column {
            Text(text = stringResource(nameResId))
            Text(text = stringResource(descriptionResId))
        }
        Image(painter = painterResource(imageResId), contentDescription = null)
    }
}

@Preview
@Composable
fun HeroesScreenPreview() {
    HeroList(heroes = HeroesRepository.heroes)
}