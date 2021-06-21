package com.eduardodev.mealplanner2.ui.screen.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.eduardodev.mealplanner2.ui.theme.MealPlanner2Theme

@Composable
fun BottomBar(
    selectedItem: NavigationItem,
    onItemSelected: (NavigationItem) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem.Recipes,
        NavigationItem.Calendar,
        NavigationItem.Ingredients
    )
    BottomNavigation {
        navigationItems.forEach { navigationItem ->
            BottomNavigationItem(
                selected = selectedItem == navigationItem,
                onClick = { onItemSelected(navigationItem) },
                icon = {
                    Icon(
                        imageVector = navigationItem.icon,
                        contentDescription = stringResource(navigationItem.title)
                    )
                },
                label = { Text(stringResource(navigationItem.title)) }
            )
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    MealPlanner2Theme {
        BottomBar(selectedItem = NavigationItem.Ingredients) {}
    }
}
