package Sort;

import java.util.*;

public class Sortt {
    public static void main(String[] args) {
        List<Normal> normals=new ArrayList<Normal>();
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
            normals.add(new Normal(random.nextInt(100)));
        }

        //重点代码
        Collections.sort(normals, new Comparator<Normal>() {
            @Override
            public int compare(Normal o1, Normal o2) {
                return o1.getNumber()-o2.getNumber();
            }
        });
        Collections.sort(normals,((o1, o2) -> o1.getNumber()-o2.getNumber()));
        System.out.println("排序后");
        normals.forEach(e-> System.out.println(e.getNumber()));
    }
}
