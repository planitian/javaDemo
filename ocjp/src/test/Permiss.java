package test;
//静态导入

import base.BaseMain;

import java.io.*;

import static java.lang.System.out;
//导入Integer的静态成员 *  通配符 意味着 所有的
import static java.lang.Integer.*;

strictfp class Permiss {
    public static void main(String[] args) {
        //静态导入  使用
        out.println("静态导入");
        out.println(toBinaryString(1));
        BaseMain baseMain = new BaseMain();
        float one = 444f;
        double two = 99889d;
        out.println(one * two);

        try {
            TranTest tranTest = new TranTest(11, "one", 555d);
            out.println(tranTest.toString());

            File cun = new File("cun");
            if (!cun.exists()) {
                cun.createNewFile();
            }
            FileOutputStream file = new FileOutputStream(cun);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(tranTest);
            objectOutputStream.flush();
            objectOutputStream.close();

            //读取
            FileInputStream fileInputStream = new FileInputStream(cun);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TranTest ta = (TranTest) objectInputStream.readObject();
            out.println(ta.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Tthree tthree = new Tthree();
    }

    public class Three {

    }
}

