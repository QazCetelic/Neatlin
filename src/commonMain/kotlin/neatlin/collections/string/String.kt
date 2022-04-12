package neatlin.collections.string

import neatlin.applyIf
import neatlin.iterator

/**
 * Takes the text from a string within int ranges
 */
operator fun String.get(range: IntRange): String {
    return this.substring(range)
}

// OPERATORS

operator fun String.minus(otherString: String): String {
    return removeSuffix(otherString)
}

operator fun String.times(times: Number) = buildString {
    for (i in times.toInt()) {
        append(this)
    }
}
operator fun Number.times(string: String): String = string.times(this)

// This is kinda pointless
operator fun String.div(number: Number): String {
    return chunked(number.toInt())[0]
}

fun String.reduceWhiteSpace(
    trim: Boolean = true,
    removeDuplicateNewlines: Boolean = false,
    reduceAfterOrBeforeNewline: Boolean = true,
    reduceTabs: Boolean = true,
    removeDuplicateSpaces: Boolean = true,
    removeDuplicateWhiteSpace: Boolean = true,
    removeNewLines: Boolean = false,
): String {
    return this
        // Reduce whitespace at the start and end
        .applyIf(trim) { trim() }

        // Reduces duplicate newlines
        .applyIf(removeDuplicateNewlines && !removeNewLines) {
            replace(Regex("\\n+"), "\n").replace(Regex("\\r+"), "\r")
        }

        // Reduces whitespace in front or after a newline
        .applyIf(reduceAfterOrBeforeNewline) {
            replace(Regex("( |\t)+\\n"), "\n").replace(Regex("\\n +"), "\n")
        }

        // Replace tabs with spaces, regex prevents it from activating a newline.
        // The groupvalues part prevents it from removing the first character.
        .applyIf(reduceTabs) { replace(Regex("(.|\\t| )\\t")) { "${it.groupValues.first()} " } }

        // Remove duplicate spaces
        .applyIf(removeDuplicateSpaces && !removeDuplicateWhiteSpace) { replace(Regex(" {2,}"), " ") }

        // Replace newlines
        .applyIf(removeNewLines) { replace("\n", " ") }

        // Reduces duplicate whitespace
        .applyIf(removeDuplicateWhiteSpace) { replace(Regex("( |\t){2,}"), " ") }

        .apply { trim() }
}

fun String.isUpperCase() = this.all { it.isUpperCase() }
fun String.isLowerCase() = this.all { it.isLowerCase() }