package POJOs;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import java.util.List;

public class ExamplePojo {

    private String className;
    private int length;
    private boolean classTooLong, paramTooLong, switchStatements;
    private List<FieldDeclaration> fieldDeclarations;
    private List<VariableDeclarator> variableDeclarators;
    private List<MethodPOJO> methods;



    public List<VariableDeclarator> getVariableDeclarators() {
        return variableDeclarators;
    }

    public void setVariableDeclarators(List<VariableDeclarator> variableDeclarators) {
        this.variableDeclarators = variableDeclarators;
    }

    public List<FieldDeclaration> getFieldDeclarations() {
        return fieldDeclarations;
    }

    public void setFieldDeclarations(List<FieldDeclaration> fieldDeclarations) {
        this.fieldDeclarations = fieldDeclarations;
    }

    public List<MethodPOJO> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodPOJO> methods) {
        this.methods = methods;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isClassTooLong() {
        return classTooLong;
    }

    public void setClassTooLong(boolean classTooLong) {
        this.classTooLong = classTooLong;
    }

    public boolean isParamTooLong() {
        return paramTooLong;
    }

    public void setParamTooLong(boolean paramTooLong) {
        this.paramTooLong = paramTooLong;
    }

    public boolean isSwitchStatements() {
        return switchStatements;
    }

    public void setSwitchStatements(boolean switchStatements) {
        this.switchStatements = switchStatements;
    }



}
