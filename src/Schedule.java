import java.util.Iterator;
import java.util.TreeSet;

public class Schedule {
   private TreeSet<Seance> set;

    public Schedule() {
        this.set  = new TreeSet <Seance>() ;
    }

    public TreeSet<Seance> getSet() {
        return set;
    }

    public void setSet(TreeSet<Seance> s) {
        this.set = s;
    }


    @Override
    public String toString() {
        String str= "-----Schedule-----\n";
        for (Seance s:set){
            str+= s.toString()+"\n";
        }
        return str;
    }



    public void addSeance (Seance s){
        this.set.add(s);
    }
    public void removeSeance (Seance s){
        Iterator<Seance> i =this.set.iterator();

        while (i.hasNext()){
            if(i.next().equals(s)){
                i.remove();
            }
        }
    }
}
