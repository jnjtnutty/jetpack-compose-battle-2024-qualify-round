package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify2Screen() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Button(modifier = Modifier
                    .padding(8.dp)
                    .width(60.dp)
                    .height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp), onClick = { /*TODO*/ }) {
                    Text(
                        modifier = Modifier,
                        text = "Skip",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(102.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 80.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Next")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 32.dp)
        ) {
            TextDisplay()
            ImageDisplay(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 96.dp)
            )
            ImageIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 48.dp)
            )
        }
    }
}

@Composable
fun TextDisplay() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Lorem ipsum dolor sit amet",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
        // Description
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing\n elit. " +
                    "Donec egestas dictum lacinia. Integer arcu\n neque, porttitor ac metus quis, " +
                    "iaculis molestie\n magna. Vivamus molestie justo sed nulla lacinia, \n" +
                    "quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ImageDisplay(modifier: Modifier) {
    // Image
    Image(
        modifier = modifier
            .height(448.dp),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.img_qualify_2_onboard),
        contentDescription = ""
    )
}

@Composable
fun ImageIndicator(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(3) {
                CircleIndicator()
            }
            CurrentIndicator()
            CircleIndicator()
        }
    }
}

@Composable
fun CircleIndicator() {
    Box(
        modifier = Modifier
            .size(16.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
    )
}

@Composable
fun CurrentIndicator() {
    Box(
        modifier = Modifier
            .size(height = 16.dp, width = 32.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(16.dp)
            )
    )
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion