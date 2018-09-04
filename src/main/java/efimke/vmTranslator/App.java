package efimke.vmTranslator;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        Parser parser = new Parser(args[0]);
        CodeWriter codeWriter = new CodeWriter(args[0]);

        while (parser.hasMoreCommands()) {
            parser.advance();
            switch (parser.getCommandType()) {
                case C_ARITHMETIC:
                    codeWriter.writeArithmetic(parser.getCurrentCommand());
                    break;
                case C_PUSH:
                case C_POP:
                    codeWriter.writePushPop(parser.getCommandType(), parser.getArg1(), parser.getArg2());
                    break;
            }
        }
        parser.close();
        codeWriter.close();
    }
}