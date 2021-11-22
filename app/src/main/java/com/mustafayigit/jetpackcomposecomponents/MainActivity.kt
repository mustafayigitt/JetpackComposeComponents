package com.mustafayigit.jetpackcomposecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mustafayigit.jetpackcomposecomponents.ui.theme.JetpackComposeComponentsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

sealed class Animal(@DrawableRes val imageSrc: Int) {
    object Dog : Animal(R.drawable.image_dog)
    object Cat : Animal(R.drawable.image_cat)
}

@Composable
fun HomeScreen() {
    JetpackComposeComponentsTheme {

        val scrollState = rememberScrollState()
        val scope = rememberCoroutineScope()
        var selectedAnimal by remember { mutableStateOf<Animal?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello Compose",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            Image(
                painter = painterResource(
                    id = selectedAnimal?.imageSrc ?: R.drawable.ic_launcher_foreground
                ),
                contentDescription = "selected animal image",
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.75f)
                    .aspectRatio(3 / 8f),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                RadioButton(
                    selected = selectedAnimal is Animal.Dog,
                    onClick = { selectedAnimal = Animal.Dog },
                )

                RadioButton(
                    selected = selectedAnimal is Animal.Cat,
                    onClick = { selectedAnimal = Animal.Cat },
                )
            }

            Button(
                onClick = {
                    scope.launch {
                        scrollState.animateScrollTo(0)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(text = "Scroll to Top")
            }

            Spacer(modifier = Modifier.size(100.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}