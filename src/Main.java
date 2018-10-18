import Collector.ClassInfo;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Lab2/ReversePolish.java";
   // private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Lab2/ExamplePojo.java";


    public static void main(String[] args) throws Exception{
        CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));

        List<ClassPOJO> classes = new ArrayList<>();
        new ClassInfo().visit(cu,classes);

        for(ClassPOJO info : classes){
            for(MethodPOJO mPojo : info.getMethods()){
                System.out.println("Method Name " + mPojo.getMethodName() );

                if(mPojo.isMethodTooLong()==true){
                    System.out.println("This is a long method");
                }

                if(mPojo.isParamTooLong()==true){
                    System.out.println("The parameter list for this method is too long");
                }

                if(mPojo.getParameters().size()>0){
                    System.out.println("This method has primitive types : " + mPojo.getParameters());
                }



                if(mPojo.isSwitchStmt()==true){
                    System.out.println("This method has a switch statement");
                }
                System.out.println("\n");
            }

            System.out.println("Name : " + info.getClassName());
            if(info.isClassTooLong()==true){
                System.out.println("This is a large class");
            }

            if(info.isDataClass()==true){
                System.out.println("This is a data class");
            }
            System.out.println("Primitive types in this class " + info.getVariableDeclarators());




        }

    }
}
