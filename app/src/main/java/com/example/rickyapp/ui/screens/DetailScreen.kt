package com.example.rickyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickyapp.HomeViewModel
import com.example.rickyapp.R
import com.example.rickyapp.model.Result
import com.example.rickyapp.ui.components.ItemKeyAndValue
import com.example.rickyapp.ui.theme.CardBg
import com.example.rickyapp.ui.theme.PillsTextGrey
import com.example.rickyapp.ui.theme.SurfaceBg
import com.example.rickyapp.ui.theme.SurfaceBlack
import com.example.rickyapp.ui.theme.TopBarColor
import com.example.rickyapp.ui.theme.White
import com.example.rickyapp.ui.utils.BoldStyle
import com.example.rickyapp.ui.utils.Dimens
import com.example.rickyapp.ui.utils.ImageSpec
import com.example.rickyapp.ui.utils.MediumStyle
import com.example.rickyapp.ui.utils.VerticalSpace

@Composable
fun DetailScreen(
    navController: NavController,
    homeViewModel: HomeViewModel?,
) {
    val itemDetails = homeViewModel?.sharedResult?.value
    val scrollState = rememberScrollState()
    itemDetails?.let { item ->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(CardBg),
        ) {
            Column(
                modifier =
                    Modifier
                        .verticalScroll(scrollState),
            ) {
                DetailHeader(item, navController)
                DetailContentCard(item)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(Dimens.dimen12),
                colors = ButtonDefaults.buttonColors(TopBarColor),
            ) {
                Text(
                    text = "Save",
                    style = 16.MediumStyle,
                    color = White,
                )
            }
        }
    }
}

@Composable
private fun DetailContentCard(item: Result) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(Dimens.elevation),
        colors = CardDefaults.cardColors(CardBg),
        shape = RoundedCornerShape(Dimens.dimen0),
    ) {
        Column(
            modifier = Modifier.padding(Dimens.dimen16),
        ) {
            24.VerticalSpace()
            Text(
                text = item.name ?: "Unknown",
                color = SurfaceBlack,
                style = 21.BoldStyle,
                lineHeight = 18.sp,
                modifier = Modifier.padding(bottom = Dimens.dimen8),
            )
            20.VerticalSpace()
            ItemKeyAndValue(key = "Species", value = item.species ?: "Unknown")
            ItemKeyAndValue(key = "Gender", value = item.gender ?: "Unknown")
            ItemKeyAndValue(key = "Status", value = item.status ?: "Unknown")
            ItemKeyAndValue(key = "Type", value = item.type ?: "Unknown")
            ItemKeyAndValue(key = "Origin", value = item.origin?.name ?: "Unknown")
            ItemKeyAndValue(key = "Location", value = item.location?.name ?: "Unknown")
            ItemKeyAndValue(key = "Total Episode", value = item.episode?.size.toString())
            62.VerticalSpace()
        }
    }
}

@Composable
private fun DetailHeader(
    item: Result,
    navController: NavController,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(Dimens.detailImageHeight),
    ) {
        ImageSpec(
            imgUrl = item.image ?: "",
            contentDescription = "character-details",
            modifier = Modifier.fillMaxSize(),
            scale = ContentScale.FillBounds,
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "back-arrow",
            modifier =
                Modifier
                    .padding(top = Dimens.dimen32, start = Dimens.dimen12)
                    .background(SurfaceBg, CircleShape)
                    .size(Dimens.dimen30)
                    .clickable(onClick = { navController.popBackStack() }),
            tint = PillsTextGrey,
        )
    }
}