package kr.co.mky.domain.repository

import kr.co.mky.domain.entity.Profile

interface ProfileRepository {
    suspend fun getFollowingUsers(): Result<List<Profile>>
}
