package net.swift.android_paging_3_sample.service.api

import com.squareup.moshi.Json

class GithubResponse(
    @Json(name = "total") var total: Int = 0,
    @Json(name = "items") var items: List<GithubDataResponse> = listOf()
)