package trv.mse.katas.dagger.util

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultSchedulerProvider @Inject constructor() : ISchedulerProvider {

    override fun io() = Schedulers.io()

}
