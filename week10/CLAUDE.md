# 프로젝트 개요
Nike 쇼핑몰 앱의 Compose 마이그레이션 프로젝트입니다.
기존 View 기반 코드를 Jetpack Compose로 전환하는 것이 주 목표입니다.

# 아키텍처
Clean Architecture를 따르며 레이어는 다음과 같이 구성됩니다.
- **data**: Repository 구현체, API/DB 데이터소스, DTO, Mapper
- **domain**: UseCase, Repository 인터페이스, 도메인 모델
- **presentation**: ViewModel, Composable UI, UI State

의존성 방향: presentation → domain ← data

# 기술 스택
- UI: Jetpack Compose (Material3)
- 상태 관리: ViewModel + StateFlow + collectAsStateWithLifecycle
- DI: Hilt
- 네트워크: Retrofit2 + OkHttp3
- 이미지: Coil3
- 로컬 DB: Room
- 비동기: Coroutines + Flow

# 코드 컨벤션
- ViewModel의 UI 상태는 반드시 sealed class UiState로 관리 (Loading/Success/Error)
- Composable 함수명은 파스칼케이스, 파일명과 일치시킬 것
- UseCase는 단일 책임 원칙 — operator fun invoke() 하나만 가질 것
- Repository 인터페이스는 domain 레이어에, 구현체는 data 레이어에 위치
- 모든 네트워크 호출은 try-catch로 감싸고 Result<T>로 반환

# 주의사항
- local.properties에 API 키 및 Keystore 정보가 있으므로 Git에 올리지 말 것
- 미션 브랜치는 feature/week{N}-{기능명} 형식으로 생성
- 새 화면 추가 시 반드시 Navigation 그래프에 등록할 것