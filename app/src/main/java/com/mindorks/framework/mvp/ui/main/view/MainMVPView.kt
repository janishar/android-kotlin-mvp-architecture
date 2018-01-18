package com.mindorks.framework.mvp.ui.main.view

import com.mindorks.framework.mvp.ui.base.view.MVPView
import com.mindorks.framework.mvp.ui.main.interactor.QuestionCardData

/**
 * Created by jyotidubey on 08/01/18.
 */
interface MainMVPView : MVPView {

    fun inflateUserDetails(userDetails: Pair<String?, String?>)
    fun displayQuestionCard(questionCard: List<QuestionCardData>)
    fun openLoginActivity()
    fun openFeedActivity()
    fun openAboutFragment()
    fun openRateUsDialog(): Unit?
    fun lockDrawer(): Unit?
    fun unlockDrawer(): Unit?
}