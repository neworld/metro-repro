plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")

    // Apply the Application plugin to add support for building an executable JVM application.
    application
    id("dev.zacsweers.metro")
}
dependencies {
    implementation(project(":di"))
    implementation(project(":shared"))
    implementation(project(":features:feature0"))
    implementation(project(":features:feature1"))
    implementation(project(":features:feature2"))
}

application {
    // Define the Fully Qualified Name for the application main class
    // (Note that Kotlin compiles `App.kt` to a class with FQN `com.example.app.AppKt`.)
    mainClass = "lt.neworld.mrepro.app.AppKt"
}

metro {
    debug.set(true)
    reportsDestination.set(layout.buildDirectory.dir("metro/reports"))
    enableFullBindingGraphValidation.set(true)
}
