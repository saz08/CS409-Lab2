
import java.io.FileInputStream;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import jdk.nashorn.internal.ir.ExpressionStatement;


public class EasyCategory {

    static int m_nStatementCount;

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("ReversePolish.java");

        CompilationUnit cu;
        try {
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }
        new ClassDiagramVisitor().visit(cu, null);
    }

    /**
     * Relationships between classes
     */
    private static class ClassDiagramVisitor extends VoidVisitorAdapter {

        public void visit(ClassOrInterfaceDeclaration n, Object arg){
            System.out.println("Class Name: " + n.getName());
            System.out.println("Class Implements: ");

            for (ClassOrInterfaceType coi : n.getImplementedTypes()) {
                System.out.println(coi.getName());
            }
            super.visit(n, arg);
        }

    }
}