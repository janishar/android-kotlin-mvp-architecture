package com.mindorks.framework.mvp.util

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by jyotidubey on 07/01/18.
 */
object FileUtils {

    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        (context.assets).open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            return String(buffer, Charset.forName("UTF-8"))
        }
    }
}
