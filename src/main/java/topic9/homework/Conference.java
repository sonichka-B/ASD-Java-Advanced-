package topic9.homework;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Conference {
    String name;
    String city;
    String config;

    @Value
    public static class Config{
        String timezone;
        int maxSeats;
        String code;

        public String configuration(String code, String timezone, int maxSeats) {
            return "code: " + code + " maxSeats: " + maxSeats + " timezone: " + timezone;
        }
    }
    @Value
    public class Session{
       String title;
       String speaker;
       int startMinutes;

       public String label(String name, String title){
           name = getName();
           title = getTitle();
           return "name: " + name + " title: " + title;
       }
    }

    public Session addSession(Session session){
        if(session == null || getSessions().equals(session)){
            return null;
        }
        getSessions().add(session);
        return session;
    }

    public List<Session> getSessions(){
        List<Session> sessions = List.copyOf(new ArrayList<>());
        return sessions;
    }


}
