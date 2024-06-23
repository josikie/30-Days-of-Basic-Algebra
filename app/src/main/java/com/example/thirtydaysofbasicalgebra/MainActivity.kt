package com.example.thirtydaysofbasicalgebra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofbasicalgebra.ui.theme.ThirtyDaysOfBasicAlgebraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfBasicAlgebraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicAlgebraCardItem()
                }
            }
        }
    }
}

@Composable
fun BasicAlgebraCardItem(modifier: Modifier = Modifier){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
        ,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ){
            // text day
            Text(
                modifier = Modifier.padding(start=4.dp, bottom = 4.dp),
                text = stringResource(id = R.string.title_day_1),
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
            // text subtitle
            Text(
                modifier = Modifier.padding(start=4.dp, top = 8.dp, bottom = 12.dp),
                text = stringResource(id = R.string.subtitle_1),
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp
            )
            // image
            Image(
                painter = painterResource(id = R.drawable.one),
                contentDescription = stringResource(id = R.string.subtitle_1),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
            )
        }
        
        // lines
        Spacer(
         modifier = Modifier
             .fillMaxWidth()
             .height(1.dp)
             .background(Color.LightGray)
        )

        // button arrow
        IconButton(
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
    }
}

@Composable
fun CustomLine() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val startX = 20f
        val startY = 24f
        val endX = size.width - 20f
        val endY = size.height
        drawLine(
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            color = Color.Blue,
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )
    }
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
    ThirtyDaysOfBasicAlgebraTheme {
        BasicAlgebraCardItem()
    }
}