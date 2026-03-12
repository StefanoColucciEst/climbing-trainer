plugins {
    base
}

val isWindows = System.getProperty("os.name").lowercase().contains("windows")
val npmCmd = if (isWindows) listOf("cmd", "/c", "npm") else listOf("npm")

val npmInstall by tasks.registering(Exec::class) {
    workingDir = projectDir
    commandLine(npmCmd + "install")
    inputs.file("package.json")
    outputs.dir("node_modules")
}

val npmBuild by tasks.registering(Exec::class) {
    dependsOn(npmInstall)
    workingDir = projectDir
    commandLine(npmCmd + listOf("run", "build"))
    inputs.dir("src")
    inputs.file("package.json")
    inputs.file("vite.config.ts")
    outputs.dir("dist")
}

tasks.named("build") {
    dependsOn(npmBuild)
}

tasks.named("clean") {
    doLast {
        delete("dist")
        delete("node_modules")
    }
}
