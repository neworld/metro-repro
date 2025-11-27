package lt.neworld.mrepro.shared

import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

interface Dep2

@Inject
@ContributesBinding(ApplicationScope::class)
class Dep2Impl(val dep1: Dep1) : Dep2