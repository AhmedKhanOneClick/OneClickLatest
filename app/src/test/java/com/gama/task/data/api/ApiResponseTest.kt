package com.gama.saudi2go.data.api


import com.gama.task.data.api.ApiErrorResponse
import com.gama.task.data.api.ApiResponse
import com.gama.task.data.api.ApiSuccessResponse
import com.gama.task.models.GeneralResponse
import com.gama.task.models.IdentityGeneralResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("foo")
        val (errorMessage) = ApiResponse.create<String>(exception)
        assertThat(errorMessage, `is`("foo"))
    }

    @Test
    fun success() {
        val apiResponse = ApiResponse.create(Response.success("foo")) as ApiSuccessResponse<String>
        assertThat<String>(apiResponse.body, `is`("foo"))
    }

    @Test
    fun errorWithCode200AndBodyIdentifyGeneralResponse() {
        val apiResponse =
            ApiResponse.create(
                Response.error<String>(
                    400,
                    "blah".toResponseBody("application/txt".toMediaTypeOrNull())
                )
            ) as ApiErrorResponse<IdentityGeneralResponse>


        assertThat(apiResponse.responseCode, `is`(400))
        assertThat(apiResponse.errorMessage, `is`("blah"))
    }


    @Test
    fun successWithCode200AndBodyIdentifyGeneralResponse() {
        val apiResponse =
            ApiResponse.create(
                Response.success(
                    IdentityGeneralResponse(
                        success = false,
                        errorMessage = "blah"
                    )
                )
            ) as ApiSuccessResponse<IdentityGeneralResponse>


//        assertThat(apiResponse., `is`(200))
//        assertThat(apiResponse.errorMessage, `is`("blah"))
    }


    @Test
    fun errorWithCode200AndBodyGeneralResponse() {
        val apiResponse =
            ApiResponse.create(
                Response.success(
                    GeneralResponse<Unit>(

                        data = null
                    )
                )
            ) as ApiErrorResponse<GeneralResponse<Unit>>


        assertThat(apiResponse.responseCode, `is`(200))
        assertThat(apiResponse.errorMessage, `is`("blah"))
    }


    @Test
    fun error() {
        val errorResponse = Response.error<String>(
            400,
            "blah".toResponseBody("application/txt".toMediaTypeOrNull())
        )
        val (errorMessage) = ApiResponse.create<String>(errorResponse) as ApiErrorResponse<String>

        assertNull(errorMessage)
    }
}