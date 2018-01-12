package com.mindorks.framework.mvp.ui.main.interactor

import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.questions.Question

/**
 * Created by jyotidubey on 08/01/18.
 */
data class QuestionCardData(val option: List<Options>, val question: Question)