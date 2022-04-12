package neatlin.io

import java.io.File
import javax.swing.filechooser.FileSystemView

/**
 * Common locations needed for getting files
 */
object Locations {
    // TODO it might be better to split this into a separate util lib, one focused on desktop stuff
    /**
     * The user home folder that contains program configs, downloads and other files.
     */
    val HOME: File by lazy { File(System.getProperty("user.home")) }

    /**
     * Where the documents of the user are stored
     */
    val DOCUMENTS: File by lazy { File(FileSystemView.getFileSystemView().defaultDirectory.path) }

    /**
     * Where the downloads of the user are stored
     */
    val DOWNLOADS: File by lazy { HOME/"Downloads" }
}