package lt.neworld.mrepro.shared

import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

@Inject
@ContributesBinding(ApplicationScope::class)
class InterfaceDepImpl(val dep1: Dep1) : InterfaceDep