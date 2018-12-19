package com.example.lintchecks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass
import java.util.*

class MyDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
                "MyDetector",
                "",
                "",
                MY_CATEGORY, DEFAULT_PRIORITY, Severity.ERROR,
                Implementation(MyDetector::class.java, EnumSet.of(Scope.JAVA_FILE))
        )
    }

    override fun getApplicableUastTypes() = listOf(UClass::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                if (node.fields.isEmpty()) {
                    return
                }
                println(node.name)
                node.fields.forEach { field ->
                    println(" * ${field.name}")
                    field.annotations.forEach { println("   - ${it.qualifiedName}") }
                }
                println()
            }
        }
    }
}