package Controller;

import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveTypeDetection {


    List<String> primitives = Arrays.asList(new String[]{"boolean", "byte", "char", "short", "int", "long", "float", "double"});
    //get list of variables and parameters and check if they match the orange ones
    //then put in a list and return the list

    //check params going into methods
    //fields in the class too
    //fields in methods
    //check type against array of choices

    // pass in the classes
    //inside each method- field declaraction fields
    //
    public ClassPOJO PrimitiveDetection(ClassPOJO classes) {

        List<VariableDeclarator> collectPrimitives = new ArrayList<>();
        for (FieldDeclaration field : classes.getFieldDeclarations()) {
            for (VariableDeclarator variable : field.getVariables()) {
                if (primitives.contains(variable.getTypeAsString())) {
                    collectPrimitives.add(variable);
                }
            }
        }
        for (MethodPOJO methodInfo : classes.getMethods()) {
            List<Parameter> parameterPrimitive = new ArrayList<>();
            for (Parameter parameter : methodInfo.getParameters()) {
                if (primitives.contains(parameter.getTypeAsString())) {
                    parameterPrimitive.add(parameter);
                }
            }
            methodInfo.setParameters(parameterPrimitive);
        }

        classes.setVariableDeclarators(collectPrimitives);

        return classes;

    }
}



