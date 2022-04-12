package neatlin.naming_convention

import neatlin.collections.string.plusAssign
import neatlin.naming_convention.Case.*

/**
 * Reformats for a specific case, this is done so capital letters are retained.
 */
fun Case.reformatString(string: String, lowercase: Boolean = true): String {
    return when (this) {
        FLAT_CASE -> return string
        UPPER_FLAT_CASE -> return if (lowercase) string.lowercase() else string

        CAMEL_CASE -> reformat1(string)
        PASCAL_CASE -> reformat1(string)

        SNAKE_CASE -> reformat2(string, '_')
        SCREAMING_SNAKE_CASE -> reformat2(string, '_').let { if (lowercase) it.lowercase() else it }
        CAMEL_SNAKE_CASE -> reformat2(string, '_', lowercase = true) // TODO
        PASCAL_SNAKE_CASE -> reformat2(string, '_', lowercase = true) // TODO

        KEBAB_CASE -> reformat2(string, '-')
        SCREAMING_KEBAB_CASE -> reformat2(string, '-').let { if (lowercase) it.lowercase() else it }
        TRAIN_CASE -> reformat2(string, '-', lowercase = true)

        DONER_CASE -> reformat2(string, '|')
        DOT_CASE -> reformat2(string, '.', capitalize = true)
    }
}
fun String.reformat(): String = case?.reformatString(this) ?: this

// CAMEL_CASE, PASCAL_CASE
internal fun reformat1(string: String): String {
    val sb = StringBuilder()
    val parts = mutableListOf<String>()
    for (i in string.indices) {
        if ( string.getOrElse(i + 1) { ' ' }.isUpperCase() ) {
            sb += string[i].lowercase()
            parts += sb.toString()
            sb.clear()
        }
        else {
            sb += string[i]
        }
    }
    parts += sb.toString()
    return (parts.map { it.lowercase() }).joinToString(separator = " ")
}

// KEBAB_CASE, SCREAMING_KEBAB_CASE
internal fun reformat2(string: String, char: Char, lowercase: Boolean = false, capitalize: Boolean = false): String {
    return if (lowercase) {
        string.split(char).map { part ->
            part.replaceFirstChar { it.lowercase() }
        }.joinToString(separator = " ")
    }
    else string.replace("$char", " ")
}

/*
fun String.reformat(case: Case? = this.case, capitalize: Boolean = true): String {
    if (case == null) return this

    if (case == UPPER_FLAT_CASE)
    val parts = caseSplit(case)
        .applyIf(capitalize) { map { it.replaceFirstChar { it.uppercase() } } }
    when (case) {
        FLAT_CASE
    }
}
 */

fun String.caseSplit(case: Case? = this.case): List<String> {
    if (isBlank()) return listOf(this)
    return when (case) {
        // twowords -> ["twowords"]
        FLAT_CASE -> listOf(this)
        // TWOWORDS -> ["twowords"]
        UPPER_FLAT_CASE -> listOf(lowercase())
        // twoWords -> ["two", "words"] & TwoWords -> ["two", "words"]
        CAMEL_CASE, PASCAL_CASE -> let {
            val parts = mutableListOf<String>()
            val sb = StringBuilder()
            sb += first().let { if (case == PASCAL_CASE) it.lowercaseChar() else it }
            for (c in this.drop(1)) {
                if (c.isUpperCase()) {
                    sb += c.lowercase()
                    parts += sb.toString()
                    sb.clear()
                }
                else sb += c
            }
            return parts.toList()
        }
        // two_words -> ["two", "words"]
        SNAKE_CASE -> split('_')
        // TWO_WORDS -> two_words -> ["two", "words"]
        SCREAMING_SNAKE_CASE -> lowercase().split('_')
        // two_Words -> ["two", "Words"] -> ["two", "words"]
        CAMEL_SNAKE_CASE -> split('_').let {
            it.take(1) + it.drop(1).map { it.replaceFirstChar { it.lowercase() } }
        }
        // Two_Words -> ["Two", "Words"] -> ["two", "words"]
        PASCAL_SNAKE_CASE -> split('_').map { it.replaceFirstChar { it.lowercase() } }
        // two-words -> ["two", "words"]
        KEBAB_CASE -> split('-')
        // TWO-WORDS -> two-words -> ["two", "words"]
        SCREAMING_KEBAB_CASE -> lowercase().split('-')
        // Two-Words -> ["Two", "Words"]
        TRAIN_CASE -> split('-').map { it.replaceFirstChar { it.lowercase() } }
        // two|words -> ["two", "words"]
        DONER_CASE -> split('|')
        // two.words -> ["two", "words"]
        DOT_CASE -> split('.')

        null -> listOf(this)
    }
}

/**
 * Turns a package name into a [List].
 * `"neatlin.naming_convention.reformat".reformatPackageName()` == listOf(listOf("neatlin"), listOf("naming", "convention"), listOf("reformat"))
 * @return List<List`<String>`> - A list containing lists split by the dots and each of those lists split by the underscores.
 */
fun String.reformatPackageName(): List<List<String>> {
    if (".." in this || !first().isLetter() || last() == '.') throw IllegalArgumentException()
    return this
        .split('.')
        .map {
            it.split('_').filter { it.isNotBlank() }
        }
}