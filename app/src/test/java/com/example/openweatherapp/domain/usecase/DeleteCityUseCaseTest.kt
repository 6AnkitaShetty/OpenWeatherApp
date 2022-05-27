package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.domain.data.FakeDataUtil
import com.example.openweatherapp.domain.repository.FakeBookMarkRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DeleteCityUseCaseTest {

    private lateinit var fakeBookMarkRepository: FakeBookMarkRepository

    @Before
    fun setUp() {
        fakeBookMarkRepository = FakeBookMarkRepository()
        val bookMarkedCities = FakeDataUtil.getFakeBookMarkedCities()
        runBlocking {
            bookMarkedCities.forEach {
                fakeBookMarkRepository.insertCity(it)
            }
        }
    }

    @Test
    fun testDeleteCityUseCase_CheckCityRemoved() {
        runBlocking {
            val city = fakeBookMarkRepository.getCities()[0]
            fakeBookMarkRepository.deleteCity(city)
            assertEquals(fakeBookMarkRepository.getCities().size, 1)
        }

    }
}