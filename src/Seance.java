import java.util.Objects;

public class Seance implements Comparable <Seance> {
   private Movie movie;
   private Time startTime;
   private Time endTime;

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = end(startTime, movie.getDuration());
        //System.out.println("movie = " + movie + ", startTime = " + startTime + "end"+ endTime);
    }

    public Movie getMovie() {
        return movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return  movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }



    @Override
    public int compareTo(Seance o) {
//        if(startTime.hour==o.getStartTime().hour){
//            return  startTime.min - o.getStartTime().min;
//        }
//        return startTime.hour - o.getStartTime().hour;
        //починатись після кінця і завершуватись перед початкоом
        if(o.getStartTime().hour>endTime.hour || o.endTime.hour < startTime.hour ){
            //System.out.println(o.movie);
            return startTime.hour - o.getStartTime().hour;

        }else if(o.getStartTime().hour==endTime.hour && o.getStartTime().min >=endTime.min ){
            return startTime.hour - o.getStartTime().hour;
        }else if(o.endTime.hour==startTime.hour && o.getEndTime().min <=startTime.min ){
            return startTime.hour - o.getStartTime().hour;
        }
        return 0;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) &&
                Objects.equals(startTime, seance.startTime) &&
                Objects.equals(endTime, seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    public Time end(Time sTime , Time durat){
        int minn=sTime.min + durat.min;
        int hours=sTime.hour + durat.hour;;
        if(minn>=60 ){
            minn-=60;
            hours++;
        }
        if(hours>23){
            hours-=23;
        }
        return new Time(hours , minn);
    }


}



