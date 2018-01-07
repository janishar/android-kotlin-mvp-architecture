package com.mindorks.framework.mvp.ui.main.interactor;

import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepoHelper;
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionRepoHelperImpl;
import com.mindorks.framework.mvp.data.database.repository.questions.QuestionsDao;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by jyotidubey on 07/01/18.
 */

public class x {
 QuestionRepoHelper questionRepoHelper = new QuestionRepoHelperImpl(null);
 void  fun(){
   questionRepoHelper.isQuestionsRepoEmpty().concatMap(
       new Function<Boolean, ObservableSource<?>>() {
         @Override
         public ObservableSource<?> apply(Boolean aBoolean) throws Exception {
           if(aBoolean){
             return Observable.just(true);
           }else{
             return Observable.just(false);
           }
         }
       });
 }
}
