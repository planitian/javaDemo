package Interpreter;

public class InterpreterMain {
    public static void main(String[] args) {
        //创建上下文，将要运算的数据 输入进去
        InterpreterContent interpreterContent = new InterpreterContent();
        interpreterContent.putInfo("one",9);
        interpreterContent.putInfo("two",4);
        //进行运行   Plus持有 两个终结符解释器  plus来进行加运算
        Expression expression=new PlusExpression(new TerminalExpression("one"),new TerminalExpression("two"));
        //plus 同时具有终结符解释器的返回数据功能  因为是同一个接口
        System.out.println(expression.interpret(interpreterContent));
    }
}
