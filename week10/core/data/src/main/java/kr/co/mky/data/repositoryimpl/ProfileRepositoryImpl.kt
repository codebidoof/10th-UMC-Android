package kr.co.mky.data.repositoryimpl

import kr.co.mky.data.mapper.DtoMapper.toProfile
import kr.co.mky.domain.repository.ProfileRepository
import kr.co.mky.domain.entity.Profile
import kr.co.mky.network.api.ProfileApiService
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApiService: ProfileApiService
): ProfileRepository {
    override suspend fun getFollowingUsers(): Result<List<Profile>> {
        return try {
            profileApiService.getFollowingUsers()
                .toResult { userList -> // userList의 원소를 Profile로 변환한 리스트 반환
                    userList.map { it.toProfile() }
                }
        } catch(e: Exception) {
            Result.failure(e)
        }
    }
}