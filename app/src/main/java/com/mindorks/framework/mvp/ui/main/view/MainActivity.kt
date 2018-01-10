package com.mindorks.framework.mvp.ui.main.view

import android.os.Bundle
import android.os.Handler
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.main.interactor.MainInteractor
import com.mindorks.framework.mvp.ui.main.interactor.QuestionCardData
import com.mindorks.framework.mvp.ui.main.presenter.MainPresenter
import com.mindorks.framework.mvp.util.ScreenUtils
import com.mindorks.placeholderview.SwipeDecor
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    internal lateinit var presenter: MainPresenter<MainView, MainInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCardContainerView()
        presenter.onAttach(this)

    }

    override fun displayQuestionCard(questionCards: List<QuestionCardData>) {
        for (questionCard in questionCards) {
            questionHolder.addView(QuestionCard(questionCard))
        }
    }

    private fun setupCardContainerView() {

        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)

        questionHolder.getBuilder()
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10f)
                .setWidthSwipeDistFactor(5f)
                .setSwipeDecor(SwipeDecor()
                        .setViewWidth((0.90 * screenWidth).toInt())
                        .setViewHeight((0.75 * screenHeight).toInt())
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f))

        questionHolder.addItemRemoveListener { count ->
            if (count == 0) {
                Handler(mainLooper).postDelayed({ presenter.refreshQuestionCards() }, 800)
            }
        }
    }
}
