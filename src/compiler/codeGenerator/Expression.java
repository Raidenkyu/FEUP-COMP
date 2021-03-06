package compiler.codeGenerator;

import compiler.dag.DAGBinaryOp;
import compiler.dag.DAGBooleanConstant;
import compiler.dag.DAGBracket;
import compiler.dag.DAGExpression;
import compiler.dag.DAGIntegerConstant;
import compiler.dag.DAGLength;
import compiler.dag.DAGMethodCall;
import compiler.dag.DAGNewClass;
import compiler.dag.DAGNewIntArray;
import compiler.dag.DAGNot;
import compiler.dag.DAGStaticCall;
import compiler.dag.DAGVariable;

public class Expression extends BaseStatement {

    private DAGExpression expression;

    Expression(Function function, DAGExpression expression)
    {
        super(function);
        this.function = function;
        this.expression=expression;
    }

    @Override
    public String toString()
    {
        String expressionBody = new String();
        if(expression instanceof DAGBinaryOp) {
            BinaryOperation operation = new BinaryOperation(this.function, (DAGBinaryOp) expression);
            expressionBody = expressionBody.concat(operation.toString());
        }
        else if(expression instanceof DAGVariable) {
            Variable variable = new Variable(this.function, (DAGVariable)expression);
            expressionBody = expressionBody.concat(variable.toString());
        }
        else if(expression instanceof DAGIntegerConstant) {
            IntegerPush integerLoadBody = new IntegerPush((DAGIntegerConstant)expression);
            expressionBody = expressionBody.concat(integerLoadBody.toString());
        }
        else if(expression instanceof DAGMethodCall) {
            MethodCall callBody = new MethodCall(this.function, (DAGMethodCall)expression);
            expressionBody = expressionBody.concat(callBody.toString());
        }
        else if(expression instanceof DAGBooleanConstant) {
            BooleanConstant booleanConstant = new BooleanConstant((DAGBooleanConstant)expression);
            expressionBody = expressionBody.concat(booleanConstant.toString());
        }
        else if(expression instanceof DAGBracket) {
            BracketAccess bracketAccess = new BracketAccess(this.function, (DAGBracket)expression);
            expressionBody = expressionBody.concat(bracketAccess.toString());
        }
        else if(expression instanceof DAGNewIntArray) {
            NewIntArray newObject = new NewIntArray(this.function, (DAGNewIntArray)expression);
            expressionBody = expressionBody.concat(newObject.toString());
        }
        else if(expression instanceof DAGNewClass) {
            NewClass newClass = new NewClass(this.function, (DAGNewClass) expression);
            expressionBody = expressionBody.concat(newClass.toString());
        }
        else if(expression instanceof DAGStaticCall) {
            StaticCall call = new StaticCall(this.function, (DAGStaticCall) expression);
            expressionBody = expressionBody.concat(call.toString());
        }
        else if(expression instanceof DAGLength) {
            ArrayLength arrayLength = new ArrayLength(this.function, (DAGLength)expression);
            expressionBody = expressionBody.concat(arrayLength.toString());
        }
        else if(expression instanceof DAGNot) {
            Not not = new Not(this.function, (DAGNot)expression);
            expressionBody = expressionBody.concat(not.toString());
        }
        return expressionBody;
    }
}


            /*DAGExpression lhs = ((DAGBinaryOp)expression).getLhs();
            DAGExpression rhs = ((DAGBinaryOp)expression).getRhs();
            BinaryOperator operator = ((DAGBinaryOp)expression).getOperator();
            Expression lhsBody = new Expression(this.function, lhs);
            Expression rhsBody = new Expression(this.function, rhs);
            Operator operatorBody = new Operator(operator);
            expressionBody = expressionBody.concat(lhsBody.toString()).concat(rhsBody.toString()).concat(operatorBody.toString());*/
