package clone_sheng_qian;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CloneTest implements Cloneable ,Serializable {
    protected int age;
    protected String name;
    protected List<String> lists;


    private CloneTest(){

    }
    private CloneTest(Builder builder){
           this.age=builder.age;
           this.name=builder.name;
           this.lists=builder.lists;
     }
    public static class Builder{
        private int age;
        private String name;
        private List<String> lists;

        public Builder(int age) {
            this.age = age;
        }

        public Builder age(int age){
            this.age=age;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder lists(List<String> lists){
            this.lists=lists;
            return this;
        }
        public CloneTest Build(){
            return new CloneTest(this);
        }
    }

    @Override
    protected CloneTest clone()  {
////         CloneTest clone=(CloneTest)super.clone();
////         clone.lists=new ArrayList<>();
////         return clone;
//        return (CloneTest) super.clone();
        Object object=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
           objectOutputStream.writeObject(this);
           objectOutputStream.close();
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
            object=objectInputStream.readObject();
             objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (CloneTest) object;
    }

    @Override
    public String toString() {
        return age+" "+name+" "+lists.toString();
    }
}
