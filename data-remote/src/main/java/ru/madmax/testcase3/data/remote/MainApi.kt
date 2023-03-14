package ru.madmax.testcase3.data.remote

import retrofit2.http.GET
import ru.madmax.testcase3.data.remote.model.FlashResponse
import ru.madmax.testcase3.data.remote.model.LastResponse

interface MainApi {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): LastResponse

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlash(): FlashResponse
}