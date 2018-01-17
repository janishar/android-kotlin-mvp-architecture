package com.mindorks.framework.mvp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.mindorks.framework.mvp.BuildConfig
import com.mindorks.framework.mvp.data.database.AppDatabase
import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepo
import com.mindorks.framework.mvp.data.database.repository.options.OptionsRepository
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepo
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepository
import com.mindorks.framework.mvp.data.network.ApiHeader
import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.network.AppApiHelper
import com.mindorks.framework.mvp.data.preferences.AppPreferenceHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.di.PreferenceInfo
import com.mindorks.framework.mvp.util.AppConstants
import com.mindorks.framework.mvp.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
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
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME)
                .build()
    }

    @Provides
    internal fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper {
        return appPreferenceHelper
    }

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(apiKey: String, preferenceHelper: PreferenceHelper): ApiHeader.ProtectedApiHeader {
        return ApiHeader.ProtectedApiHeader(apiKey = apiKey,
                userId = preferenceHelper.getCurrentUserId(),
                accessToken = preferenceHelper.getAccessToken())
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }


    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo {
        return QuestionRepository(appDatabase.questionsDao())
    }

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionsRepo {
        return OptionsRepository(appDatabase.optionsDao())
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProvider()
    }


}