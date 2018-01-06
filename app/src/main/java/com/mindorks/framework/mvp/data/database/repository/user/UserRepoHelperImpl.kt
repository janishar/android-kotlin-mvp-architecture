package com.mindorks.framework.mvp.data.database.repository.user

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jyotidubey on 06/01/18.
 */
class UserRepoHelperImpl @Inject constructor(val userDao: UserDao) : UserRepoHelper {
    override fun insertUser(user: User): Observable<Boolean> {
        userDao.insert(user)
        return Observable.just(true)
    }

    override fun loadUsers(): List<User>? {
        return userDao.getUser()
    }
}