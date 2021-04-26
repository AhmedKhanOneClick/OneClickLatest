package com.gama.task.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HeadersInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ErrorInterceptor


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NormalRequest

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IdentityRequest