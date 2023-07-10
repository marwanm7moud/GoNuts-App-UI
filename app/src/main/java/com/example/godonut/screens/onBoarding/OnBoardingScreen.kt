package com.example.godonut.screens.onBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.godonut.ui.theme.Background
import com.example.godonut.ui.theme.GoDonutTheme
import com.example.godonut.ui.theme.Primary

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    OnBoardingContent(){
        navController.navigate(GoNutRoutes.HomeScreen.route)
    }
}

@Composable
fun OnBoardingContent(navigate: ()->Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        val (title, subTitle, getStartedButton) = createRefs()
        val titleGuideline = createGuidelineFromTop(0.48f)
        OnBoardingDonutBackground()

        Text(
            text = stringResource(id = R.string.title),
            color = Primary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(titleGuideline)
                }
                .padding(start = 40.dp, bottom = 19.dp)
        )
        Text(
            text = stringResource(id = R.string.sub_title),
            color = Primary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .constrainAs(subTitle) {
                    top.linkTo(title.bottom)
                }
        )
        Button(
            onClick = navigate ,
            colors=ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(bottom = 30.dp)
                .height(55.dp)
                .constrainAs(getStartedButton){
                    bottom.linkTo(parent.bottom)
                }

        ) {
            Text(
                text = "Get Started",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
            )
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    GoDonutTheme {
        val navController = rememberNavController()
        OnBoardingScreen(navController)
    }
}