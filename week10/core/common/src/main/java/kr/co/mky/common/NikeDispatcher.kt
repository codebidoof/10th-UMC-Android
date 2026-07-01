package kr.co.mky.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val nikeDispatcher: NikeDispatchers)

enum class NikeDispatchers {
    Default,
    IO,
}