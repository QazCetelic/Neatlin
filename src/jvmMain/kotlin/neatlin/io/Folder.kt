package neatlin.io

import java.io.File
import java.io.FileFilter
import java.io.FilenameFilter
import java.nio.file.Path

/**
 * Type safe folder that doesn't return null when listing files
 */
class Folder: File {
    constructor(path: String):  super(path)
    constructor(path: Path):    super(path.toString())
    constructor(file: File):    super(file.toURI())
    init {
        if (!super.isDirectory()) throw Exception("Not a folder")
    }

    override fun isDirectory()                  : Boolean       = true
    override fun listFiles()                    : Array<File>   = super.listFiles()!!
    override fun list()                         : Array<String> = super.list()!!
    override fun list(filter: FilenameFilter)   : Array<String> = super.list(filter)!!
    override fun listFiles(filter: FileFilter?) : Array<File>   = super.listFiles(filter)!!
}