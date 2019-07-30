package Interpreter;

//终结符解释器 这个是最小的单元 就是用来给 非终结解释器 获取数据的 相当于R=A+B 里面的 等于号
public class TerminalExpression implements Expression {
    private String key;

    public TerminalExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpret(InterpreterContent content) {
        //相当于等号 最小的 不可运算 返回数据
        return content.getInfo(key);
    }
}
