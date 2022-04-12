package neatlin.processes

import java.io.InputStream

/**
 * Dataclass containing the response from the process and the errors.
 *
 * Both are gotten from an [InputStream] by reading the bytes and using those to create a [String].
 */
data class ShellResponse(val response: String, val errors: String)
