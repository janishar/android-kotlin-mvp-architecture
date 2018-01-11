package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 11/01/18.
 */
class LoginRequest {
    class ServerLoginRequest internal constructor(@Expose
                             @SerializedName("email") internal val email: String,
                             @Expose
                             @SerializedName("password") internal val password: String) {

        override fun equals(`object`: Any?): Boolean {
            if (this === `object`) return true
            if (`object` == null || javaClass != `object`.javaClass) return false

            val that = `object` as ServerLoginRequest?

            if (if (email != null) email != that!!.email else that!!.email != null) return false
            return if (password != null) password == that.password else that.password == null

        }

        override fun hashCode(): Int {
            var result = email?.hashCode() ?: 0
            result = 31 * result + (password?.hashCode() ?: 0)
            return result
        }

    }

    class FacebookLoginRequest internal constructor(@Expose
                               @SerializedName("fb_user_id")
                               internal val fbUserId: String,
                               @Expose
                               @SerializedName("fb_access_token")
                               internal val fbAccessToken: String) {

        override fun equals(`object`: Any?): Boolean {
            if (this === `object`) return true
            if (`object` == null || javaClass != `object`.javaClass) return false

            val that = `object` as FacebookLoginRequest?

            if (if (fbUserId != null) fbUserId != that!!.fbUserId else that!!.fbUserId != null)
                return false
            return if (fbAccessToken != null)
                fbAccessToken == that!!.fbAccessToken
            else
                that!!.fbAccessToken == null

        }

        override fun hashCode(): Int {
            var result = fbUserId?.hashCode() ?: 0
            result = 31 * result + if (fbAccessToken != null) fbAccessToken.hashCode() else 0
            return result
        }

    }

    class GoogleLoginRequest(
            @Expose
            @SerializedName("google_user_id")
            internal val googleUserId: String,
            @Expose
            @SerializedName("google_id_token")
            internal val idToken: String) {


        override fun equals(`object`: Any?): Boolean {
            if (this === `object`) return true
            if (`object` == null || javaClass != `object`.javaClass) return false

            val that = `object` as GoogleLoginRequest?

            if (if (googleUserId != null)
                googleUserId != that!!.googleUserId
            else
                that!!.googleUserId != null)
                return false
            return if (idToken != null) idToken == that.idToken else that.idToken == null

        }

        override fun hashCode(): Int {
            var result = googleUserId?.hashCode() ?: 0
            result = 31 * result + (idToken?.hashCode() ?: 0)
            return result
        }
    }
}