package com.zenmo.remotedev

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Update the remote dev environment.
 * Roll back in case of problems.
 *
 * Yes, it's a bit silly to do this in Kotlin instead of Python.
 */
fun main() {
    try {
        runCommand(listOf("git", "stash"))
    } catch (e: Exception) {
        throw e
    }

    try {
        runCommand(listOf("git", "pull", "--rebase"))
    } catch (e: Exception) {
        println("Rolling back changes...")
        runCommand(listOf("git", "rebase", "--abort"))
        throw e
    } finally {
        try {
            runCommand(listOf("git", "stash", "pop"))
        } catch (e: Exception) {
            println(e.message)
            // swallow error
        }
    }
}

fun runCommand(command: List<String>) {
    val process = ProcessBuilder(command)
        .redirectErrorStream(true)
        .start()

    val output = BufferedReader(InputStreamReader(process.inputStream)).use { it.readText() }
    val exitCode = process.waitFor()

    if (exitCode != 0) {
        throw RuntimeException("Command failed with exit code $exitCode: $output")
    }

    println(output)
}
