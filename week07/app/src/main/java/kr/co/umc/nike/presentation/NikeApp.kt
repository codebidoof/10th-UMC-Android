package kr.co.umc.nike.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.co.umc.nike.AppDestination
import kr.co.umc.nike.presentation.bag.screen.BagScreen
import kr.co.umc.nike.presentation.buy.screen.BuyScreen
import kr.co.umc.nike.presentation.home.screen.HomeScreen
import kr.co.umc.nike.presentation.profile.screen.ProfileScreen
import kr.co.umc.nike.presentation.wish.screen.WishScreen
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
fun NikeApp() {
    val navController = rememberNavController()

    // 바텀 내비게이션 목적지 리스트
    val bottomDestinations = listOf(
        AppDestination.Home,
        AppDestination.Buy,
        AppDestination.WishList,
        AppDestination.Bag,
        AppDestination.Profile
    )

    // 현재 네비게이션 상태를 관찰하는 state 변수
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 목적지 리스트를 순회하며 현재 화면을 찾음
    val currentDestination = bottomDestinations.find { destination ->
        navBackStackEntry
            ?.destination
            ?.hasRoute(destination::class) == true
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                destinations = bottomDestinations,
                currentDestination = currentDestination,
                onNavigate = { destination ->
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
            startDestination = AppDestination.Home,
            modifier = Modifier.padding(innerPadding),

            // 전환 속도를 더 빠르게 설정
            enterTransition = {
                fadeIn(animationSpec = tween(200))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(200))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(200))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(200))
            }

        ) {
            composable<AppDestination.Home>{
                HomeScreen()
            }

            composable<AppDestination.Buy>{
                BuyScreen()
            }

            composable<AppDestination.WishList>{
                WishScreen()
            }

            composable<AppDestination.Bag>{
                BagScreen()
            }

            composable<AppDestination.Profile>{
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NikeAppPreview() {
    NikeTheme {
        NikeApp()
    }
}
