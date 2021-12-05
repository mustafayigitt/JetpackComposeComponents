package com.mustafayigit.jetpackcomposecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mustafayigit.jetpackcomposecomponents.ui.theme.JetpackComposeComponentsTheme
import com.mustafayigit.jetpackcomposecomponents.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
) {
    val count by homeViewModel.count.collectAsState()

    JetpackComposeComponentsTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = count.toString(),
                style = MaterialTheme.typography.h5,
            )

            Spacer(modifier = Modifier.size(30.dp))

            CountButton("Increment Count") { homeViewModel.incrementCount() }

            Spacer(modifier = Modifier.size(20.dp))

            CountButton("Reset") { homeViewModel.resetCount() }

        }
    }
}

@Composable
fun CountButton(text: String, action: () -> Unit) {

    Button(
        onClick = action,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}