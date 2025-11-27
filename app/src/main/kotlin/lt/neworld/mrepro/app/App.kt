package lt.neworld.mrepro.app

import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.createGraph
import lt.neworld.mrepro.feature0.Feature000Fragment
import kotlin.time.measureTime

@Inject
class App(
    activityGraphFactory: ActivityGraph.Factory,
) {
    private val activity = activityGraphFactory.createActivity().activity

    fun createFragment() {
        val time = measureTime {
            val fragment = activity.createFragment<Feature000Fragment>()
            check(fragment.name() == "Feature000Fragment") {
                "Something wrong with fragment: ${fragment.name()}"
            }
        }

        println("Fragment was created in ${time}ms")
    }
}

fun main() {
    val app = createGraph<ApplicationGraph>().app
    app.createFragment()
}