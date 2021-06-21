package com.eduardodev.mealplanner2.ui.screen.ingredients

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eduardodev.mealplanner2.data.IngredientDataSource
import com.eduardodev.mealplanner2.model.Ingredient
import com.eduardodev.mealplanner2.model.Measure
import com.eduardodev.mealplanner2.ui.composable.CentredProgress
import com.eduardodev.mealplanner2.ui.theme.MealPlanner2Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IngredientListViewModel(
    dataSource: IngredientDataSource = IngredientDataSource()
) : ViewModel() {
    val viewState: Flow<ViewState> = dataSource
        .getAllIngredients()
        .map { ingredientList -> ViewState.Content(ingredientList) }
}

sealed class ViewState {
    object Loading : ViewState()
    data class Content(
        val ingredientList: List<Ingredient>
    ) : ViewState()
}

@Composable
fun IngredientsScreen(
    modifier: Modifier = Modifier,
    viewModel: IngredientListViewModel = viewModel()
) {
    val state = viewModel.viewState.collectAsState(initial = ViewState.Loading)
    when (val viewState = state.value) {
        is ViewState.Loading -> CentredProgress(modifier.fillMaxSize())
        is ViewState.Content -> IngredientList(
            ingredientList = viewState.ingredientList,
            modifier = modifier
        )
    }
}

@Composable
private fun IngredientList(
    ingredientList: List<Ingredient>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(ingredientList) { ingredient ->
            Ingredient(
                ingredient = ingredient,
                modifier = Modifier.clickable { /*TODO*/ }
            )
            Divider()
        }
    }
}

@Composable
private fun Ingredient(
    ingredient: Ingredient,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .defaultMinSize(minHeight = 48.dp)
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 4.dp,
                bottom = 4.dp
            )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = ingredient.name,
            style = MaterialTheme.typography.body1
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = ingredient.measure.name,
            style = MaterialTheme.typography.caption,
            color = Color.LightGray
        )
    }
}

@Preview
@Composable
private fun IngredientListPreview() {
    MealPlanner2Theme {
        IngredientList(
            List(5) {
                Ingredient(
                    name = "Ingredient $it",
                    measure = Measure("Measure $it")
                )
            }
        )
    }
}

@Preview
@Composable
private fun IngredientPreview() {
    MealPlanner2Theme {
        Ingredient(
            Ingredient(
                name = "Oil",
                measure = Measure(
                    name = "Litre"
                )
            )
        )
    }
}
