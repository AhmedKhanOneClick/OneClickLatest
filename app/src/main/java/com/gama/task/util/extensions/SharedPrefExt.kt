package com.gama.task.util.extensions

import android.content.SharedPreferences

/**
 * Extension function to get the pref value and determine its type from [defaultValue]
 *
 * @receiver SharedPreferences
 * @param key String the key of pref
 * @param defaultValue T the value to be returned if no data stored in this key
 * @return T the stored value or [defaultValue]
 *
 * @see put
 */
inline fun <reified T> SharedPreferences.get(key: String, defaultValue: T): T {
    when (T::class) {
        Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
        Float::class -> return this.getFloat(key, defaultValue as Float) as T
        Int::class -> return this.getInt(key, defaultValue as Int) as T
        Long::class -> return this.getLong(key, defaultValue as Long) as T
        String::class -> return this.getString(key, defaultValue as String) as T
        else -> {
            if (defaultValue is Set<*>) {
                return this.getStringSet(key, defaultValue as Set<String>) as T
            }
        }
    }

    return defaultValue
}

/**
 * Extension function to store value in pref.
 * @receiver SharedPreferences
 * @param key String the key of pref
 * @param value T the value to be stored
 */
inline fun <reified T> SharedPreferences.put(key: String, value: T) {
    val editor = this.edit()

    when (T::class) {
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        Float::class -> editor.putFloat(key, value as Float)
        Int::class -> editor.putInt(key, value as Int)
        Long::class -> editor.putLong(key, value as Long)
        String::class -> editor.putString(key, value as String)
        else -> {
            if (value is Set<*>) {
                editor.putStringSet(key, value as Set<String>)
            }
        }
    }

    editor.apply()
}

/**
 * Extension function to remove value from pref.
 *
 * @receiver SharedPreferences
 * @param key String the key of pref to be removed
 */
fun SharedPreferences.remove(key: String) = this.edit().remove(key).apply()