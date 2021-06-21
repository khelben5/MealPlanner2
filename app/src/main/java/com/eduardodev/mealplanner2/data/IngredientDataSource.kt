package com.eduardodev.mealplanner2.data

import com.eduardodev.mealplanner2.model.Ingredient
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


class IngredientDataSource {

    private val ingredientsFlow = MutableStateFlow(emptyList<Ingredient>())

    init {
        database
            .getReference("ingredients")
            .onChanged(
                onAddition = { ingredientsFlow.value += it },
                onRemoval = { ingredientsFlow.value -= it },
                map = DataSnapshot::toIngredient
            )
    }

    fun getAllIngredients(): Flow<List<Ingredient>> = ingredientsFlow
}
