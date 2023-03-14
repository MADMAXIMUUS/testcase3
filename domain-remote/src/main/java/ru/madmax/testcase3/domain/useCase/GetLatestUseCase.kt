package ru.madmax.testcase3.domain.useCase

import kotlinx.coroutines.flow.Flow
import ru.madmax.testcase3.domain.model.HomeItems
import ru.madmax.testcase3.domain.repository.HomeRepository

class GetLatestUseCase(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(): Flow<HomeItems>{
        return homeRepository.getLatest()
    }
}