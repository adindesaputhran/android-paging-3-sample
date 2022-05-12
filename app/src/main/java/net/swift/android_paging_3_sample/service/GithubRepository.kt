package net.swift.android_paging_3_sample.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.swift.android_paging_3_sample.service.api.GithubService
import net.swift.android_paging_3_sample.service.api.RetrofitBuilder
import net.swift.android_paging_3_sample.service.models.GithubResult
import kotlin.streams.toList

class GithubRepository() {
    private val retrofitBuilder = RetrofitBuilder()
    suspend fun getSearchResult(page: Int, size: Int): Flow<List<GithubResult>> {
        return flow {
            emit(
                retrofitBuilder.getService(GithubService::class.java)
                    .searchRepos(IN_QUALIFIER, page, size).items.map {
                        GithubResult(
                            it.id,
                            it.name,
                            it.fullName,
                            it.description
                        )
                    }
                    .stream().toList())
        }


    }

    companion object {
        private const val IN_QUALIFIER = "in:name,description"
    }
}