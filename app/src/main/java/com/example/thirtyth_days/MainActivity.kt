package com.example.thirtyth_days

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtyth_days.data.Thirtydays
import com.example.thirtyth_days.data.days
import com.example.thirtyth_days.ui.theme.Thirtyth_daysTheme
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Thirtyth_daysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    App30()
                }
            }
        }
    }
}

@Composable
fun App30() {
    Scaffold(
        topBar = {
            DaysTopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(days.size) { index ->
                daysCard(day = days[index])
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun daysCard(day: Thirtydays) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .padding(8.dp)

        .width(500.dp)) {
        Column {


        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = day.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .size(150.dp)
                    , contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.width(180.dp)) {
                Text(
                    text = stringResource(id = day.title),
                    modifier = Modifier.padding(start = 50.dp),
                    style = MaterialTheme.typography.displayMedium

                )
            }

        DaysItemButton(
            expanded = expanded,
            onClick = { expanded = !expanded}
        )
    }
            if (expanded) {
            Receipts(day = day, modifier =Modifier )
    }}}}


@Preview
@Composable
fun DaysPrewiev() {
    Thirtyth_daysTheme {
        App30()
    }
}
@Composable
private fun DaysItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {

            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }


    }
@Composable
fun Receipts(
    day: Thirtydays,
    modifier: Modifier


){
    Row(modifier = Modifier.padding(16.dp), horizontalArrangement =  Arrangement.Center) {
        Column {
            Text(text= stringResource(id = day.receipt))
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(text= stringResource(id = day.gram))
        }
    }

}





