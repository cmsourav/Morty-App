package com.example.rickyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickyapp.model.Result
import com.example.rickyapp.ui.theme.CardBg
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
    data: List<Result>,
    onClick: (Result) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = Dimens.dimen12)
    ) {
        itemsIndexed(items = data) { _, item ->
            val id = item.id ?: 0
            CharacterCardItem(
                id = id,
                image = item.image ?: "",
                name = item.name ?: "Unknown",
                status = item.status ?: "Unknown",
                onClick = { onClick(item) },
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
                .heightIn(250.dp)
                .padding(Dimens.dimen8)
                .clickable(onClick = { onClick(id) }),
        shape = RoundedCornerShape(Dimens.dimen0),
        colors = CardDefaults.cardColors(CardBg),
        elevation = CardDefaults.elevatedCardElevation(Dimens.elevation),
    ) {
        Column(modifier = Modifier.padding(Dimens.dimen4)) {
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
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
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