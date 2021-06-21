package com.eduardodev.mealplanner2.data

import android.util.Log
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference

fun <T> DatabaseReference.onChanged(
    onAddition: (T) -> Unit,
    onRemoval: (T) -> Unit,
    map: (DataSnapshot) -> T?
) {
    addChildEventListener(FirebaseListener(onAddition, onRemoval, map))
}

private class FirebaseListener<T>(
    private val onChildAdded: (T) -> Unit,
    private val onChildRemoved: (T) -> Unit,
    private val map: (DataSnapshot) -> T?
) : ChildEventListener {

    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
        map(snapshot)?.let(onChildAdded)
    }

    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
        TODO("not implemented")
    }

    override fun onChildRemoved(snapshot: DataSnapshot) {
        map(snapshot)?.let(onChildRemoved)
    }

    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
        TODO("not implemented")
    }

    override fun onCancelled(error: DatabaseError) {
        Log.e(FirebaseListener::class.simpleName, error.details)
    }
}
