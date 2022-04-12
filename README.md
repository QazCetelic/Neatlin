# Neatlin
A library filled with utility functions and other things I often use. 
So I can easily use them in every project.

## Get all indexes of every even number
```kotlin
listOf(3, 4.5, 4006L, 6F).indexesOf { it.even } // [2, 3]
```
###### Without Neatlin
```kotlin
val list = listOf(3, 4.5, 4006L, 6F)
val indexes = mutableListOf<Int>()
for (i in list.indices) {
    val num = list[i]
    val even = when (num) {
        is Byte -> num % (2).toByte() == 0
        is Short -> num % (2).toShort() == 0
        is Int -> num % 2 == 0
        is Long -> num % 2L == 0L
        is Float -> num % 2F == 0F
        is Double -> num % 2.0 == 0.0
        else -> num.toDouble() % 2.0 == 0.0
    }
    if (even) indexes += i
}
```

### Check if folder contains another file
```kotlin
file/"text.txt" in folder
```
###### Without Neatlin
```kotlin
val textFile = file/"text.txt"
textFile.exists() && textFile.toString().startsWith(folder.toString())
```

### Load an resources from inside the JAR
```kotlin
Resources.loadImage("tux.png") // Returns BufferedImage?
Resources.loadText("text.txt")
Resources.loadBytes(resourceString)
Resources.loadStream(resourceString)
```

### Run command as root
```kotlin
LinuxShell.executeAsRoot(command, password)
```

### Describe variable for debugging or logging
```kotlin
intArrayOf(1, 2, 3, 4).describe() // IntArray[4]: "[1, 2, 3, 4]"
```

### Work with processes
```kotlin
val process = ProcessBuilder("ping", "8.8.8.8").start()
val result: String = process.response
```

### Work with Zip Files
```kotlin
val zipFile = ZipFile("path/to/zip/file")

// Access ZipFile entries
val readmeZipEntry = zipFile["README.txt"] // Instead of zipFile.getEntry("README.txt")
println(readmeZipEntry?.compressedSize)

val readme: String = zipFile.getText("README.txt")
```

### Utilities for scripting
```kotlin
val file = File("Test.txt")
doSomething(file.text)
file += "Hello World"
println("Hello" in file)
file.empty()
```

### Recursively get file size using proper unit
```kotlin
File("/home/qaz/Downloads").displaySize() // "22GiB"
```

### Additional list operators
```kotlin
val list = listOf(1, 2, 3, 4, 5)
val tripleList = list * 3
// Directly compare lists
list < tripleList
// Get the index of a pattern of several elements
val index: List<IntRange> = tripleList.indexOf(listOf(3, 4))
```