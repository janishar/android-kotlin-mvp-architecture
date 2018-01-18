package com.mindorks.framework.mvp.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    override fun performServerLogin(request: LoginRequest.ServerLoginRequest) = Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectObservable(LoginResponse::class.java)


    override fun performFBLogin(request: LoginRequest.FacebookLoginRequest) = Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectObservable(LoginResponse::class.java)


    override fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest) = Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectObservable(LoginResponse::class.java)


    override fun performLogoutApiCall() = Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
            .addHeaders(apiHeader.protectedApiHeader)
            .build()
            .getObjectObservable(LogoutResponse::class.java)


    override fun getBlogApiCall() = Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
            .addHeaders(apiHeader.protectedApiHeader)
            .build()
            .getObjectObservable(BlogResponse::class.java)


    override fun getOpenSourceApiCall() = Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
            .addHeaders(apiHeader.protectedApiHeader)
            .build()
            .getObjectObservable(OpenSourceResponse::class.java)


}