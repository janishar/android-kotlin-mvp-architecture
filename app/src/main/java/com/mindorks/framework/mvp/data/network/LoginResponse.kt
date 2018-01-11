package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 11/01/18.
 */
class LoginResponse {

    @Expose
    @SerializedName("status_code")
    var statusCode: String? = null

    @Expose
    @SerializedName("user_id")
    var userId: Long? = null

    @Expose
    @SerializedName("access_token")
    var accessToken: String? = null

    @Expose
    @SerializedName("user_name")
    var userName: String? = null

    @Expose
    @SerializedName("email")
    var userEmail: String? = null

    @Expose
    @SerializedName("server_profile_pic_url")
    var serverProfilePicUrl: String? = null

    @Expose
    @SerializedName("fb_profile_pic_url")
    var fbProfilePicUrl: String? = null

    @Expose
    @SerializedName("google_profile_pic_url")
    var googleProfilePicUrl: String? = null

    @Expose
    @SerializedName("message")
    var message: String? = null

    override fun equals(`object`: Any?): Boolean {
        if (this === `object`) return true
        if (`object` == null || javaClass != `object`.javaClass) return false

        val that = `object` as LoginResponse?

        if (if (statusCode != null) statusCode != that!!.statusCode else that!!.statusCode != null)
            return false
        if (if (userId != null) userId != that.userId else that.userId != null) return false
        if (if (accessToken != null) accessToken != that.accessToken else that.accessToken != null)
            return false
        if (if (userName != null) userName != that.userName else that.userName != null)
            return false
        if (if (userEmail != null) userEmail != that.userEmail else that.userEmail != null)
            return false
        if (if (serverProfilePicUrl != null)
            serverProfilePicUrl != that.serverProfilePicUrl
        else
            that.serverProfilePicUrl != null)
            return false
        if (if (fbProfilePicUrl != null)
            fbProfilePicUrl != that.fbProfilePicUrl
        else
            that.fbProfilePicUrl != null)
            return false
        if (if (googleProfilePicUrl != null)
            googleProfilePicUrl != that.googleProfilePicUrl
        else
            that.googleProfilePicUrl != null)
            return false
        return if (message != null) message == that.message else that.message == null

    }

    override fun hashCode(): Int {
        var result = if (statusCode != null) statusCode!!.hashCode() else 0
        result = 31 * result + if (userId != null) userId!!.hashCode() else 0
        result = 31 * result + if (accessToken != null) accessToken!!.hashCode() else 0
        result = 31 * result + if (userName != null) userName!!.hashCode() else 0
        result = 31 * result + if (userEmail != null) userEmail!!.hashCode() else 0
        result = 31 * result + if (serverProfilePicUrl != null) serverProfilePicUrl!!.hashCode() else 0
        result = 31 * result + if (fbProfilePicUrl != null) fbProfilePicUrl!!.hashCode() else 0
        result = 31 * result + if (googleProfilePicUrl != null) googleProfilePicUrl!!.hashCode() else 0
        result = 31 * result + if (message != null) message!!.hashCode() else 0
        return result
    }
}