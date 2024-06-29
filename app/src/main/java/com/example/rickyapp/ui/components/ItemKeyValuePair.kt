package com.example.rickyapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickyapp.ui.theme.Divider
import com.example.rickyapp.ui.theme.PrimaryGrey5
import com.example.rickyapp.ui.utils.BoldStyle
import com.example.rickyapp.ui.utils.MediumStyle
import com.example.rickyapp.ui.utils.VerticalSpace

@Composable
fun ItemKeyAndValue(
    key: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(Modifier.padding(top = 26.dp)) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = key,
                style = 16.MediumStyle,
                color = PrimaryGrey5,
            )
            Text(
                text = value,
                style = 16.BoldStyle,
                color = PrimaryGrey5,
            )
        }
        16.VerticalSpace()
        HorizontalDivider(color = Divider)
    }
}