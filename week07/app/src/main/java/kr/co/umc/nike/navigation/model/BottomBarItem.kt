package kr.co.umc.nike.navigation.model

import kr.co.umc.nike.navigation.route.MainDestination

/**
 * 애플리케이션 하단 네비게이션 바의 개별 네비게이션 항목을 나타냅니다.
 *
 * 이 데이터 클래스는 하단 바의 탭을 렌더링하고 해당 목적지로의 네비게이션을
 * 처리하는 데 필요한 메타데이터를 정의하는 데 사용됩니다.
 */
data class BottomBarItem(
    val destination: MainDestination,
    val icon: Int,
    val label: String
)