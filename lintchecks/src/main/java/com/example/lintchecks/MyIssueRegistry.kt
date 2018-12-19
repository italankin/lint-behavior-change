package com.example.lintchecks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Issue

const val DEFAULT_PRIORITY = 5

val MY_CATEGORY = Category.create("My Category", DEFAULT_PRIORITY)

@Suppress("unused")
class MyIssueRegistry : IssueRegistry() {
    override val api = CURRENT_API

    override val issues: List<Issue> = listOf(
            MyDetector.ISSUE
    )
}
