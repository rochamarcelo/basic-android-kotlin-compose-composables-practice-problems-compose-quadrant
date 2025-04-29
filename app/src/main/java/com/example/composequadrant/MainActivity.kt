package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrant(
//                        name1 = "Text composable",
//                        description1 = "Displays text and follows the recommended Material Design guidelines.",
//                        name2 = "Image composable",
//                        description2 = "Creates a composable that lays out and draws a given Painter class object.",
//                        name3 = "Row composable",
//                        description3 = "A layout composable that places its children in a horizontal sequence.",
//                        name4 = "Column composable",
//                        description4 = "A layout composable that places its children in a vertical sequence.",
                        modifier = Modifier.padding(innerPadding),
                        list = listOf(
                            listOf(
                                mapOf(
                                    "name" to stringResource(R.string.quadrant_name1),
                                    "description" to stringResource(R.string.quadrant_description1),
                                    "color" to R.color.q1.toString()
                                ),
                                mapOf(
                                    "name" to stringResource(R.string.quadrant_name2),
                                    "description" to stringResource(R.string.quadrant_description2),
                                    "color" to R.color.q2.toString()
                                ),
                            ),
                            listOf(
                                mapOf(
                                    "name" to stringResource(R.string.quadrant_name3),
                                    "description" to stringResource(R.string.quadrant_description3),
                                    "color" to R.color.q2.toString()
                                ),
                                mapOf(
                                    "name" to stringResource(R.string.quadrant_name4),
                                    "description" to stringResource(R.string.quadrant_description4),
                                    "color" to R.color.q3.toString()
                                ),
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(name: String, description: String, colorId: Int, modifier: Modifier = Modifier) {
    val bg = colorResource(colorId);
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(bg)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}
@Composable
fun ComposableQuadrantRow(items: List<Map<String, String>>, modifier: Modifier) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items.map { item -> Quadrant(
            name = item.get("name").toString(),
            description = item.get("description").toString(),
            colorId = item.get("color").toString().toInt(),
            modifier = Modifier.weight(1f),
        ) }
    }
}
@Composable
fun ComposeQuadrant(
//    name1: String,
//    description1: String,
//    name2: String,
//    description2: String,
//    name3: String,
//    description3: String,
//    name4: String,
//    description4: String,
    list: List<List<Map<String, String>>>,
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier.fillMaxSize(),
    ) {
        list.map { value ->  ComposableQuadrantRow(
            items = value,
            modifier = Modifier.weight(1f)
        ) }
//        Row (
//            modifier = Modifier.weight(1f),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Quadrant(
//                name = name1,
//                description = description1,
//                modifier = Modifier.weight(1f),
//                color = color1
//            )
//            Quadrant(
//                name = name2,
//                description = description2,
//                modifier = Modifier.weight(1f),
//                color = color2,
//            )
//        }
//        Row (modifier = Modifier.weight(1f)) {
//            Quadrant(
//                name = name3,
//                description = description3,
//                modifier = Modifier.weight(1f),
//                color = color3,
//            )
//            Quadrant(
//                name = name4,
//                description = description4,
//                modifier = Modifier.weight(1f),
//                color = color4,
//            )
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant(
//            name1 = stringResource(R.string.quadrant_name1),
//            description1 = stringResource(R.string.quadrant_description1),
//            name2 = stringResource(R.string.quadrant_name2),
//            description2 = stringResource(R.string.quadrant_description2),
//            name3 = stringResource(R.string.quadrant_name3),
//            description3 = stringResource(R.string.quadrant_description3),
//            name4 = stringResource(R.string.quadrant_name4),
//            description4 = stringResource(R.string.quadrant_description4),
            list = listOf(
                listOf(
                    mapOf("name" to stringResource(R.string.quadrant_name1), "description" to stringResource(R.string.quadrant_description1), "color" to R.color.q1.toString()),
                    mapOf("name" to stringResource(R.string.quadrant_name2), "description" to stringResource(R.string.quadrant_description2), "color" to R.color.q2.toString()),
                ),
                listOf(
                    mapOf("name" to stringResource(R.string.quadrant_name3), "description" to stringResource(R.string.quadrant_description3), "color" to R.color.q2.toString()),
                    mapOf("name" to stringResource(R.string.quadrant_name4), "description" to stringResource(R.string.quadrant_description4), "color" to R.color.q3.toString()),
                )
            )
        )
    }
}