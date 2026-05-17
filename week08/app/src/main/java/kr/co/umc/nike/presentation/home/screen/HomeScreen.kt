package kr.co.umc.nike.presentation.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.home.component.BannerImage
import kr.co.umc.nike.presentation.home.component.NewGoodCard
import kr.co.umc.nike.presentation.home.component.NewProductBar
import kr.co.umc.nike.presentation.home.component.TopTitle
import kr.co.umc.nike.presentation.home.model.NewGood
import kr.co.umc.nike.presentation.home.viewmodel.HomeViewModel
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
)  {
    val newGoodsState by viewModel.newGoodsState
        .collectAsStateWithLifecycle()

    HomeContent(newGoodsState = newGoodsState)
}

@Composable
private fun HomeContent(
    newGoodsState: UiState<List<NewGood>>
) {
    LazyColumn {

        item {
            TopTitle(
                title = "Discover",
                today = "9월 4일 목요일",
                modifier = Modifier.padding(
                    horizontal = 40.dp,
                    vertical = 50.dp
                )
            )
        }

        item {
            BannerImage(
                imageRes = R.drawable.img_banner,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Spacer(
                modifier = Modifier.height(40.dp)
            )
        }

        item {
            NewProductBar(
                eng = "What’s new",
                kor = "나이키 최신 상품",
                modifier = Modifier.padding(
                    horizontal = 42.dp
                )
            )
        }

        item {
            when (newGoodsState) {
                is UiState.Idle -> Unit

                is UiState.Loading -> {
                    /* 로딩 컴포저블 호출 */
                }

                is UiState.Success -> {
                    LazyRow(
                        contentPadding = PaddingValues(
                            vertical = 22.dp,
                            horizontal = 40.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(
                            newGoodsState.data,
                            key = { good -> good.id }
                        ) { good ->
                            NewGoodCard(good)
                        }
                    }
                }

                is UiState.Error -> {
                    /* 에러 처리 가능 */
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NikeTheme {
        HomeContent(
            newGoodsState = UiState.Idle
        )
    }
}
