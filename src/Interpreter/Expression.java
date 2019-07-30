package Interpreter;

//解释器的接口，定义调用方法
public interface Expression {
    //参数是上下文  用于保存提供数据  ，一般是map  list也行
    int interpret(InterpreterContent content);
}
