public class Time {
    int min;
    int hour;

    public Time(int hour , int min) {
        boolean b1 =min>=0&& min <=59;
        boolean b2 =hour>=0&& hour <=23;

        if( b1&&b2){
            this.min = min;
            this.hour = hour;
        }
    }

    @Override
    public String toString() {
        return hour+":"+ min;
    }
}

