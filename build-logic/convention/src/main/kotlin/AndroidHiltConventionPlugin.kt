import com.wyekings.doreamon.libs
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                // KAPT must go last to avoid build warnings.
                // See: https://stackoverflow.com/questions/70550883/warning-the-following-options-were-not-recognized-by-any-processor-dagger-f
                // apply("org.jetbrains.kotlin.kapt")

                // https://developer.android.com/build/migrate-to-ksp
                apply("com.google.devtools.ksp")
            }

            dependencies {
                "implementation"(libs.findLibrary("hilt.android").get())
                "ksp"(libs.findLibrary("hilt.compiler").get())
//                "kspAndroidTest"(libs.findLibrary("hilt.compiler").get())
            }
//            kapt {
//                correctErrorTypes = true
//            }
        }
    }

}

/**
 * Retrieves the [kapt][org.jetbrains.kotlin.gradle.plugin.KaptExtension] extension.
 */
private val Project.kapt: KaptExtension
    get() = (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("kapt") as KaptExtension

/**
 * Configures the [kapt][org.jetbrains.kotlin.gradle.plugin.KaptExtension] extension.
 */
private fun Project.kapt(configure: Action<KaptExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("kapt", configure)
