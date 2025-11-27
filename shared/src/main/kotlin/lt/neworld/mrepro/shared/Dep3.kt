package lt.neworld.mrepro.shared

import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

interface Dep3

@Inject
@ContributesBinding(ApplicationScope::class)
class Dep3Impl(val dep1: Dep1, val dep2: Dep2) : Dep3