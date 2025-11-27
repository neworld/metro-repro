package lt.neworld.mrepro.shared

import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

interface Dep1

@Inject
@ContributesBinding(ApplicationScope::class)
class Dep1Impl : Dep1