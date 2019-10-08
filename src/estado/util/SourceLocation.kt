package estado.util

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import java.io.PrintStream

data class SourceLocation(val fileName: String, val lineNumber: Int, val column: Int) {
    companion object {
        fun fromToken(token: Token): SourceLocation {
            return SourceLocation(token.inputStream.sourceName, token.line, token.charPositionInLine)
        }
        fun fromParseContext(ctx: ParserRuleContext): SourceLocation {
            return SourceLocation(ctx.start.inputStream.sourceName, ctx.start.line, ctx.start.charPositionInLine)
        }
    }
    fun println(out: PrintStream) {
        out.println("in $fileName at $lineNumber:$column")
    }
}