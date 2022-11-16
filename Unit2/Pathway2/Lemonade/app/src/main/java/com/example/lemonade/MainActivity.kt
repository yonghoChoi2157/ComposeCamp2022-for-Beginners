package com.example.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonScreen()
                }
            }
        }
    }
}

@Composable
fun LemonScreen() {
    var level by remember {
        mutableStateOf(1)
    }
    val imageResource: Int
    var squeezeCount = 0
    val text: String
    when (level) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            text = stringResource(id = R.string.lemon_text1)
        }
        2 -> {
            squeezeCount = (2..4).random()
            imageResource = R.drawable.lemon_squeeze
            text = stringResource(id = R.string.lemon_text2)
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            text = stringResource(id = R.string.lemon_text3)
        }
        else -> {
            imageResource = R.drawable.lemon_restart
            text = stringResource(id = R.string.lemon_text4)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .border(1.dp, Color.Red)
                .clickable {
                    if (level == 4) {
                        level = 1
                    } else if (level == 2) {
                        if (squeezeCount == 0) {
                            level++
                        } else {
                            squeezeCount--
                        }
                    } else {
                        level++
                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonScreen1() {
    LemonScreen()
}