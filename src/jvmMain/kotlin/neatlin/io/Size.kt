package neatlin.io

import java.io.File
import java.math.BigDecimal

//JVM ONLY

/**
 * Function to recursively get file size's and format it too
 */
fun File.size(unit: ByteUnit = ByteUnit.b, decimals: Int? = 2): BigDecimal {
    // Uses BigDecimal because the neatlin.file sizes are counted in bytes and those can add up quickly
    var totalSize = (0).toBigDecimal()
    for (file in this.walk()) {
        totalSize += file.length().toBigDecimal()
    }
    // Rounds it when decimals is used
    return if (decimals != null) (totalSize / unit.bytes).setScale(decimals)
    else totalSize / unit.bytes

}

/**
 * Check if a neatlin.file is empty
 */
fun File.isEmpty(): Boolean = this.length() == 0L

/**
 * Returns the size as a Pair with the best fitting ByteUnit and how large the neatlin.file is in those chosen units
 * Useful for user interfaces
 * @return Pair<BigDecimal, ByteUnit>
 */
fun File.autoSizePair(decimals: Int = 2): Pair<BigDecimal, ByteUnit> {
    val size = this.size(ByteUnit.b, null)
    lateinit var lastByteUnit: ByteUnit
    for (byteUnit in listOf(ByteUnit.KiB, ByteUnit.MiB, ByteUnit.GiB, ByteUnit.TiB)) {
        lastByteUnit = byteUnit
        if ((size / byteUnit.bytes) < 1024.toBigDecimal()) break
    }
    return Pair((size / lastByteUnit.bytes), lastByteUnit)
}

/**
 * Use this for displaying file sizes in user interfaces
 * @return [String] The size of the file starting with the amount and ending with the unit
 */
fun File.displaySize(): String {
    val pair = this.autoSizePair()
    return "${pair.first}${pair.second}"
}

/**
 * Supports decimal and binary but only up to Terabyte and Tebibyte
 */
enum class ByteUnit(val bytes: BigDecimal) {
    // This is a bit messy but Kotlin doesn't support numbers that large
    // Decimal: Metric
    KB((1000).toBigDecimal()),
    MB((1000*1000).toBigDecimal()),
    GB((1000*1000*1000).toBigDecimal()),
    TB((1000*1000*1000).toBigDecimal()*(1000).toBigDecimal()),

    // Binary: IEC
    KiB((1024).toBigDecimal()),
    MiB((1024*1024).toBigDecimal()),
    GiB((1024*1024*1024).toBigDecimal()),
    TiB((1024*1024*1024).toBigDecimal()*(1024).toBigDecimal()),

    // Standard byte
    b((1).toBigDecimal())
}