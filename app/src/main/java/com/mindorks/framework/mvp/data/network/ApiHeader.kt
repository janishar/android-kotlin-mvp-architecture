package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

/**
 * Created by jyotidubey on 11/01/18.
 */
class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader, internal val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader @Inject constructor(@Expose
                                              @SerializedName("api_key") val apiKey: String)

    class ProtectedApiHeader @Inject constructor(@Expose
                                                 @SerializedName("api_key") val apiKey: String,
                                                 @Expose
                                                 @SerializedName("user_id") val userId: Long?,
                                                 @Expose
                                                 @SerializedName("access_token") val accessToken: String?)

}