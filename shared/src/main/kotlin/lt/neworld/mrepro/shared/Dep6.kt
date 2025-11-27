package lt.neworld.mrepro.shared

import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

interface Dep6

@Inject
@ContributesBinding(ApplicationScope::class)
class Dep6Impl(val dep1: Dep1, val dep2: Dep2, val dep3: Dep3, val dep4: Dep4, val dep5: Dep5) : Dep6