import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie("A", new Time(1,25)); //9:00 -10:25
        Movie m2 = new Movie("B", new Time(0,25));//10:24
        Movie m3= new Movie("C", new Time(1,45));//10:25-12:10
        Movie m4= new Movie("D", new Time(2,15));//12:25-14:40
        Movie m5= new Movie("E", new Time(2,00));//14:45-16:45



        Cinema c= new Cinema();
      c.addSeance("MONDAY", new Seance( m1, new Time(9,00)));
      c.addSeance("MONDAY", new Seance( m2, new Time(10,24)));
      c.addSeance("MONDAY", new Seance( m3, new Time(10,25)));
      c.addSeance("MONDAY", new Seance( m4, new Time(12,25)));
      c.addSeance("MONDAY", new Seance( m5, new Time(14,45)));

       System.out.println(c.getMap().get(Days.MONDAY));
        //System.out.println("a"+ "\n" + "assa");
    }
}
