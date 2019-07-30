package Interpreter;

//非终结解释器 主要做了运算符号的事情 比如  +
public class PlusExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public PlusExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret(InterpreterContent content) {
        //做的加法运算在这里
        return expression1.interpret(content)+expression2.interpret(content);
    }
}
