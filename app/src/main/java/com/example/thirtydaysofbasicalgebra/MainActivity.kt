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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofbasicalgebra.data.BasicAlgebra
import com.example.thirtydaysofbasicalgebra.data.BasicAlgebraRepo
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
                    BasicAlgebraList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysTopAppBar(modifier: Modifier){
    CenterAlignedTopAppBar(
        modifier = modifier.height(70.dp),
        title = {
            Image(
                modifier = Modifier.padding(top = 10.dp),
                painter = painterResource(id = R.drawable.top_app_logo),
                contentDescription = stringResource(id = R.string.app_name),
            )
        }
    )
}
@Composable
fun BasicAlgebraList(modifier: Modifier = Modifier,
                 listLesson: List<BasicAlgebra> = BasicAlgebraRepo.basicAlgebra
){
    Scaffold (
        topBar = {
            ThirtyDaysTopAppBar(modifier)
        }
    ) {
        LazyColumn(contentPadding = it){
            items(listLesson.size){i ->
                BasicAlgebraCardItem(lessonAlgebra = listLesson[i])
            }
        }
    }
}
@Composable
fun BasicAlgebraCardItem(
    modifier: Modifier = Modifier,
    lessonAlgebra: BasicAlgebra
    ){
    var expanded by remember{ mutableStateOf(false) }
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
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
                text = stringResource(id = lessonAlgebra.title),
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
            // text subtitle
            Text(
                modifier = Modifier.padding(start=4.dp, top = 8.dp, bottom = 12.dp),
                text = stringResource(id = lessonAlgebra.subTitle),
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp
            )
            // image
            Image(
                painter = painterResource(id = lessonAlgebra.image),
                contentDescription = stringResource(id = lessonAlgebra.subTitle),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
            )
        }
        
        // description
        if(expanded){
            LessonDescription(lessonDescription = lessonAlgebra.description,
                modifier = Modifier.padding(start = 28.dp, end = 16.dp, top = 16.dp, bottom = 16.dp))
        }
        
        // lines
        Spacer(
         modifier = Modifier
             .fillMaxWidth()
             .height(1.dp)
             .background(Color.LightGray)
        )

        // button arrow
        ButtonWider(expanded = expanded, onClick = { expanded = !expanded })
    }
}

@Composable
fun ButtonWider(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onClick:  () -> Unit){
    IconButton(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Icon(
            imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(id = R.string.app_name)
        )
    }
}

@Composable
fun LessonDescription(modifier: Modifier = Modifier, lessonDescription: Int){
    Text(
        modifier = modifier,
        text = stringResource(id = lessonDescription),
        fontWeight = FontWeight.Light,
        fontFamily = FontFamily.Serif,
        fontSize = 18.sp
    )
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
        BasicAlgebraList()
    }
}