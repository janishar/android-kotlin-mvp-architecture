package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 11/01/18.
 */
class LoginRequest {

    data class ServerLoginRequest internal constructor(@Expose
                                                       @SerializedName("email") internal val email: String,
                                                       @Expose
                                                       @SerializedName("password") internal val password: String)

    data class FacebookLoginRequest internal constructor(@Expose
                                                         @SerializedName("fb_user_id")
                                                         internal val fbUserId: String,
                                                         @Expose
                                                         @SerializedName("fb_access_token")
                                                         internal val fbAccessToken: String)

    data class GoogleLoginRequest internal constructor(@Expose
                                                       @SerializedName("google_user_id")
                                                       internal val googleUserId: String,
                                                       @Expose
                                                       @SerializedName("google_id_token")
                                                       internal val idToken: String)

}