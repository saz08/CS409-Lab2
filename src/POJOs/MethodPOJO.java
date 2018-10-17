package POJOs;

import com.github.javaparser.ast.body.Parameter;

import java.util.List;

public class MethodPOJO {


    private int length;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    private List<Parameter> parameters;
    private boolean methodTooLong, paramTooLong;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    private String methodName;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isMethodTooLong() {
        return methodTooLong;
    }

    public void setMethodTooLong(boolean methodTooLong) {
        this.methodTooLong = methodTooLong;
    }

    public boolean isParamTooLong() {
        return paramTooLong;
    }

    public void setParamTooLong(boolean paramTooLong) {
        this.paramTooLong = paramTooLong;
    }








}
