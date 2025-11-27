#!/usr/bin/env kotlin

import java.io.File

fun <T : Any> T?.orError(errorMessage: String): T {
    return this ?: error(errorMessage)
}

val template = """
    package {{packageName}}
    
    import dev.zacsweers.metro.ContributesIntoMap
    import dev.zacsweers.metro.Inject
    import lt.neworld.mrepro.di.FragmentScope
    import lt.neworld.mrepro.fragment.Fragment
    import lt.neworld.mrepro.fragment.FragmentKey
    import lt.neworld.mrepro.shared.AllDeps
    import lt.neworld.mrepro.shared.Dep1
    import lt.neworld.mrepro.shared.Dep2
    import lt.neworld.mrepro.shared.Dep3
    import lt.neworld.mrepro.shared.Dep4
    import lt.neworld.mrepro.shared.Dep5
    import lt.neworld.mrepro.shared.Dep6
    import lt.neworld.mrepro.shared.Dep7
    import lt.neworld.mrepro.shared.Dep8
    import lt.neworld.mrepro.shared.InterfaceDep
    import lt.neworld.mrepro.shared.MainDep
    
    @Inject
    @ContributesIntoMap(FragmentScope::class)
    @FragmentKey({{className}}::class)
    class {{className}}(
        val dep: MainDep,
    ): Fragment()
""".trimIndent()

data class TemplateVariables(
    val packageName: String,
    val className: String,
)

fun generate(vars: TemplateVariables): String {
    return template
        .replace("{{packageName}}", vars.packageName)
        .replace("{{className}}", vars.className)
}

val workingDir = File(".")

if (!workingDir.resolve("generate.main.kts").exists()) {
    error("Can not find generate.main.kts in working dir. Stopping to prevent accidental deletion.")
}

val moduleDirs = (0..2)
    .map { "features/feature$it/src/main/kotlin/" }
    .map { workingDir.resolve(it) }

println("Cleaning old generated files...")
moduleDirs.flatMap { it.listFiles().orError("$it was not directory").toList() }.forEach {
    println("delete: ${it.absolutePath}")
    it.deleteRecursively()
}

println("Generating files")

moduleDirs.forEachIndexed { index, moduleDir ->
    val dir = moduleDir.resolve("lt/neworld/mrepro/feature$index/")

    for (i in 0..99) {
        val suffix = (index * 100 + i).toString().padStart(3, '0')
        val className = "Feature${suffix}Fragment"
        val content = generate(
            TemplateVariables(
                packageName = "lt.neworld.mrepro.feature$index",
                className = "Feature${suffix}Fragment",
            )
        )

        val file = dir.resolve("$className.kt")
        file.parentFile.mkdirs()
        file.writeText(content)
    }
}