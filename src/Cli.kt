
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.apache.commons.cli.*

class Cli(val args: Array<String>) {

    private val options = Options()

    init {
        options.addOption("h", "help", false, "show help")
        options.addRequiredOption("i", "input", true, "input file or directory")
        options.addOption("o", "output", true, "output path")
        options.addOption("d", "debug", false, "generate debug strings")
    }

    fun parse() {

        val cliParser = DefaultParser()

        val cmd: CommandLine?
        try {
            cmd = cliParser.parse(options, args)

            if (cmd!!.hasOption("h")) {
                help()
            } else {
                //cli values
                val inputFileName = cmd.getOptionValue("i")!!
                val outputFileName = cmd.getOptionValue("o")
                val debug = cmd.hasOption("d")

                //parser
                val stream = CharStreams.fromFileName(inputFileName)
                val lexer = estadoLexer(stream)
                val tokens = CommonTokenStream(lexer)
                val parser = estadoParser(tokens)
                parser.removeErrorListeners()
                parser.addErrorListener(ThrowingErrorListener.INSTANCE)
                val context = parser.file()

                //compile
                val topLevelStates = context.accept(TopLevelStateVisitor())


            }

        } catch (e: ParseException) {
            help()
        } catch (e: RuntimeException) {
            e.printStackTrace()
        }

    }

    private fun help() {
        // This prints out some help
        HelpFormatter().printHelp("estado -i input <path> [-o output <path>] [-d]", options)
    }
}

