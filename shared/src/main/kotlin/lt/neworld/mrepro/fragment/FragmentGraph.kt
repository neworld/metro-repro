package lt.neworld.mrepro.fragment

import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provider
import dev.zacsweers.metro.Provides
import lt.neworld.mrepro.di.ActivityScope
import lt.neworld.mrepro.di.FragmentScope
import kotlin.reflect.KClass

@FragmentScope
@GraphExtension(scope = FragmentScope::class, bindingContainers = [FragmentModule::class])
interface FragmentGraph {
    val fragment: Fragment?

    @ContributesTo(ActivityScope::class)
    @GraphExtension.Factory
    fun interface Factory {
        fun createFragmentGraph(@Provides currentFragment: KClass<out Fragment>): FragmentGraph
    }
}

@BindingContainer
object FragmentModule {
    @Provides
    @FragmentScope
    private fun fragment(
        currentFragment: KClass<out Fragment>,
        fragmentMap: Map<KClass<out Fragment>, Provider<Fragment>>,
    ): Fragment? {
        val provider = fragmentMap[currentFragment]

        return provider?.invoke()
    }

    @Provides
    fun provideNonNullVersionOfFragment(fragment: Fragment?): Fragment {
        return fragment!!
    }
}