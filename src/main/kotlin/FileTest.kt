import java.io.File
import java.nio.file.FileSystem
import java.nio.file.FileSystems
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name
import kotlin.io.path.pathString

class FileTest {

    private val fileSystem : FileSystem = FileSystems.getDefault()
    fun getFiles() : List<File> {
        val files = mutableListOf<File>()
        for (path in fileSystem.rootDirectories) {
            for (p in path.listDirectoryEntries()) {
                files.add(p.toFile())
            }
        }
        return files
    }

    fun getInnerFiles(file : File) : List<File> {
        val files = mutableListOf<File>()
        for (f in file.listFiles()!!) {
            files.add(f)
        }
        return files
    }

}