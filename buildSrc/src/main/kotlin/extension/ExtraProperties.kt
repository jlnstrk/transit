import org.gradle.api.plugins.ExtraPropertiesExtension

fun <T> ExtraPropertiesExtension.getOrNull(name: String): T? {
    if (has(name)) {
        return get(name) as? T
    }
    return null
}