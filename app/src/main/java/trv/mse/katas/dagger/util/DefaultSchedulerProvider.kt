package trv.mse.katas.dagger.util

import io.reactivex.schedulers.Schedulers

class DefaultSchedulerProvider : ISchedulerProvider {

    override fun io() = Schedulers.io()

}
