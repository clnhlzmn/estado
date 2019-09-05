import java.io.File
import java.io.PrintWriter
import java.io.Writer
import java.nio.charset.Charset

class IndentedPrintWriter(writer: Writer): PrintWriter(writer) {

    var indent = 0
        set(value) {
            field = value
            currentIndent = singleIndent.repeat(value)
        }
    private val singleIndent = "    "
    private var currentIndent = ""

    override fun write(s: String) {
        val indented = s.prependIndent(currentIndent)
        write(indented, 0, indented.length)
    }

    fun indent(block: IndentedPrintWriter.()->Unit) {
        indent++
        block()
        indent--
    }

}

fun File.indentedPrintWriter(charset: Charset = Charsets.UTF_8): IndentedPrintWriter =
    IndentedPrintWriter(bufferedWriter(charset))