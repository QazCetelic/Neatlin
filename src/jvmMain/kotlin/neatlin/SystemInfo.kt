package neatlin

object SystemInfo {
    operator fun get(key: String): String? = System.getProperty(key)
    operator fun set(key: String, value: String): String? = System.setProperty(key, value)
}