package  com.beebeeedge.domain.intractors.types

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>?
}