package com.mindorks.framework.mvp.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by jyotidubey on 06/01/18.
 */
class OptionsRepoHelperImpl @Inject constructor(private val optionsDao: OptionsDao) : OptionsRepoHelper {

    override fun isOptionsRepoEmpty(): Observable<Boolean> {
        return Observable.just(optionsDao.loadAll().isEmpty())
    }

    override fun insertOptions(options: List<Options>): Observable<Boolean> {
        optionsDao.insertAll(options)
        return Observable.just(true)
    }

    override fun loadOptions(questionId: Long): Single<List<Options>> {
        return Single.fromCallable({ optionsDao.loadOptionsByQuestionId(questionId) })
    }

}