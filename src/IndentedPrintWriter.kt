import java.io.PrintWriter
import java.io.Writer

class IndentedPrintWriter(writer: Writer): PrintWriter(writer) {

    var indent = 0

    override fun print(s: String?) {

    }


}