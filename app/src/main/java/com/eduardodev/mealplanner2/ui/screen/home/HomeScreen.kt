package com.eduardodev.mealplanner2.ui.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.eduardodev.mealplanner2.ui.composable.MealsTopAppBar
import com.eduardodev.mealplanner2.ui.screen.ingredients.IngredientsScreen
import com.eduardodev.mealplanner2.ui.theme.MealPlanner2Theme

@Composable
fun HomeScreen() {
    val selectedItemState: MutableState<NavigationItem> = remember {
        mutableStateOf(NavigationItem.Ingredients)
    }
    val selectedItem = selectedItemState.value

    Scaffold(
        topBar = { MealsTopAppBar(stringResource(selectedItem.title)) },
        bottomBar = {
            BottomBar(selectedItem) { newSelectedItem ->
                selectedItemState.value = newSelectedItem
            }
        }
    ) { Content(selectedItem) }
}

@Composable
private fun Content(
    selectedItem: NavigationItem
) {
    when (selectedItem) {
        NavigationItem.Ingredients -> IngredientsScreen()
        NavigationItem.Calendar -> {
            /*TODO*/
        }
        NavigationItem.Recipes -> {
            /*TODO*/
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MealPlanner2Theme {
        HomeScreen()
    }
}
