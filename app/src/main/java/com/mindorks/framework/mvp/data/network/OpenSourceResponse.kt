package com.mindorks.framework.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 14/01/18.
 */
data class OpenSourceResponse(@Expose
                             @SerializedName("status_code")
                             private var statusCode: String? = null,

                             @Expose
                             @SerializedName("message")
                             private var message: String? = null,

                             @Expose
                             @SerializedName("data")
                             var data: List<OpenSource>? = null)

