package lt.neworld.mrepro.feature1

import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.FragmentScope
import lt.neworld.mrepro.fragment.Fragment
import lt.neworld.mrepro.fragment.FragmentKey
import lt.neworld.mrepro.shared.AllDeps
import lt.neworld.mrepro.shared.Dep1
import lt.neworld.mrepro.shared.Dep2
import lt.neworld.mrepro.shared.Dep3
import lt.neworld.mrepro.shared.Dep4
import lt.neworld.mrepro.shared.Dep5
import lt.neworld.mrepro.shared.Dep6
import lt.neworld.mrepro.shared.Dep7
import lt.neworld.mrepro.shared.Dep8
import lt.neworld.mrepro.shared.InterfaceDep
import lt.neworld.mrepro.shared.MainDep

@Inject
@ContributesIntoMap(FragmentScope::class)
@FragmentKey(Feature167Fragment::class)
class Feature167Fragment(
    val dep: MainDep,
): Fragment()