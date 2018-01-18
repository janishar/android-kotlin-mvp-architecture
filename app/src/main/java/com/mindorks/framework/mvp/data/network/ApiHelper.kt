package com.mindorks.framework.mvp.data.network

import io.reactivex.Observable

/**
 * Created by jyotidubey on 04/01/18.
 */
interface ApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>
    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>
    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>
    fun performLogoutApiCall(): Observable<LogoutResponse>
    fun getBlogApiCall(): Observable<BlogResponse>
    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>



}