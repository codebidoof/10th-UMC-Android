package kr.co.umc.nike.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.AppDestination
import kr.co.umc.nike.ui.theme.NikeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    destinations: List<AppDestination>, // 탭 목록
    currentDestination: AppDestination?, // 현재 선택된 탭
    onNavigate: (AppDestination) -> Unit // 클릭 이벤트 콜백
) {
    CompositionLocalProvider(
        LocalRippleConfiguration provides null
    ) {
        NavigationBar {
            destinations.forEach { destination ->
                NavigationBarItem(
                    selected = destination == currentDestination,
                    onClick = { onNavigate(destination) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    icon = {
                        Icon(
                            painter = painterResource(id = destination.icon),
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    val destinations = listOf(
        AppDestination.Home,
        AppDestination.Buy,
        AppDestination.WishList,
        AppDestination.Bag,
        AppDestination.Profile
    )
    NikeTheme {
        BottomBar(
            destinations = destinations,
            currentDestination = AppDestination.Home,
            onNavigate = {}
        )
    }
}







