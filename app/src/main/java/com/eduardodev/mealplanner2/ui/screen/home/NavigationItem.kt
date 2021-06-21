package com.eduardodev.mealplanner2.ui.screen.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.eduardodev.mealplanner2.R

sealed class NavigationItem(
    val icon: ImageVector,
    @StringRes val title: Int
) {
    object Recipes : NavigationItem(
        icon = Icons.Default.Restaurant,
        title = R.string.navigationItemRecipes
    )

    object Calendar : NavigationItem(
        icon = Icons.Default.CalendarToday,
        title = R.string.navigationItemCalendar
    )

    object Ingredients : NavigationItem(
        icon = Icons.Default.Fastfood,
        title = R.string.navigationItemIngredients
    )
}
