import java.io.File
import java.io.PrintWriter
import java.io.Writer
import java.nio.charset.Charset

class IndentedPrintWriter(writer: Writer): PrintWriter(writer) {

    private var indent = 0
        set(value) {
            field = value
            currentIndent = singleIndent.repeat(value)
        }
    private val singleIndent = "    "
    private var currentIndent = ""

    override fun write(c: Int) {
        throw NotImplementedError()
    }

    override fun write(buf: CharArray, off: Int, len: Int) {
        throw NotImplementedError()
    }

    override fun write(buf: CharArray) {
        throw NotImplementedError()
    }

    override fun write(s: String, off: Int, len: Int) {
        super.write(s, off, len)
    }

    override fun write(s: String) {
        val indented = s.prependIndent(currentIndent)
        write(indented, 0, indented.length)
    }

    fun indent(block: IndentedPrintWriter.()->Unit) {
        indent++
        block(this)
        indent--
    }

}

fun File.indentedPrintWriter(charset: Charset = Charsets.UTF_8): IndentedPrintWriter =
    IndentedPrintWriter(bufferedWriter(charset))