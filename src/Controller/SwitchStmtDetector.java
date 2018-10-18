package Controller;


import POJOs.ClassPOJO;
import POJOs.MethodPOJO;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;
import sun.plugin.javascript.navig.Navigator;

import java.util.List;
import java.util.Optional;

public class SwitchStmtDetector {

    public MethodPOJO SwitchStmtDetector(MethodPOJO methodInfo){

      for(Statement statement : methodInfo.getStatements()){
          if(statement.isSwitchStmt()){
              methodInfo.setSwitchStmt(true);

          }
      }


        return methodInfo;
    }

}