package com.gama.task.util

import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.annotation.RequiresApi
import com.gama.task.util.Constants.USER_LANGUAGE
import com.gama.task.util.Localization.Language.*
import com.gama.task.util.extensions.get
import com.gama.task.util.extensions.put
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * A util obj to mange localization which support all android APIs.
 */
object Localization {

    /**
     * The enum of supported languages, [UN_SET_LANG] is the default language if user didn't select one before,
     * it means the current lang of the device.
     * @property langId Int a unique id for every lang that indicate to it
     * @property langValue String the string value of the language to be used when change app localization and api localization
     *
     */
    enum class Language(val langId: Int, val langValue: String) {
        UN_SET_LANG(-1, ""),
        ENGLISH(0, "en"),
        ARABIC(1, "ar")
    }

    /**
     * get the sharedPref instance to store or read selected lang
     * @param context Context the app context
     * @return SharedPreferences the instance of sharedPref
     */
    private fun getPreference(context: Context) =
        context.getSharedPreferences("${context.packageName}.pref", Context.MODE_PRIVATE)

    /**
     * store language id in sharedPref
     *
     * @param context Context the app Context
     * @param targetLanguage Language the language to be stored to sharedPref
     */
    suspend fun storeAppLanguage(context: Context, targetLanguage: Language) {
        getPreference(context).put(USER_LANGUAGE, targetLanguage.langId)
    }

    /**
     * get the stored lang in sharedPref
     * @param context Context the app Context
     * @return Int the stored [Language.langId] or [UN_SET_LANG.langId] if no language stored
     */
    fun getStoredLanguage(context: Context) =
        getPreference(context).get(USER_LANGUAGE, UN_SET_LANG.langId)

    /**
     * invert the stored lang if eng store ar and vice versa
     * @param context Context the app Context
     */
    suspend fun invertLang(context: Context) {
        storeAppLanguage(
            context,
            if (getStoredLanguage(context) == ARABIC.langId) ENGLISH else ARABIC
        )
    }

    /**
     * use it to update activity localization
     * (call it before setContentView method and in attachBaseContext as shown below).
     *
     * override fun attachBaseContext(newBase: Context?) {
     *   super.attachBaseContext(newBase?.let {
     *       updateActivityLocale(it, preferencesInstance)
     *   })
     * }
     *
     * @param context the activity context to update its local.
     * @return Context? the context with updated localization
     */
    fun updateContextLocale(context: Context?): Context? {

        if (context == null)
            return null

        /**
         * read the stored lang and if no stored lang get the current device lang and store it
         */
        val language = when (getStoredLanguage(context)) {
            ENGLISH.langId -> ENGLISH
            ARABIC.langId -> ARABIC
            else -> getCurrentLang(context).apply {
                GlobalScope.launch(Dispatchers.IO) {
                    storeAppLanguage(context, this@apply)
                }
            }
        }

        // update the localization of the context's resources and return it
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language.langValue)
        } else {
            updateResourcesLegacy(context, language.langValue)
        }

    }


    /**
     * get current lang
     * @return Language the current app lang
     */
    fun getCurrentLang(context: Context): Language {

        val lang = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            context.resources.configuration.locales.get(0).language
        else
            Locale.getDefault().language

        return if (lang.contains("ar", true)) ARABIC else ENGLISH
    }


    /**
     * update context's resources for android N and above
     * @param context Context the context to update its resources
     * @param language String the language to be set
     * @return Context the updated context
     */
    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateResources(
        context: Context,
        language: String
    ): Context {

        val locale = Locale(language)
        val localeList = LocaleList(locale)

        // update locale
        val configuration = context.resources.configuration
        configuration.setLocale(locale)

        LocaleList.setDefault(localeList)
        configuration.setLocales(localeList)

        // update direction
        configuration.setLayoutDirection(locale)

        return context.createConfigurationContext(configuration)
    }

    /**
     * update context's resources for android below N
     * @param context Context the context to update its resources
     * @param language String the language to be set
     * @return Context the updated context
     */
    private fun updateResourcesLegacy(
        context: Context,
        language: String
    ): Context {

        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale)
        }
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}