package com.mindorks.framework.mvp.ui.main.view

import com.mindorks.framework.mvp.ui.base.view.MVPView
import com.mindorks.framework.mvp.ui.main.interactor.QuestionCardData

/**
 * Created by jyotidubey on 08/01/18.
 */
interface MainView  : MVPView{
    fun inflateUserDetails(userDetails: Pair<String?,String?>)
    fun displayQuestionCard(questionCard : List<QuestionCardData>)
    fun openLoginActivity()
    fun openAboutFragment()
    fun lockDrawer()
    fun unlockDrawer()
}