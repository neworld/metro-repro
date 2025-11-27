package lt.neworld.mrepro.shared

import dev.zacsweers.metro.BindingContainer
import dev.zacsweers.metro.ContributesBinding
import dev.zacsweers.metro.Inject
import lt.neworld.mrepro.di.ApplicationScope

interface MainDep

@Inject
@ContributesBinding(ApplicationScope::class)
class MainDepImpl(
    val dep: Dep6
) : MainDep