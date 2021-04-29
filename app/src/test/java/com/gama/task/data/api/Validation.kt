package com.gama.task.data.api


import com.gama.databinding_validation.CommonPatterns
import com.gama.task.BaseApp
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.junit.MockitoJUnitRunner
import java.util.regex.Matcher
import java.util.regex.Pattern


//@RunWith(AndroidJUnit4::class)
@RunWith(MockitoJUnitRunner::class)
class Validation {
    private lateinit var stringToBetyped: String


    //        ActivityTestRule(LoginFragment::class.java)
    //    @Captor
//    var stringCaptor: String = "mohamed"
//    @get:Rule
//    var activityRule: ActivityScenarioRule<MainActivity>
//            = ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun initValidString() {
        MockitoAnnotations.initMocks(this)
        val mMyApplication: BaseApp = mock(BaseApp::class.java)
//    RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }
    }

    fun init() {
        initMocks(this)
    }

    @Test
    fun validate_email() {
        assertTrue(isValid_email("mohamednosier123@gmail.com"))
    }

    @Test
    fun validate_name_requires() {
        val mystring = "mohamed"
        assertTrue(mystring.length > 3)
        assertEquals(7, mystring.length)
    }

    @Test
    fun validate_phone() {
        assertTrue(isValid_phone("01286072385"))
    }

    @Test
    fun validate_iban() {
        val mystring = "SA1231234567891234567891"
        assertTrue(mystring.length == 24)
        assertTrue(mystring.contains("SA"))
    }

    @Test
    fun validate_password() {
        assertTrue(isValid_password("P@ssw0rd2020"))
    }

    val pattern_email = Pattern.compile(CommonPatterns.EMAIL)
    fun isValid_email(email: String?): Boolean {
        val matcher: Matcher = pattern_email.matcher(email)
        return matcher.matches()
    }

    val pattern_password = Pattern.compile(CommonPatterns.COMPLEX_PASSWORD)
    fun isValid_password(password: String?): Boolean {
        val matcher: Matcher = pattern_password.matcher(password)
        return matcher.matches()
    }

    val pattern_phone = Pattern.compile(CommonPatterns.PHONE)
    fun isValid_phone(phone: String?): Boolean {
        val matcher: Matcher = pattern_phone.matcher(phone)
        return matcher.matches()
    }

}
