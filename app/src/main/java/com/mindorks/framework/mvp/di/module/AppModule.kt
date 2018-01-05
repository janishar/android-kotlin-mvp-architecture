package com.mindorks.framework.mvp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.mindorks.framework.mvp.data.AppDataManager
import com.mindorks.framework.mvp.data.DataManager
import com.mindorks.framework.mvp.data.database.AppDBHelper
import com.mindorks.framework.mvp.data.database.AppDatabase
import com.mindorks.framework.mvp.data.database.DBHelper
import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.AppApiHelper
import com.mindorks.framework.mvp.data.preferences.AppPreferenceHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.util.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase {
        /**
         * TODO : Remove allowMainThreadQueries(), as it may potentially lock the UI for a long period of time
         */
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).allowMainThreadQueries()
                .build()
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDBHelper): DBHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(): ApiHelper {
        return AppApiHelper()
    }

    @Provides
    @Singleton
    internal fun providePrefHelper(): PreferenceHelper {
        return AppPreferenceHelper()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }
}