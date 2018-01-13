package com.mindorks.framework.mvp.ui.exception

/**
 * Created by jyotidubey on 11/01/18.
 */
class ViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.onAttach() before requesting data from presenter") {

}