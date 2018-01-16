package com.mindorks.framework.mvp.util

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by jyotidubey on 16/01/18.
 */
class SchedulerProvider {

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                    .observeOn(getMainThreadScheduler())
        }
    }

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> {
        return SingleTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                    .observeOn(getMainThreadScheduler())
        }
    }

    fun ioToMainCompletableScheduler(): CompletableTransformer {
        return CompletableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                    .observeOn(getMainThreadScheduler())
        }
    }

    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                    .observeOn(getMainThreadScheduler())
        }
    }

    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> {
        return MaybeTransformer { upstream ->
            upstream.subscribeOn(getIOThreadScheduler())
                    .observeOn(getMainThreadScheduler())
        }
    }

    private fun getIOThreadScheduler(): Scheduler {
        return Schedulers.io()
    }
    private fun getMainThreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }


}