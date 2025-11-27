package lt.neworld.mrepro.app

import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ActivityScope
import lt.neworld.mrepro.fragment.Fragment
import lt.neworld.mrepro.fragment.FragmentGraph

@Inject
@ActivityScope
class Activity(
    val fragmentGraphFactory: FragmentGraph.Factory
) {
    inline fun <reified T : Fragment> createFragment(): T {
        val fragmentGraph = fragmentGraphFactory.createFragmentGraph(T::class)
        return fragmentGraph.fragment as T
    }
}