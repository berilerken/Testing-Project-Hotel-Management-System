package hotel;

import java.util.ArrayList;
import java.util.List;

public class EventAccess {

    // creating an object
    private static EventAccess eventAccess = new EventAccess();
    List<Event> list= new ArrayList<>();
    private EventAccess() { }

    // static method to create object
    public static EventAccess getInstance() {
        return eventAccess;
    }

    // add employee
    public Event getEvent(Event event) {
        return event;
    }

    // list all employees
    public List getAll() {
        return list;
    }


    public String eventInfo(Event event) {
        return event.getEventName()+event.getEventType()+event.getEventDate();
    }


    public String updateEvent(Event event,String eventDate) {
        event.setEventDate(eventDate);
        return event.getEventDate();
    }

    public String deleteEvent(int eventID) {
        eventID=0;
        return "REMOVED";
    }

}
