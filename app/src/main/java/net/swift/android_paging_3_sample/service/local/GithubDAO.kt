package net.swift.android_paging_3_sample.service.local

import androidx.room.Query

interface GithubDAO {
    @Query("SELECT * FROM table_github_repo")
    fun getSearchResults():List<GithubEntity>
}