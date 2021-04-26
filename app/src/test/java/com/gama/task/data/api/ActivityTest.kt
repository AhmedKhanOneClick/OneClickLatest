package com.gama.saudi2go.data.api


import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ActivityTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


//    private lateinit var apiHelper: ApiHelperImpl

//    @Mock
//    private lateinit var apiEmployeeObserver: Observer<Resource<MainData>?>

    private lateinit var mockWebServer: MockWebServer
}