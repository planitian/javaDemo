package flyweight;

import java.util.HashMap;

public class FlyWeightFactory {
    private static HashMap<String, Good> jihe = new HashMap<>();

    public static Good getGood(String key) {
        //如果找不到key的话 会返回null
        Good temp = jihe.get(key);
        if (temp == null) {
            temp = new GoodsImp(key);
            jihe.put(key, temp);
        }
        return temp;
    }
}
