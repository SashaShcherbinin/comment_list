plugins {
    id(libs.plugins.common.android.library.module)
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
}

android {
    namespace = "base.database"
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.bundles.koin.android)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}
