import Collector.ClassInfo;
import Controller.LongMethodDetection;
import Controller.Primitive;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "/Users/User/Documents/Uni/4-Fourth Year/CS409/Lab2/ReversePolish.java";

    public static void main(String[] args) throws Exception{
        CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));

        List<ClassPOJO> classes = new ArrayList<>();
        new ClassInfo().visit(cu,classes);

        for(ClassPOJO info : classes){
            for(MethodPOJO mPojo : info.getMethods()){
                System.out.println("Method Name " + mPojo.getMethodName() );
                System.out.println("Method too long " + mPojo.isMethodTooLong());
                System.out.println("Parameter list too long " + mPojo.isParamTooLong());
                System.out.println("Method primitive types " + mPojo.getParameters());
            }
            System.out.println("Name : " + info.getClassName());
            System.out.println("Too long : " + info.isClassTooLong());
            System.out.println("Primitive types : " );
        }

    }
}
