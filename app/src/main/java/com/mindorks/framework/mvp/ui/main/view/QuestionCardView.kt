package com.mindorks.framework.mvp.ui.main.view

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import com.androidnetworking.widget.ANImageView
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.main.interactor.QuestionCardData
import com.mindorks.placeholderview.annotations.*

/**
 * Created by jyotidubey on 09/01/18.
 */
@NonReusable
@Layout(R.layout.card_layout)
class QuestionCard(private val mQuestion: QuestionCardData) {

    @View(R.id.tv_question_txt)
    private lateinit var mQuestionTextView: TextView

    @View(R.id.btn_option_1)
    private lateinit var mOption1Button: Button

    @View(R.id.btn_option_2)
    private lateinit var mOption2Button: Button

    @View(R.id.btn_option_3)
    private lateinit var mOption3Button: Button

    @View(R.id.iv_pic)
    private lateinit var mPicImageView: ANImageView

    @Resolve
    private fun onResolved() {

        mQuestionTextView.text = mQuestion.question.questionText

        for (i in 0..2) {
            var button: Button? = null
            when (i) {
                0 -> button = mOption1Button
                1 -> button = mOption2Button
                2 -> button = mOption3Button
            }

            button?.text = mQuestion.option[i].optionText

            if(mQuestion.question.imgUrl != null) {
                mPicImageView.setImageUrl(mQuestion.question.imgUrl)

            }

        }
    }

    private fun showCorrectOptions() {
        for (i in 0..2) {
            val option = mQuestion.option[i]
            var button: Button? = null
            when (i) {
                0 -> button = mOption1Button
                1 -> button = mOption2Button
                2 -> button = mOption3Button
            }
            if (button != null) {
                if (option.isCorrect) {
                    button.setBackgroundColor(Color.GREEN)
                } else {
                    button.setBackgroundColor(Color.RED)
                }
            }
        }
    }

    @Click(R.id.btn_option_1)
    fun onOption1Click() {
        showCorrectOptions()
    }

    @Click(R.id.btn_option_2)
    fun onOption2Click() {
        showCorrectOptions()
    }

    @Click(R.id.btn_option_3)
    fun onOption3Click() {
        showCorrectOptions()
    }

}