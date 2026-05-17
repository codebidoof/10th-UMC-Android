package kr.co.umc.nike.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.Black
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun GoodInfo(
    name: String,
    description: String,
    colorNum: String,
    price: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 14.sp,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = name,
            fontSize = textSize,
            color = Black,
            lineHeight = (textSize.value * 1.2).sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = description,
            fontSize = textSize,
            color = CustomGray,
            lineHeight = (textSize.value * 1.2).sp,
        )

        Text(
            text = colorNum,
            fontSize = textSize,
            color = CustomGray
        )

        Text(
            text = price,
            fontSize = textSize,
            color = Black,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GoodInfoPreview() {
    NikeTheme {
        GoodInfo(
            name = "Nike Everyday Plus Cushioned",
            description = "Training Ankle Socks (6 Pairs)",
            colorNum = "1 Color",
            price = "US$185"
        )
    }
}