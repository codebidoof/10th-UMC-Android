package kr.co.umc.nike.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.home.component.BannerImage
import kr.co.umc.nike.presentation.home.component.TopTitle

@Composable
fun HomeScreen()  {

    LazyColumn {
        item {
            TopTitle(
                title = "Discover",
                today = "9월 4일 목요일"
            )
        }

        item {
            BannerImage(R.drawable.img_banner)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}