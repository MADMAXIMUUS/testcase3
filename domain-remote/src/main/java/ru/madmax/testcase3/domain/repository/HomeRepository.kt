package ru.madmax.testcase3.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.madmax.testcase3.domain.model.HomeItems

interface HomeRepository {

    suspend fun getLatest(): Flow<HomeItems>
}