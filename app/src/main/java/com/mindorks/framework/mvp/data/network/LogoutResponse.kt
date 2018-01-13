package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 12/01/18.
 */
data class LogoutResponse internal constructor(@Expose
                                               @SerializedName("status_code")
                                               private var statusCode: String? = null,
                                               @Expose
                                               @SerializedName("message")
                                               private var message: String? = null)

