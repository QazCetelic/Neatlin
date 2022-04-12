package neatlin.naming_convention

import neatlin.collections.string.isLowerCase
import neatlin.collections.string.isUpperCase

/**
 * Returns the **naming convention**,
 * the set of rules for choosing the character sequence to be used for identifiers which denote variables, types,
 * functions, and other entities in source code and documentation.
 */
val String.case: Case?
    get() {
        if (isNotBlank()) {
            val validChars = all {
                it.isLetter() || it == '-' || it == '_' || it == '|' || it == '.'
            }
            if (validChars && first().isLetter() && last().isLetter()) {
                if (all { it.isLetter() }) when {
                    isLowerCase()                                       -> return Case.FLAT_CASE
                    isUpperCase()                                       -> return Case.UPPER_FLAT_CASE
                    first().isLowerCase() && any { it.isUpperCase() }   -> return Case.CAMEL_CASE
                    first().isUpperCase() && any { it.isLowerCase() }   -> return Case.PASCAL_CASE
                }
                else when {
                    all { it.isLetter() || it == '_' } -> when {
                        all { it.isLowerCase() || it == '_' }           -> return Case.SNAKE_CASE
                        all { it.isUpperCase() || it == '_' }           -> return Case.SCREAMING_SNAKE_CASE
                        first().isLowerCase() && any { it.isUpperCase() } && any { it.isLowerCase() }
                                                                        -> return Case.CAMEL_SNAKE_CASE
                        first().isUpperCase() && any { it.isUpperCase() } && any { it.isLowerCase() }
                                                                        -> return Case.PASCAL_SNAKE_CASE
                    }
                    all { it.isLetter() || it == '-' } -> when {
                        all { it.isLowerCase() || it == '-' }           -> return Case.KEBAB_CASE
                        all { it.isUpperCase() || it == '-' }           -> return Case.SCREAMING_KEBAB_CASE
                        first().isUpperCase() && any { it.isUpperCase() } && any { it.isLowerCase() }
                                                                        -> return Case.TRAIN_CASE
                    }
                    all { (it.isLetter() && it.isLowerCase()) || it == '|' }
                                                                        -> return Case.DONER_CASE
                    all { it.isLetter() || it == '.'} && ".." !in this  -> return Case.DOT_CASE
                }
            }
        }
        return null
    }

enum class Case {
    FLAT_CASE,              // twowords
    UPPER_FLAT_CASE,        // TWOWORDS
    CAMEL_CASE,             // twoWords
    PASCAL_CASE,            // TwoWords
    SNAKE_CASE,             // two_words
    SCREAMING_SNAKE_CASE,   // TWO_WORDS
    CAMEL_SNAKE_CASE,       // two_Words
    PASCAL_SNAKE_CASE,      // Two_Words
    KEBAB_CASE,             // two-words
    SCREAMING_KEBAB_CASE,   // TWO-WORDS
    TRAIN_CASE,             // Two-Words
    DONER_CASE,             // two|words
    DOT_CASE,               // two.words
}