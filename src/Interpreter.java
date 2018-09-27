//Alexander Urbanyak
//CS4308(01)
//worked with Jason Walters - student in Dr. North's online CS4308 class
//Jason Walters assisted with testing

import java.io.FileNotFoundException;

public class Interpreter
{

    public static void main(String[] args)
    {
        try
        {
            Parser p = new Parser("test1.jl");
            Program prog = p.parse();
            prog.execute();
            //LexicalAnalyzer lex = new LexicalAnalyzer("test1.jl");
            //lex.printLex(); //print tokens and lexemes of the julia file
            //Memory.displayMemory(); // to see results of assignment statements
        }
        catch (ParserException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (LexicalException e)
        {
            e.printStackTrace();
        }
    }
}