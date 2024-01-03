import com.android.build.api.dsl.ApplicationExtension
import com.wyekings.doreamon.DoraemonFlavor
import com.wyekings.doreamon.configureFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationFlavorsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                configureFlavors(this) {
                    when (it) {
                        DoraemonFlavor.stage -> {}
                        DoraemonFlavor.prod -> {}
                    }
                }
            }
        }
    }
}