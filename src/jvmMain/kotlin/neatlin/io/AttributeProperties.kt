package neatlin.io

import java.io.File

var File.executable: Boolean
    get() {
        return this.canExecute()
    }
    set(value) {
        this.setExecutable(value)
    }

var File.writable: Boolean
    get() {
        return this.canWrite()
    }
    set(value) {
        this.setWritable(value)
    }

var File.readable: Boolean
    get() {
        return this.canRead()
    }
    set(value) {
        this.setReadable(value)
    }

var File.lastModified: Long
    get() {
        return this.lastModified()
    }
    set(value) {
        this.setLastModified(value)
    }