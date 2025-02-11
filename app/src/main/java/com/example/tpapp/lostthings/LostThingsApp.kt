package com.example.tpapp.lostthings

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.tpapp.data.LostItem
import com.example.tpapp.ui.navigation.NavGraph

@SuppressLint("RememberReturnType")
@Composable
fun LostThingsApp() {
    val lostItems = remember { mutableStateListOf<LostItem>() }
    return NavGraph(lostItems = lostItems)
}