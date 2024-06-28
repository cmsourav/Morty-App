package com.example.rickyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickyapp.model.Result
import com.example.rickyapp.ui.theme.PillsTextGrey
import com.example.rickyapp.ui.theme.PrimaryGrey5
import com.example.rickyapp.ui.theme.White
import com.example.rickyapp.ui.utils.Dimens
import com.example.rickyapp.ui.utils.ImageSpec
import com.example.rickyapp.ui.utils.MediumStyle
import com.example.rickyapp.ui.utils.NormalStyle
import com.example.rickyapp.ui.utils.VerticalSpace

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    data: List<Result>,
    onClick: (Int) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        itemsIndexed(items = data) { index, item ->
            val id = item.id ?: 0
            CharacterCardItem(
                id = id,
                image = item.image ?: "",
                name = item.name ?: "Unknown",
                status = item.status ?: "Unknown",
                onClick = { onClick(id) },
            )
        }
    }
}

@Composable
fun CharacterCardItem(
    modifier: Modifier = Modifier,
    id: Int,
    image: String,
    name: String,
    status: String,
    onClick: (Int) -> Unit,
) {
    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .background(White)
                .padding(Dimens.dimen12)
                .clickable(onClick = { onClick(id) }),
        shape = RoundedCornerShape(Dimens.dimen0),
    ) {
        Column {
            Box(
                modifier =
                    Modifier
                        .height(Dimens.imageHeight)
                        .fillMaxWidth(),
            ) {
                ImageSpec(
                    imgUrl = image,
                    contentDescription = "Character Image",
                    modifier = modifier.fillMaxWidth(),
                )
            }
            Column(modifier.padding(horizontal = Dimens.dimen2, vertical = Dimens.dimen12)) {
                Text(
                    text = name,
                    style = 16.MediumStyle,
                    color = PrimaryGrey5,
                )
                8.VerticalSpace()
                Text(
                    text = "Status: $status",
                    style = 12.NormalStyle,
                    color = PillsTextGrey,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCharacterCard() {
    CharacterCardItem(
        id = 1,
        image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
        name = "Toxic Rick",
        status = "Dead",
        onClick = {},
    )
}