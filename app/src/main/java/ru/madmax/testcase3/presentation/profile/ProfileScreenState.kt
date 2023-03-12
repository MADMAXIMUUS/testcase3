package ru.madmax.testcase3.presentation.profile

import android.net.Uri

data class ProfileScreenState(
    val id: Int = 0,
    val name: String = "",
    val profilePhoto: Uri = Uri.EMPTY,
    val cash: Int = 0
)
