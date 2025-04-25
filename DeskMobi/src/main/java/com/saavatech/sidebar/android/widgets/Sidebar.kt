package com.saavatech.sidebar.android.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sidebar(
    isMobile: Boolean, // Determines if the app is running on a mobile device
    sidebarContent: @Composable () -> Unit,
    mainContent: @Composable () -> Unit
) {
    if (isMobile) {
        // Mobile layout: Sidebar is hidden by default and can be toggled
        var isSidebarVisible by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My App") },
                    actions = {
                        IconButton(onClick = { isSidebarVisible = !isSidebarVisible }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },

//            drawerContent = {
//                if (isSidebarVisible) {
//                    DrawerContent(sidebarContent)
//                }
//            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                mainContent()
            }
        }
    } else {
        // Desktop layout: Sidebar is always visible
        Row(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.width(240.dp)) {
                sidebarContent()
            }
            Box(modifier = Modifier.weight(1f)) {
                mainContent()
            }
        }
    }
}

@Composable
fun DrawerContent(sidebarContent: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        sidebarContent()
    }
}

@Composable
fun isMobileDevice(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp < 600 // Adjust threshold as needed
}