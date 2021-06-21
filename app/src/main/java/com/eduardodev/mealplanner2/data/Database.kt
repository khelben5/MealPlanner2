package com.eduardodev.mealplanner2.data

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

private const val DATABASE_URL = "https://meals-827b0-default-rtdb.europe-west1.firebasedatabase.app/"

val database by lazy {
    Firebase
        .database(DATABASE_URL)
        .apply { setPersistenceEnabled(true) }
}
