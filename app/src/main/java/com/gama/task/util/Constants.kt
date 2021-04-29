package com.gama.task.util

object Constants {

    //numbers
    const val CACHE_SIZE = 10 * 1024 * 1024 //10MB
    const val CACHE_MAX_STALE = 60 * 60 * 24 * 7 //1 week


    // pref keys
    const val USER_LANGUAGE = "user_language"

    // requests code
    const val SELECT_WALLET_REQUEST = "selectWalletKey"
    const val FORCE_UPDATE_LIST = "forceUpdateList"
}