plugins {
    base
}

val npmInstall by tasks.registering(Exec::class) {
    workingDir = projectDir
    commandLine("cmd", "/c", "npm", "install")
    inputs.file("package.json")
    outputs.dir("node_modules")
}

val npmBuild by tasks.registering(Exec::class) {
    dependsOn(npmInstall)
    workingDir = projectDir
    commandLine("cmd", "/c", "npm", "run", "build")
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
