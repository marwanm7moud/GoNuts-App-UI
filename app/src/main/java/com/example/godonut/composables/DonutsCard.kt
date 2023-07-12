package com.example.godonut.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.godonut.R
import com.example.godonut.ui.theme.GoDonutTheme
import com.example.godonut.ui.theme.Primary
import com.example.godonut.ui.theme.Text60


@Composable
fun DonutsCard(navigateToDetails: () -> Unit) {
    ConstraintLayout() {
        val (image, background, title, price) = createRefs()
        val centerImage = createGuidelineFromTop(0.3f)

        Surface(
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp
            ),
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier
                .clickable {
                    navigateToDetails.invoke()
                }
                .constrainAs(background) {
                    top.linkTo(centerImage)
                }
                .height(120.dp)
                .width(140.dp)
        ) {}
        DonutImage(
            height = 105,
            width = 105,
            drawable = R.drawable.chocolate_cherry,
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "Chocolate Cherry",
            color = Text60,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(image.bottom)
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                }
        )
        Text(
            text = "\$22",
            color = Primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(price) {
                    top.linkTo(title.bottom)
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                }
        )

    }
}

@Preview()
@Composable
fun DonutsCardPreview() {
    GoDonutTheme {
        DonutsCard(){}
    }
}