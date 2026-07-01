package kr.co.mky.network.api


import kr.co.mky.network.model.response.ResReqResponse
import kr.co.mky.network.model.response.User
import retrofit2.http.GET

interface ProfileApiService {
    @GET("users")
    suspend fun getFollowingUsers(): ResReqResponse<List<User>>
}