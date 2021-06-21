package com.eduardodev.mealplanner2.data

import com.eduardodev.mealplanner2.common.capitalise
import com.eduardodev.mealplanner2.model.Ingredient
import com.eduardodev.mealplanner2.model.Measure
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.getValue

fun DataSnapshot.toIngredient(): Ingredient? {
    val map = getValue<Map<String, String>>() ?: return null
    val name = map["name"]?.capitalise() ?: return null
    val measure = map["measure"]?.capitalise() ?: return null
    return Ingredient(name, Measure(measure))
}
