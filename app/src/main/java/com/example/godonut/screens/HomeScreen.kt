package com.example.godonut.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.godonut.R
import com.example.godonut.composables.DonutsCard
import com.example.godonut.composables.TodaysOfferCard
import com.example.godonut.ui.theme.Background
import com.example.godonut.ui.theme.GoDonutTheme
import com.example.godonut.ui.theme.Primary
import com.example.godonut.ui.theme.Text100
import com.example.godonut.ui.theme.Text60

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
                    .padding(start = 38.dp, top = 81.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.letsGonuts),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Primary
                    )
                    Text(
                        text = stringResource(id = R.string.subLetsGonuts),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Text60
                    )
                }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Background),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.size(45.dp),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        tint = Primary,
                        contentDescription = "",
                    )
                }
            }
        }
        item {
            Text(
                text = stringResource(id = R.string.todayOffers),
                color = Text100,
                modifier = Modifier.padding(start = 38.dp, top = 45.dp)
            )
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 38.dp),
                modifier = Modifier.padding(top = 25.dp),
                horizontalArrangement = Arrangement.spacedBy(45.dp)
            ) {
                items(5) {
                    TodaysOfferCard()
                }
            }
        }
        item {
            Text(
                text = stringResource(id = R.string.donuts),
                color = Text100,
                modifier = Modifier.padding(start = 38.dp, top = 45.dp)
            )
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 38.dp),
                modifier = Modifier.padding(top = 12.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(5) {
                    DonutsCard()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    GoDonutTheme {
        HomeScreen()
    }
}