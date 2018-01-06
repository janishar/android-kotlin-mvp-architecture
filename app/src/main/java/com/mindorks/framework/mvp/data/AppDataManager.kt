package com.mindorks.framework.mvp.data

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppDataManager @Inject internal constructor(val apiHelper: ApiHelper, val prefHelper: PreferenceHelper) : DataManager {

}