package trv.mse.katas.dagger.util

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun io(): Scheduler

}
