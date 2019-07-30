package build;

public class Student {
    private String name;
    private int age;
    private String sex;


     private Student(Builder builder){
        this.name=builder.name;
        this.age=builder.age;
        this.sex=builder.sex;
    }

    public static class Builder{
        private String name;
        private int age;
        private String sex;


        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder age(int age){
            this.age=age;
            return this;
        }
        public Builder sex(String sex){
            this.sex=sex;
            return this;
        }

         public   Student Build(){
             return new Student(this);
        }
    }

    @Override
    public String toString() {
        return name+age+sex;
    }
}
