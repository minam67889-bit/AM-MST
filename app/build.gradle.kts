plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "io.amtunnel.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.amtunnel.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = false
            // Release signing is configured from CI secrets; falls back to debug signing.
            val storePath = System.getenv("AMTUNNEL_KEYSTORE")
            if (!storePath.isNullOrBlank()) {
                signingConfig = signingConfigs.create("ci") {
                    storeFile = file(storePath)
                    storePassword = System.getenv("AMTUNNEL_KEYSTORE_PASSWORD")
                    keyAlias = System.getenv("AMTUNNEL_KEY_ALIAS")
                    keyPassword = System.getenv("AMTUNNEL_KEY_PASSWORD")
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    lint {
        abortOnError = false
    }

    // The BD NET client binaries (libxdnstt.so, libtun2socks.so) are copied in
    // by CI before the build; they must stay uncompressed so the app can exec
    // them straight out of nativeLibraryDir.
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    implementation(project(":core"))
}
