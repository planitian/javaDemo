package Interpreter;

import java.util.HashMap;
import java.util.Map;

//上下文类 用于保存一些运算时候需要的信息
public class InterpreterContent {
    private Map<String, Integer> map = new HashMap<>();

    public int getInfo(String key){
        return map.get(key);
    }

    public void putInfo(String key,int i){
        map.put(key, i);
    }
}
