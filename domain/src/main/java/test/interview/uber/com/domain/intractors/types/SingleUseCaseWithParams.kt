package  com.beebeeedge.domain.intractors.types

import io.reactivex.Single

interface SingleUseCaseWithParams<P,R> {
    fun execute(params:P): Single<R>?
}