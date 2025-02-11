package com.example.tpapp.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tpapp.data.LostItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    navController: NavController, // NavController للتنقل
    onAddItem: (LostItem) -> Unit // دالة لإضافة العنصر
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    // استخدام Scaffold لإضافة AppBar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "إضافة عنصر جديد") }, // عنوان AppBar
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("home") // العودة إلى الصفحة الرئيسية
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "العودة"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            // Title Input
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("العنوان") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description Input
            TextField(
                value = description,
                onValueChange = { description = it },
                placeholder = { Text("الوصف") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Image URL Input
            TextField(
                value = imageUrl,
                onValueChange = { imageUrl = it },
                placeholder = { Text("رابط الصورة") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Add Button
            Button(
                onClick = {
                    val newItem = LostItem(
                        id = (0..1000).random(), // إنشاء معرف عشوائي
                        title = title,
                        description = description,
                        imageUrl = imageUrl
                    )
                    onAddItem(newItem)
                    navController.navigate("home") // العودة إلى الصفحة الرئيسية بعد الإضافة
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("إضافة عنصر")
            }
        }
    }
}