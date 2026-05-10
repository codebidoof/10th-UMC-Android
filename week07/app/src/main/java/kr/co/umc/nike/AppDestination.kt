package kr.co.umc.nike

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable


/**
 * 애플리케이션 내의 최상위 탐색 대상(Navigation Destination)을 정의하는 인터페이스입니다.
 *
 * 홈, 구매, 위시리스트, 장바구니, 프로필 등 앱의 주요 화면 이동을 위한
 * 타입 안정성(Type-safety) 있는 경로 정의를 위해 사용됩니다.
 */
sealed interface AppDestination {
    /**
     * BottomBar에 들어갈 아이콘 Drawable 리소스와 이름입니다.
     */
    @get:DrawableRes val icon: Int
    val label: String


    @Serializable
    data object Home : AppDestination {
        override val icon = R.drawable.house_simple
        override val label = "홈"
    }

    @Serializable
    data object Buy : AppDestination {
        override val icon = R.drawable.list_magnifying_glass
        override val label = "구매"
    }

    @Serializable
    data object WishList : AppDestination {
        override val icon = R.drawable.heart_straight
        override val label = "위시리스트"
    }

    @Serializable
    data object Bag : AppDestination {
        override val icon = R.drawable.bag_simple
        override val label = "가방"
    }

    @Serializable
    data object Profile : AppDestination {
        override val icon = R.drawable.user
        override val label = "프로필"
    }
}
