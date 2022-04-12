package neatlin.alternativeNumberTypeNames
// Signed integers
/** neatlin.i8 (-128 «» 127) */
typealias i8 = Byte
/** neatlin.i16 (-32,768 «» 32,767) */
typealias i16 = Short
/** neatlin.i32 (-2,147,483,648 «» 2,147,483,647) */
typealias i32 = Int
/** neatlin.i64 (-9,223,372,036,854,775,808 «» 9,223,372,036,854,775,807) */
typealias i64 = Long

// Unsigned integers
/** neatlin.u8 (0 «» 255) */
typealias u8 = UByte
/** neatlin.u16 (0 «» 65,535) */
typealias u16 = UShort
/** neatlin.u32 (0 «» 4,294,967,295) */
typealias u32 = UInt
/** neatlin.u64 (0 «» 18,446,744,073,709,551,615) */
typealias u64 = ULong

// Floats
/** neatlin.f32 (1.4E-45 «» 3.4028235E38) */
typealias f32 = Float
/** neatlin.f64 (4.9E-324 «» 1.7976931348623157E308) */
typealias f64 = Double

fun Number.toi8() = this.toByte()
fun Number.toi16() = this.toShort()
fun Number.toi32() = this.toInt()
fun Number.toi64() = this.toLong()

// Converts to higher signed integer first to number loss because the maximum of neatlin.u8 is higher than neatlin.i8
// The intermediate toi?() call is needed because toU?() can't be called on the Number type.
fun Number.toU8() = this.toi16().toUByte()
fun Number.toU16() = this.toi32().toUShort()
fun Number.toU32() = this.toi64().toUInt()
// fun Number.toU64() won't work due to loss