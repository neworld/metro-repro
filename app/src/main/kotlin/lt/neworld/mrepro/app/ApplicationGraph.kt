package lt.neworld.mrepro.app

import dev.zacsweers.metro.DependencyGraph
import lt.neworld.mrepro.di.ApplicationScope

@ApplicationScope
@DependencyGraph(scope = ApplicationScope::class)
interface ApplicationGraph {
    val app: App

}