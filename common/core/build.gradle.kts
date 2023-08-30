@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.common.core"
}