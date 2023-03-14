package ru.madmax.testcase3.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.madmax.testcase3.R
import ru.madmax.testcase3.domain.useCase.GetLatestUseCase
import ru.madmax.testcase3.presentation.home.itemStates.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLatestUseCase: GetLatestUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getLatestUseCase().collectLatest { item ->
                _uiState.update { currentState ->
                    currentState.copy(
                        parentRawItems = listOf(
                            ParentRawItem(
                                title = "",
                                isTitleNeeded = false,
                                items = listOf(
                                    CategoryItem(
                                        id = 0,
                                        title = "Phones",
                                        icon = R.drawable.ic_phone
                                    ),
                                    CategoryItem(
                                        id = 1,
                                        title = "Headphones",
                                        icon = R.drawable.ic_headphone
                                    ),
                                    CategoryItem(
                                        id = 2,
                                        title = "Games",
                                        icon = R.drawable.ic_gamepad
                                    ),
                                    CategoryItem(
                                        id = 3,
                                        title = "Cars",
                                        icon = R.drawable.ic_car
                                    ),
                                    CategoryItem(
                                        id = 4,
                                        title = "Furniture",
                                        icon = R.drawable.ic_bed
                                    ),
                                    CategoryItem(
                                        id = 5,
                                        title = "Kids",
                                        icon = R.drawable.ic_kids
                                    ),
                                )
                            ),
                            ParentRawItem(
                                title = "Latest",
                                isTitleNeeded = true,
                                items = item.latest.map {
                                    LatestItem(
                                        category = it.category,
                                        cost = it.price,
                                        title = it.name,
                                        image = it.image_url
                                    )
                                }
                            ),
                            ParentRawItem(
                                title = "Flash sale",
                                isTitleNeeded = true,
                                items = item.flash.map {
                                    FlashItem(
                                        title = it.name,
                                        cost = it.price,
                                        category = it.category,
                                        discount = it.discount,
                                        image = it.image_url
                                    )
                                }
                            ),
                            ParentRawItem(
                                title = "Brands",
                                isTitleNeeded = true,
                                items = listOf(
                                    BrandsItem(
                                        id = 0,
                                        title = "Samsung Galaxy S9",
                                        category = "Phones",
                                        amount = 80000,
                                        image = R.drawable.brand_1
                                    ),
                                    BrandsItem(
                                        id = 1,
                                        title = "Play Station 4 console",
                                        category = "Games",
                                        amount = 100000,
                                        image = R.drawable.brand_2
                                    ),
                                    BrandsItem(
                                        id = 2,
                                        title = "Play Station 4 console",
                                        category = "Phones",
                                        amount = 100000,
                                        image = R.drawable.brand_3
                                    ),
                                )
                            )
                        )
                    )
                }
            }
        }
    }

}