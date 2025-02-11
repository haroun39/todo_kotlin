package com.example.tpapp.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tpapp.data.LostItem
import com.example.tpapp.ui.add.AddProductScreen
import com.example.tpapp.ui.details.ProductDetailsScreen
import com.example.tpapp.ui.home.HomeScreen

@Composable
fun NavGraph(lostItems: MutableList<LostItem>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                lostItems = lostItems,
                onSearch = {   /* Filter items */ },
                navController=navController,
                onItemClick = { item ->
                    navController.navigate("details/${item.id}")
                }
            )
        }
        composable("add") {
            AddProductScreen(
                onAddItem = { newItem ->
                    lostItems.add(newItem)
                    navController.popBackStack()
                },
                navController= navController
            )
        }
        composable("details/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
            val item = lostItems.find { it.id == itemId }
            if (item != null) {
                ProductDetailsScreen(item = item,navController)
            }
        }


    }
}