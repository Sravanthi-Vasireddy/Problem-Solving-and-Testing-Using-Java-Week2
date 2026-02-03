import java.time.LocalDate;
import java.util.*;
class Event{
    String name;
    LocalDate date;
    Event(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name,date));
        }
        int month = sc.nextInt();
        events.sort(Comparator.comparing(e -> e.date));
        for(int i=0;i<events.size();i++){
            System.out.print(events.get(i).name);
            if(i<events.size()-1) System.out.print(" ");
        }
        System.out.println();
        Event earliest = events.get(0);
        Event latest = events.get(events.size()-1);
        System.out.println(earliest.name);
        System.out.println(latest.name);
        List<String> monthEvents = new ArrayList<>();
        for(Event e:events){
            if(e.date.getMonthValue() == month){
                monthEvents.add(e.name);
            }
        }
        for(int i = 0;i<monthEvents.size();i++){
            System.out.print(monthEvents.get(i));
            if(i<monthEvents.size() -1) System.out.print(" ");
        }
    }
}