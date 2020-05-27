import java.util.*;

public class Cinema {
   private TreeMap<Days, Schedule> map;
   private Time open =new Time(9,0);
   private Time close=new Time(22,0);

    public Cinema() {
        this.map =new TreeMap<>();
        map.put(Days.MONDAY, new Schedule());
        map.put(Days.TUESDAY, new Schedule());
        map.put(Days.THURSDAY, new Schedule());
        map.put(Days.WEDNESDAY, new Schedule());
        map.put(Days.FRIDAY, new Schedule());
        map.put(Days.SATURDAY, new Schedule());
        map.put(Days.SUNDAY, new Schedule());
            }

    public TreeMap<Days, Schedule> getMap() {
        return map;
    }

    public void setMap(TreeMap<Days, Schedule> map) {
        this.map = map;
    }

    public void addSeances (String day, Seance...seance){
        Days d = Days.valueOf(day);
        Schedule schedule =map.get(d);
        TreeSet<Seance> set = schedule.getSet();

        for (Seance s : seance) {
            if(s.getStartTime().hour >=9 && s.getEndTime().hour < 21){
//
                schedule.addSeance(s);
            }
        }
    }

    public void addSeance (String day, Seance seance){
        Days d = Days.valueOf(day);
        Schedule schedule =map.get(d);
        if(seance.getStartTime().hour >=9 && seance.getEndTime().hour < 21){
            schedule.addSeance(seance);
        }
    }

    public void removeMovie(Movie m){
          for (Map.Entry<Days, Schedule> entry : map.entrySet()) {
            Set<Seance> s = entry.getValue().getSet();
            Iterator <Seance> i =s.iterator();
            while (i.hasNext()){
               if(i.next().getMovie().equals(m)){
                   i.remove();
               }
            }
          }


    }

    public void removeSeance (Seance s, String day){
        Days d = Days.valueOf(day);
        Schedule schedule =map.get(d);
        schedule.removeSeance(s);
    }
    //    Cinema:
//
//   - врахувати час відкриття і закриття при формуванні сеансів!
//
//

//   removeMovie(Movie) (повністю видаляє усі сеанси вказаного фільму з розкладу),
//   removeSeance (Seance, String) (видаляє конкретний сеанс фільму в конкретний день, який задається параметром String).
//
//
//    Main class:
//            - створення об'єкту Cinema;
//            - викликаємо всі методи Cinema
//
//    Для кожного класу зробити адекватний toString, щоб все було читабельно і доступно.
//    Там де потрібно, зробити compareTo(). Маєте якісь власні ідеї для розробки - будь-ласка.
//    Це моделювання роботи кінотеатру, тому все що наблизить програму до реальності вітається.
}
