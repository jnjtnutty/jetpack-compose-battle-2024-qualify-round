package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify3Screen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "John Doe",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(id = R.drawable.ic_qualify_3_back),
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                actions = {
                    Row {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                            contentDescription = "Copy",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Icon(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                            contentDescription = "Calendar",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Icon(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .padding(start = 16.dp, top = 16.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ImageList(
                    painters = listOf(
                        painterResource(id = R.drawable.img_qualify_3_photo_1),
                        painterResource(id = R.drawable.img_qualify_3_photo_2),
                        painterResource(id = R.drawable.img_qualify_3_photo_3),
                    ), focusIndex = 0
                )
                TagComponentList(tagList = listOf("Tag1", "Tag2", "Tag3", "Tag4"), focusIndex = 0)
                CardLists()
            }
        }
    }
}

@Composable
fun ImageList(painters: List<Painter>, focusIndex: Int = 0) {

    val focusModifier = Modifier
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(size = 16.dp)
        )
        .clip(RoundedCornerShape(size = 16.dp))
        .width(160.dp)
        .height(320.dp)

    val unFocusModifier = Modifier
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(size = 16.dp)
        )
        .clip(RoundedCornerShape(size = 16.dp))
        .width(160.dp)
        .height(320.dp)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(painters.size) { index ->
            Image(
                modifier = if (index != focusIndex) unFocusModifier else focusModifier,
                painter = painters[index],
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

@Composable
fun TagComponentList(tagList: List<String>, focusIndex: Int = 0) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tagList.size) { index ->
            OutlinedButton(
                modifier = Modifier
                    .width(68.dp)
                    .height(32.dp),
                border = if (index != focusIndex)
                    BorderStroke(1.dp, color = MaterialTheme.colorScheme.outline)
                else BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = if (index != focusIndex) MaterialTheme.colorScheme.outline
                    else MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = {}
            ) {
                Text(text = tagList[index], style = MaterialTheme.typography.labelLarge)
            }
        }
    }

}

@Composable
fun CardLists() {
    val painters = listOf(painterResource(id = R.drawable.img_qualify_3_sender))
    val nameLists = listOf("Lorem Ipsum")
    val desLists = listOf(
        "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
        "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
        "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
        "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
    )
    LazyColumn(
        modifier = Modifier.padding(end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(4) { index ->
            CardComponent(painters[0], name = nameLists[0], description = desLists[index])
        }
    }
}

@Composable
fun CardComponent(painter: Painter, name: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape),
                painter = painter,
                contentDescription = null
            )
            Column {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion