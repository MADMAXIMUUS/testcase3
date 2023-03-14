package ru.madmax.testcase3.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.madmax.testcase3.data.remote.MainApi
import ru.madmax.testcase3.domain.model.FlashSale
import ru.madmax.testcase3.domain.model.HomeItems
import ru.madmax.testcase3.domain.model.Latest
import ru.madmax.testcase3.domain.repository.HomeRepository

class HomeRepositoryImpl(private val mainApi: MainApi) : HomeRepository {

    override suspend fun getLatest(): Flow<HomeItems> = flow {
        val latest = mainApi.getLatest()
        val flash = mainApi.getFlash()
        if (latest.latest.isNotEmpty() || flash.flash_sale.isNotEmpty()) {
            emit(HomeItems(
                latest.latest.map {
                    Latest(it.category, it.image_url, it.name, it.price)
                },
                flash.flash_sale.map {
                    FlashSale(it.category, it.discount, it.image_url, it.name, it.price)
                }
            ))
        } else {
            emit(HomeItems(emptyList(), emptyList()))
        }
    }
}