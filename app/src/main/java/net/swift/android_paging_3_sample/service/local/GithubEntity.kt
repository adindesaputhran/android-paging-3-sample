package net.swift.android_paging_3_sample.service.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("table_github_repo")
class GithubEntity(
    @PrimaryKey
    var id: Long = -1,
    var name: String = "",
    var fullName: String = "",
    var description: String = "",
    var stars: Int = 0
)