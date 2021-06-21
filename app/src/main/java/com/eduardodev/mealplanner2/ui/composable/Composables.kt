package com.eduardodev.mealplanner2.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardodev.mealplanner2.ui.theme.MealPlanner2Theme

@Composable
fun MealsTopAppBar(title: String) {
    TopAppBar({ Text(title) })
}

@Preview
@Composable
private fun MealsTopAppBarPreview() {
    MealPlanner2Theme {
        MealsTopAppBar("This is the title")
    }
}

@Composable
fun MealsTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.defaultMinSize(minHeight = 48.dp),
        onClick = onClick
    ) { Text(text) }
}

@Preview
@Composable
fun MealsTextButtonPreview() {
    MealPlanner2Theme {
        MealsTextButton("Button") {}
    }
}

@Composable
fun CentredProgress(modifier: Modifier = Modifier) {
    Box(modifier) {
        CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun CentredProgressPreview() {
    MealPlanner2Theme {
        CentredProgress()
    }
}
