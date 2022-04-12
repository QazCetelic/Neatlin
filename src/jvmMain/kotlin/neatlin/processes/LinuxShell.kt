package neatlin.processes

/**
 * Utility functions for interacting with the Linux shell
 */
object LinuxShell {
    /**
     * Execute a command
     * @param command [String] containing the command to execute
     */
    fun execute(command: String): ShellResponse {
        val process = ProcessBuilder("sh", "-c", " $command").start()
        return ShellResponse(process.response, process.errors)
    }

    /**
     * Uses sudo to execute a command as root using the provided password
     * @param command [String] containing the command to execute
     * @param password The password for the root user
     */
    fun executeAsRoot(command: String, password: CharArray): ShellResponse {
        // Space in front of echo is to exclude commands from the shell's history
        val pass = buildString {
            for (char in password) append(char)
        }
        val process = ProcessBuilder("sh", "-c", " echo $pass | sudo -S $command").start()
        return ShellResponse(process.response, process.errors)
    }

    // TODO consider
    /*
    fun newExecuteAsRoot(command: String, password: String): ShellResponse {
        // Space in front of echo is to exclude commands from the shell's history
        val process = ProcessBuilder("sudo", "-S").start()
        process.reply(password)
        process.reply(command)
        return ShellResponse(process.response, process.errors)
    }
     */
}