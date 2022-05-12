package net.swift.android_paging_3_sample.service.api

import com.squareup.moshi.Json

class GithubDataResponse(
    @Json(name = "id") var id: Long = -1,
    @Json(name = "name") var name: String = "",
    @Json(name = "full_name") var fullName: String = "",
    @Json(name = "description") var description: String = "",
    @Json(name = "stargazers_count") var stars: Int = 0
)