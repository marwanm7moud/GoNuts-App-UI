package com.example.godonut.screens.onBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.godonut.R
import com.example.godonut.composables.DonutImage
import com.example.godonut.ui.theme.Background
import com.example.godonut.ui.theme.GoDonutTheme

@Composable

fun OnBoardingDonutBackground() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (pinkDonut , blueDonut , mainImage , smallDonut , lastDonut) = createRefs()
        val mainImageGuideline = createGuidelineFromTop(0.1f)
        val smallDonutGuideline = createGuidelineFromTop(0.36f)
        val lastDonutGuideline = createGuidelineFromTop(0.44f)

        DonutImage(
            height = 155,
            width = 210,
            drawable = R.drawable.pink_donut,
            modifier = Modifier
                .padding(end = 33.dp , top = 40.dp)
                .constrainAs(pinkDonut) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )
        DonutImage(
            height = 167,
            width = 167,
            drawable = R.drawable.blue_donut,
            modifier = Modifier
                .wrapContentSize(unbounded = true)
                .offset(x = (-19).dp, y= (-39).dp)
                .constrainAs(blueDonut) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        DonutImage(
            height = 340,
            width = 630,
            drawable = R.drawable.onbording_main_image,
            modifier = Modifier
                .wrapContentSize(unbounded = true)
                .constrainAs(mainImage) {
                    top.linkTo(mainImageGuideline)
                }
                .rotate(17f)
        )
        DonutImage(
            height = 69,
            width = 94,
            drawable = R.drawable.onbording_small_donut,
            modifier = Modifier
                .constrainAs(smallDonut) {
                    top.linkTo(smallDonutGuideline)
                }
        )
        DonutImage(
            height = 165,
            width = 209,
            drawable = R.drawable.onbording_last_donut,
            modifier = Modifier
                .wrapContentSize(unbounded = true)
                .offset(x = (91).dp)
                .constrainAs(lastDonut) {
                    top.linkTo(lastDonutGuideline)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingDonutBackgroundPreview() {
    GoDonutTheme {
        OnBoardingDonutBackground()
    }
}