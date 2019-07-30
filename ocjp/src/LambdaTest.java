public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.outLambda((s)->{ s+=" lambda 表达式加入";
            System.out.println(s); });

        lambdaTest.outLambda(new LambdaOne() {
            @Override
            public void out(String content) {
                System.out.println("hahahh");
            }
        });

    }

    void outLambda(LambdaOne lambdaOne){
        String content = "巴莹是臭狗屎";
        lambdaOne.out(content);
    }

}

interface LambdaOne{
    void out(String content);
}
