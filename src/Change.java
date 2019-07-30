import bean.Emplo;

import java.util.ArrayList;
import java.util.List;

public class Change {


    public List<Emplo> emplos;
    private int index;
    public Change() {
        this.emplos = new ArrayList<>();
    }

    public int add(Emplo emplo){
        emplos.add(emplo);
        return index++;
    }


    public void changeInfo(int index){
        Emplo emplo = emplos.get(index);
      if (emplo!=null){
            emplo.setSex("男");
      }
    }


}
