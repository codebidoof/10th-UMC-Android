package kr.co.umc.nike.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.co.umc.nike.R
import kr.co.umc.nike.navigation.model.BottomBarItem
import kr.co.umc.nike.navigation.route.AppGraph
import kr.co.umc.nike.navigation.route.MainDestination
import kr.co.umc.nike.navigation.util.mainGraph
import kr.co.umc.nike.navigation.util.toMainDestination
import kr.co.umc.nike.ui.theme.NikeTheme

/**
 * 나이키 애플리케이션의 최상위(루트) 컴포저블 함수입니다.
 *
 * 이 함수는 다음과 같은 앱의 주요 내비게이션 구조를 설정합니다:
 * - 전체적인 레이아웃을 관리하는 [Scaffold]를 구성합니다.
 * - 주요 내비게이션 목적지를 표시하는 하단 바([BottomBar])를 구현합니다.
 * - 홈, 구매, 위시리스트, 장바구니, 프로필 등 각 화면 간의 라우팅을 처리하는 [NavHost]를 관리합니다.
 */
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // 현재 네비게이션 상태를 관찰하는 state 변수
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 현재 백스택 최상단의 Destination
    val currentDestination = navBackStackEntry?.destination.toMainDestination()

    // 바텀 내비게이션 아이템 리스트
    val bottomBarItems = listOf(
        BottomBarItem(MainDestination.Home, R.drawable.house_simple, "홈"),
        BottomBarItem(MainDestination.Buy, R.drawable.list_magnifying_glass, "구매"),
        BottomBarItem(MainDestination.WishList, R.drawable.heart_straight, "위시리스트"),
        BottomBarItem(MainDestination.Bag, R.drawable.bag_simple, "장바구니"),
        BottomBarItem(MainDestination.Profile, R.drawable.user, "프로필")
    )

    Scaffold(
        bottomBar = {
            BottomBar(
                items = bottomBarItems,
                currentDestination = currentDestination,
                onNavigate = { destination ->

                    // BottomBar 탭 전환 시 각 destination의 상태를 유지
                    navController.navigate(destination) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppGraph.MainGraph,
            modifier = Modifier.padding(innerPadding),

            // 전환 속도 설정
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
            popEnterTransition = { fadeIn() },
            popExitTransition = { fadeOut() }

        ) {
            mainGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NikeAppPreview() {
    NikeTheme {
        MainScreen()
    }
}
