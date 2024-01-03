package com.wyekings.doreamon

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

/**
 *  @author wye on 1/12/23
 */

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal val Project.libsCompileSdk: Int
    get() = libs.findVersion("compileSdk").get().toString().toInt()

internal val Project.libsMinSdk: Int
    get() = libs.findVersion("minSdk").get().toString().toInt()

internal val Project.libsTargetSdk: Int
    get() = libs.findVersion("targetSdk").get().toString().toInt()

internal val Project.libsVersionName: String
    get() = libs.findVersion("versionName").get().toString()

internal val Project.libsVersionCode: Int
    get() = libs.findVersion("versionCode").get().toString().toInt()

internal val Project.libsCompileJVM: String
    get() = libs.findVersion("compileJVM").get().toString()

internal val Project.libsCompileJVMJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libsCompileJVM)

internal val Project.libsBuildJVM: String
    get() = libs.findVersion("buildJVM").get().toString()

internal val Project.libsBuildJVMJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libsCompileJVM)

internal val Project.libsComposeCompiler: String
    get() = libs.findVersion("compose-compiler").get().toString()

internal val Project.libsComposeBom: Provider<MinimalExternalModuleDependency>
    get() = libs.findLibrary("compose-bom").get()

internal val Project.libsRoomRuntime: String
    get() = libs.findVersion("room-runtime").get().toString()
internal val Project.libsRoomKtx: String
    get() = libs.findVersion("room-ktx").get().toString()
internal val Project.libsRoomCompiler: String
    get() = libs.findVersion("room-compiler").get().toString()

internal val Project.libsEspresso: Provider<MinimalExternalModuleDependency>
    get() = libs.findLibrary("androidx-test-espresso-core").get()

internal val Project.libsTestExt: Provider<MinimalExternalModuleDependency>
    get() = libs.findLibrary("androidx-test-ext").get()

internal val Project.libsJunit4: Provider<MinimalExternalModuleDependency>
    get() = libs.findLibrary("junit4").get()


