package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.domain.data.FakeDataUtil
import com.example.openweatherapp.domain.repository.FakeBookMarkRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class InsertCityUseCaseTest {
    private lateinit var fakeBookMarkRepository: FakeBookMarkRepository

    @Before
    fun setUp() {
        fakeBookMarkRepository = FakeBookMarkRepository()
    }

    @Test
    fun testInsertCityUseCase_GetInsertedCity() {
        runBlocking {
            val city = FakeDataUtil.getCity()
            val result = fakeBookMarkRepository.insertCity(city)
            assertEquals(result, 0)
        }

    }
}