import com.wyekings.doreamon.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDestinationsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                // https://developer.android.com/build/migrate-to-ksp
                apply("com.google.devtools.ksp")
            }

            dependencies {
                "implementation"(libs.findLibrary("destinations").get())
                "ksp"(libs.findLibrary("destinations.ksp").get())
            }
        }
    }
}