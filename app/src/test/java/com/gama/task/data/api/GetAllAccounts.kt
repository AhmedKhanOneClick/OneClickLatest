package com.gama.saudi2go.data.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gama.saudi2go.getOrAwaitValue
import com.gama.task.data.api.ApiService
import com.gama.task.data.api.ApiSuccessResponse
import com.gama.task.util.LiveDataCallAdapterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import junit.framework.Assert.assertEquals
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader
import java.net.HttpURLConnection
import javax.inject.Inject
import javax.inject.Singleton

@RunWith(JUnit4::class)
class GetAllAccounts {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: ApiService

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        val client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(HttpInterceptor())
            .build()

        val factory = GsonConverterFactory.create(
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        )

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }


    @Test
    fun login() {
        enqueueResponse("accounts.json")


        val userAuth = (service.getAllaccounts()
            .getOrAwaitValue() as ApiSuccessResponse).body?.data?.accounts?.get(0)?.balance
//        val userAuth1 = (service.GetAllNationalities().getOrAwaitValue() as ApiSuccessResponse).body?.success
//        val userAuth = (service.GetAllNationalities().getOrAwaitValue() as ApiSuccessResponse).headers.

//        val userAuth1 = (service.searchHotels(HotelSearchRequest("")).getOrAwaitValue() as ApiSuccessResponse).body
        val request = mockWebServer.takeRequest()
//        val response=service.GetAllNationalities()
//        Log.d("response", "login: "+response)
//        userAuth1.
//
//        assertThat(response.value, `is`("Bearer"))
        Assert.assertEquals(0, Integer.parseInt(userAuth.toString()))
        Assert.assertNotNull(request.body)

        junit.framework.Assert.assertNotNull(userAuth)
//         verify(mockWebServer.takeRequest())
//        MatcherAssert.assertThat(response.code().isEqualTo(200))
//        MatcherAssert.assertThat(response.observeForever, CoreMatchers.`is`(200))

        //completed
//        Assert.assertNotNull(userAuth)
//        Assert.assertNotNull(request.body)
//        Assert.assertEquals(true, userAuth1)
//        Assert.assertEquals("AF", userAuth)
    }
//        Assert.assertNotNull(userAuth)
//        assertThat(userAuth?.tokenType, `is`("Bearer"))
//        MatcherAssert.assertThat(userAuth?.databaseID, CoreMatchers.`is`(1))


    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader!!
            .getResourceAsStream("api-response/$fileName")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(
            mockResponse
                .setBody(source.readString(Charsets.UTF_8))
        )
    }

    @Singleton
    class HttpInterceptor @Inject constructor() : Interceptor {
        //        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request().newBuilder()
//                .addHeader("Accept-Language", Locale.getDefault().getLanguage())
                .addHeader(
                    "Authorization",
                    "Bearer 368e0734f1b97d289c41dab0fc9067c7c7fb42ff4a9a33b97221177d6df87953"
                )
                .build()
            return chain.proceed(request)
        }
    }

    @Test
    fun `read sample success json file`() {
        val reader = MockResponseFileReader("accounts.json")
        junit.framework.Assert.assertNotNull(reader)
    }

    @Test
    fun `fetch details and check response Code 200 returned`() {
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("accounts.json").content)
        mockWebServer.enqueue(response)
        // Act
//        val actualResponse = (service.getAllaccounts().getOrAwaitValue() as ApiSuccessResponse).body?.toString()?.contains("200")
//
        val actualResponse = (service.getAllaccounts()
            .getOrAwaitValue() as ApiSuccessResponse).body?.data?.accounts?.size!! > 0

//        val  actualResponse = apiHelper.getEmployeeDetails().execute()
        // Assert
        junit.framework.Assert.assertEquals(response.toString().contains("200"), actualResponse)
    }

    @Test
    fun `fetch details and check response success returned`() {
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader("accounts.json").content)
        mockWebServer.enqueue(response)
        val mockResponse = response.getBody()?.readUtf8()
        // Act
//        val  actualResponse = apiHelper.getEmployeeDetails().execute()
        val actualResponse =
            (service.getAllaccounts().getOrAwaitValue() as ApiSuccessResponse).body?.data.toString()
        // Assert
//        assertEquals(mockResponse?.let { `parse mocked JSON response`(it) }, actualResponse)
        assertEquals(mockResponse, actualResponse)
    }

    class MockResponseFileReader(path: String, headers: Map<String, String> = emptyMap()) {

        val content: String

        init {
            val inputStream = javaClass.classLoader!!
                .getResourceAsStream("api-response/$path")
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            for ((key, value) in headers) {
                mockResponse.addHeader(key, value)
            }
//            mockWebServer.enqueue(
//                mockResponse
//                    .setBody(source.readString(Charsets.UTF_8))
//            )

            val reader =
                InputStreamReader(this.javaClass.classLoader?.getResourceAsStream("api-response/$path"))
            content = reader.readText()
            reader.close()
        }
    }
}