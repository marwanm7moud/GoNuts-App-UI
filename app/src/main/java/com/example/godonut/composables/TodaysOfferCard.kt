package com.example.godonut.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.godonut.R
import com.example.godonut.ui.theme.GoDonutTheme
import com.example.godonut.ui.theme.Primary
import com.example.godonut.ui.theme.Text100
import com.example.godonut.ui.theme.Text60
import com.example.godonut.ui.theme.TodayCardColor

@Composable
fun TodaysOfferCard(navigateToDetails: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier.clickable {
            navigateToDetails.invoke()
        }
    ) {
        val (background, favorate, donut, title, subtitle, price) = createRefs()
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = TodayCardColor,
            shadowElevation = 4.dp,
            modifier = Modifier
                .constrainAs(background) {}
                .height(325.dp)
                .width(193.dp)
        ) {}
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = CircleShape,
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp)
                .size(35.dp)
                .constrainAs(favorate) {
                    top.linkTo(background.top)
                    start.linkTo(background.start)
                },
            contentPadding = PaddingValues(0.dp),
            onClick = {},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                tint = Primary,
                contentDescription = "",
            )
        }
        DonutImage(
            height = 138,
            width = 138,
            drawable = R.drawable.card_donut,
            modifier = Modifier
                .constrainAs(donut) {
                    top.linkTo(favorate.bottom)
                    end.linkTo(background.end)
                }
                .offset(x = (40).dp)
        )
        Text(
            text = "Chocolate Glaze",
            color = Text100,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 20.dp)
                .constrainAs(title) {
                    top.linkTo(donut.bottom)
                    start.linkTo(background.start)
                }
        )
        Text(
            text = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
            color = Text60,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 20.dp, top = 8.dp)
                .width(170.dp)
                .constrainAs(subtitle) {
                    top.linkTo(title.bottom)
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                }
        )
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(end = 15.dp, bottom = 15.dp)
                .constrainAs(price) {
                    bottom.linkTo(background.bottom)
                    end.linkTo(background.end)
                }
        ) {
            Text(
                text = "\$20",
                color = Text60,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                modifier = Modifier
            )
            Text(
                text = "\$16",
                color = Text100,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TodaysOfferCardPreview() {
    GoDonutTheme {
        TodaysOfferCard(){}
    }
}