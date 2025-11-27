package lt.neworld.mrepro.app

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.GraphExtension
import lt.neworld.mrepro.di.ActivityScope
import lt.neworld.mrepro.di.ApplicationScope

@ActivityScope
@GraphExtension(scope = ActivityScope::class)
interface ActivityGraph {
    val activity: Activity

    @ContributesTo(ApplicationScope::class)
    fun interface Factory {
        fun createActivity(): ActivityGraph
    }
}