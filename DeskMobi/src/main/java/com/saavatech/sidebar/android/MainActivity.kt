package com.saavatech.sidebar.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saavatech.sidebar.Greeting
import com.saavatech.sidebar.android.widgets.Sidebar
import com.saavatech.sidebar.android.widgets.isMobileDevice

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingView(Greeting().greet())
                    App()
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}


@Composable
fun App() {
    val isMobile = isMobileDevice()

    Sidebar(
        isMobile = isMobile,
        sidebarContent = {
            Text("Sidebar Content")
            Button(onClick = { /* Handle click */ }) {
                Text("Click Me")
            }
        },
        mainContent = {
            Text("Main Content")
            // Add your main content here
        }
    )
}