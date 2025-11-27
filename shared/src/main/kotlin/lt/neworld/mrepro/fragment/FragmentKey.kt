package lt.neworld.mrepro.fragment

import dev.zacsweers.metro.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class FragmentKey(val kclass: KClass<out Fragment>)
