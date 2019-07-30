import java.time.LocalDate;
import java.time.Month;
import java.time.format.*;

public class NotPackage {
    public static void main(String[] args) {


        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd,yyyy");
        LocalDate d = LocalDate.of(2018, Month.JANUARY, 15);
        LocalDate d2 = d.plusDays(1);
        System.out.println(f1.format(d) + " ");
        System.out.println(d2.format(f1));
       for (int i=0;true|false;i++){
           if (--i==0||i==2){
               System.out.println("Yes: "+i+" ");
               break;
           }else if (i++%2==0){
               System.out.println("No: "+i+" ");
           }
       }


    }
}
