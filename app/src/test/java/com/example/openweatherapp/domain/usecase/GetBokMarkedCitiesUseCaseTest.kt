package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.domain.data.FakeDataUtil
import com.example.openweatherapp.domain.repository.FakeBookMarkRepository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetBokMarkedCitiesUseCaseTest {

    private lateinit var getBokMarkedCitiesUseCase: GetBokMarkedCitiesUseCase
    private lateinit var fakeBookMarkRepository: FakeBookMarkRepository

    @Before
    fun setUp(){
        fakeBookMarkRepository = FakeBookMarkRepository()
        getBokMarkedCitiesUseCase = GetBokMarkedCitiesUseCase(fakeBookMarkRepository)

        val bookMarkedCities = FakeDataUtil.getFakeBookMarkedCities()
        runBlocking {
            bookMarkedCities.forEach {
                fakeBookMarkRepository.insertCity(it)
            }
        }
    }

    @Test
    fun testGetBokMarkedCitiesUseCase_GetBokMarkedCities() {
        runBlocking {
            val bookMarkedCities = fakeBookMarkRepository.getCities()
            assertNotNull(bookMarkedCities)
            assertEquals(bookMarkedCities.size, 2)
        }

    }
}