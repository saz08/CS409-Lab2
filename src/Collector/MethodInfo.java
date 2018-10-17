package Collector;

import Controller.LongMethodDetection;
import Controller.ParameterDetection;
import Controller.Primitive;
import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class MethodInfo extends VoidVisitorAdapter<List<MethodPOJO>> {

    @Override
    public void visit(MethodDeclaration md, List<MethodPOJO> list){
        super.visit(md,list);

        int allStatements = md.getBody().get().findAll(Statement.class).size();
        int blocks = md.getBody().get().findAll(BlockStmt.class).size();


        MethodPOJO mPojo = new MethodPOJO();
        mPojo.setMethodName(md.getNameAsString());
        mPojo.setLength(allStatements-blocks);
        mPojo.setParameters(md.getParameters());

        mPojo = new LongMethodDetection().LongMethodDetection(mPojo);
        mPojo = new ParameterDetection().ClassParameter(mPojo);

        list.add(mPojo);


    }


}
