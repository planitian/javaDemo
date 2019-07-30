import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class FielTest {
    public static void main(String[] args) throws IOException {

        final String one = "D:/one/two/three/four.txt";
        PlaniLog.path = one;
        PlaniLog.pre();
        new Thread(()->{
            while (true){
               PlaniLog.writeLog(Thread.currentThread().getName());
//                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            }

        }).start();
        new Thread(() -> {
            while (true){
                PlaniLog.writeLog(Thread.currentThread().getName());

//                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            }
        }).start();

    }

}
