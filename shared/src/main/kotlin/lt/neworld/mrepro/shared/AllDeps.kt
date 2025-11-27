package lt.neworld.mrepro.shared

import dev.zacsweers.metro.Inject

@Inject
class AllDeps(
    val dep1: Dep1,
    val dep2: Dep2,
    val dep3: Dep3,
    val dep4: Dep4,
    val dep5: Dep5,
    val dep6: Dep6,
    val dep7: Dep7,
    val dep8: Dep8,
    val interfaceDep: InterfaceDep,
)
