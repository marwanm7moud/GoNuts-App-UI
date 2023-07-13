package com.example.godonut.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.godonut.GoNutRoutes
import com.example.godonut.R
import com.example.godonut.composables.CustomButton
import com.example.godonut.screens.onBoarding.OnBoardingDonutBackground
import com.example.godonut.ui.theme.Background
import com.example.godonut.ui.theme.GoDonutTheme
import com.example.godonut.ui.theme.Primary
import com.example.godonut.ui.theme.Text100
import com.example.godonut.ui.theme.Text60

@Composable
fun DetailsScreen(navController: NavHostController) {
    DetailsContent() {
        navController.navigate(GoNutRoutes.HomeScreen.route)
    }
}

@Composable
fun DetailsContent(navController: () -> Unit) {

    var count by remember {
        mutableStateOf(1) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        val (card, addToFavourite, backButton, donutImage) = createRefs()
        val cardGuideline = createGuidelineFromTop(0.5f)

        Image(
            painter = painterResource(id = R.drawable.strawberry_wheel),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .wrapContentWidth(unbounded = false)
                .fillMaxWidth()
                .constrainAs(donutImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(card.top)
                },
            contentDescription = ""
        )

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .size(30.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentPadding = PaddingValues(0.dp),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.back_button),
                tint = Primary,
                contentDescription = "",
            )
        }

        Card(
            shape = RoundedCornerShape(40.dp, 40.dp),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(card) {
                    top.linkTo(cardGuideline)
                },
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Text(
                text = stringResource(id = R.string.strawberry_wheel),
                color = Primary,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 40.dp, top = 35.dp)
            )
            Text(
                text = "About Gonut",
                color = Text100,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 40.dp, top = 33.dp)
            )
            Text(
                text = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                color = Text60,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 40.dp, top = 16.dp, end = 40.dp)
            )
            Text(
                text = "Quantity",
                color = Text100,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 40.dp, top = 16.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(start = 35.dp , top = 12.dp)
            ) {
                Button(
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .size(45.dp),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        if(count>=1)
                        count--
                    }
                ) {
                    Text(
                        text = "-",
                        color = Text100,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(15.dp)),
                ) {
                    Text(
                        text = count.toString(),
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }

                Button(
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .size(45.dp),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        count++
                    }
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = "£16",
                    color = Text100,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
                CustomButton(
                    onClick = { /*TODO*/ },
                    text = "Add to Cart" ,
                    containerColor = Primary ,
                    textColor = Color.White)
            }


        }
        Button(
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(end = 30.dp)
                .offset(y = (-22).dp)
                .size(45.dp)
                .constrainAs(addToFavourite) {
                    top.linkTo(card.top)
                    end.linkTo(card.end)
                },
            contentPadding = PaddingValues(0.dp),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_to_favourite),
                tint = Primary,
                contentDescription = "",
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    GoDonutTheme {
        val navController = rememberNavController()
        DetailsScreen(navController)
    }
}