import Collector.ClassInfo;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class CuPrinter {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("ReversePolish.java");

        // parse the file
        CompilationUnit cu = JavaParser.parse(in);

        List<ClassInfo> classes = new ArrayList<>();


        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
    }
}