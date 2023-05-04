import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {

    val xcf = XCFramework()
    ios {
        binaries {
            framework {
                baseName = "shared"
                xcf.add(this)
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}
