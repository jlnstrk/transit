import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import com.tschuchort.compiletesting.symbolProcessorProviders
import de.jlnstrk.transit.client.hci.codegen.HciModelCodegenProcessorProvider
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.extension
import kotlin.streams.asSequence

fun main() {

    val file = File(System.getProperty("user.dir")).resolve("client/client-hci/model-compat/src/main/kotlin")
    val files = Files.walk(file.toPath())
        .asSequence()
        .filter { it.extension == "kt" }
        .map(Path::toFile)
        .toList()

    val sourceFiles = files.map(SourceFile::fromPath)
        .toList()

    val compilation = KotlinCompilation().apply {
        sources = sourceFiles
        symbolProcessorProviders = listOf(HciModelCodegenProcessorProvider())
    }
    compilation.compile()

}