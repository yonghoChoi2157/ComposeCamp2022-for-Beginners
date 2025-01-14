package com.netmania.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netmania.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> {
            ArtInfo(
                titleTextResourceId = R.string.img1_title,
                nameTextResourceId = R.string.img1_name,
                dateTextResourceId = R.string.img1_date,
                drawableResourceId = R.drawable.leellamarz_img,
                onPreviousBtnClick = {
                    currentStep = 4
                },
                onNextBtnClick = {
                    currentStep = 2
                }
            )
        }
        2 -> {
            ArtInfo(
                titleTextResourceId = R.string.img2_title,
                nameTextResourceId = R.string.img2_name,
                dateTextResourceId = R.string.img2_date,
                drawableResourceId = R.drawable.ashlsland_img,
                onPreviousBtnClick = {
                    currentStep = 1
                },
                onNextBtnClick = {
                    currentStep = 3
                }
            )
        }
        3 -> {
            ArtInfo(
                titleTextResourceId = R.string.img3_title,
                nameTextResourceId = R.string.img3_name,
                dateTextResourceId = R.string.img3_date,
                drawableResourceId = R.drawable.penomeco_img,
                onPreviousBtnClick = {
                    currentStep = 2
                },
                onNextBtnClick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            ArtInfo(
                titleTextResourceId = R.string.img4_title,
                nameTextResourceId = R.string.img4_name,
                dateTextResourceId = R.string.img4_date,
                drawableResourceId = R.drawable.zico_img,
                onPreviousBtnClick = {
                    currentStep = 3
                },
                onNextBtnClick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun ArtInfo(
    titleTextResourceId: Int,
    nameTextResourceId: Int,
    dateTextResourceId: Int,
    drawableResourceId: Int,
    onPreviousBtnClick: () -> Unit,
    onNextBtnClick: () -> Unit
) {


    Column {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = drawableResourceId),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .border(
                        BorderStroke(2.dp, Color(red = 0, green = 0, blue = 0, alpha = 255)),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(20.dp)
            )
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
            Card(
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 20.dp,
                modifier = Modifier.padding(20.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(id = titleTextResourceId),
                        fontSize = 24.sp
                    )
                    Row {
                        Text(
                            text = stringResource(id = nameTextResourceId),
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = " (${stringResource(id = dateTextResourceId)})")
                    }
                }
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {

            Button(
                onClick = { onPreviousBtnClick() },
                modifier = Modifier.width(130.dp).align(BottomStart).padding(start = 20.dp),
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { onNextBtnClick() },
                modifier = Modifier.width(130.dp).align(BottomEnd).padding(end = 20.dp),
            ) {
                Text(text = "Next")
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}