package com.example.excercise2lkotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.excercise2lkotlin.ui.theme.Excercise2LKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Excercise2LKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                    val buildings = intArrayOf(3, 5, 4, 4, 3, 1, 3, 2)
                    val direction = "EAST"
                    val output = getBuildingsWithSunset(buildings, direction)
                    Log.d("OUTPUT",output.toString())
                }
            }
        }
    }
}

fun getBuildingsWithSunset(buildings: IntArray, direction: String): List<Int> {
    val n = buildings.size
    val result = mutableListOf<Int>()

    if (direction == "EAST") {
        var maxSeenHeight = 0
        for (i in n - 1 downTo 0) {
            if (buildings[i] > maxSeenHeight) {
                result.add(i)
                maxSeenHeight = buildings[i]
            }
        }
    } else if (direction == "WEST") {
        var maxSeenHeight = 0
        for (i in 0 until n) {
            if (buildings[i] > maxSeenHeight) {
                result.add(i)
                maxSeenHeight = buildings[i]
            }
        }
    }

    return result.reversed()
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Excercise2LKotlinTheme {
        Greeting("Android")
    }
}