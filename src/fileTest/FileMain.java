package fileTest;

import java.io.File;
import java.io.IOException;

public class FileMain {
     static String te;
    public static void main(String[] args) {
        String path = "/storage/emulated/0/Download/hahah.apk";
        int last = path.lastIndexOf("/");
        path = path.substring(0, last);
        System.out.println(path);

        File file = new File("D:/debug/");
        File fileL = new File("D:/debug.apk");

        if (!file.exists()){
            try {
                System.out.println( file.createNewFile()); ;
                System.out.println(file.renameTo(fileL));;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.isDirectory()+" "+file.isFile()+"  "+file.getName()+"  "+file.getPath());
        File oen = new File("D:/debug", "ass.apk");

      /*  if (!oen.exists()){
            try {
                oen.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println(te);
    }
}
