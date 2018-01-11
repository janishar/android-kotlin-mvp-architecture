package com.mindorks.framework.mvp.data.network

import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by jyotidubey on 04/01/18.
 */
interface ApiHelper {
    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>
    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>
    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>
}