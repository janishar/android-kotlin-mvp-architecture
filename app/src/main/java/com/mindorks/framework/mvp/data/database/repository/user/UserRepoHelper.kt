package com.mindorks.framework.mvp.data.database.repository.user

import io.reactivex.Observable

/**
 * Created by jyotidubey on 06/01/18.
 */
interface UserRepoHelper {
    fun insertUser(user: User) : Observable<Boolean>
    fun loadUsers(): List<User>
}