import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodPrinter {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("ReversePolish.java");

        // parse it
        CompilationUnit cu = JavaParser.parse(in);

        // visit and print the methods names
        cu.accept(new MethodVisitor(), null);

        List<String> methodNames = new ArrayList<>();
        VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
        methodNameCollector.visit(cu, methodNames);
        methodNames.forEach(n-> System.out.println("Method Name Collected : " + n));
    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this
             CompilationUnit, including inner class methods */
            System.out.println("Method Name Printed: " + n.getName());
            super.visit(n, arg);
        }
    }

    private static class MethodNameCollector extends VoidVisitorAdapter<List<String>>{
        @Override
        public void visit(MethodDeclaration md, List<String> collector){
            super.visit(md,collector);
            collector.add(md.getNameAsString());
        }
    }
}