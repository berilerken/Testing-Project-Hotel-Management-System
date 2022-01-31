package hotel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventTest
{
    private static EventAccess mockEventAccess;
    private static Event event;
    private static Event event1;


    @Test
    public void whenCreateSpy_thenCreate() {
        Restaurant restaurant= new Restaurant(1000,"Sunshine","Wine,Cake",0);
        Map spyEventMap = Mockito.spy(new HashMap());
        Event event4 = new Event(1, "AYSE&ALI WEDDING", "DIY Wedding", "22/12/21", restaurant);
        spyEventMap.put("1", "AYSE&ALI WEDDING");
        Mockito.verify(spyEventMap).put("1", "AYSE&ALI WEDDING");

        assertEquals(event4.getEventName(), spyEventMap.get("1"));
    }


    @BeforeClass
    public static void initialize()
    {

        Restaurant restaurant= new Restaurant(1000,"Sunshine","Wine,Cake",0);
        // set EventAccess as a mock object
        mockEventAccess = mock(EventAccess.class);

        // create an event object
        event = new Event(1, "AYSE&ALI WEDDING", "DIY Wedding", "22/12/21", restaurant);

        // create another event object
        event1 = new Event(2, "MURAT&FATMA WEDDING", "Traditional Wedding", "05/05/22", restaurant);

        // stubbing is done for test cases
        when(mockEventAccess.getAll()).thenReturn(Arrays.asList(event, event1));
        when(mockEventAccess.getEvent(event)).thenReturn(event);
        when(mockEventAccess.eventInfo(event1)).thenReturn(event1.getEventName());
        when(mockEventAccess.deleteEvent(event.getEventID())).thenReturn("REMOVED");


    }

    @Test
    public void getAllTest()
    {
        List allEvents = mockEventAccess.getAll();

        assertNotNull(allEvents);
        assertEquals(2, allEvents.size());
    }

    @Test
    public void getEventTest()
    {

        Event eventObject = mockEventAccess.getEvent(event);

        assertSame(event,eventObject);
        assertNotNull(event1);
        assertEquals(1, eventObject.getEventID());
        assertEquals("MURAT&FATMA WEDDING", event1.getEventName());
        assertEquals("DIY Wedding", event.getEventType());
        assertEquals("22/12/21", event.getEventDate());
    }

    @Test
    public void eventInfoTest()
    {
        String eventInfo = mockEventAccess.eventInfo(event1);
        assertNotNull(event.getRestaurant());
        assertEquals(event1.getEventName(), eventInfo);
    }

    @Test
    public void deleteEmployeeTest() {
        String status = mockEventAccess.deleteEvent(event.getEventID());

        assertEquals("REMOVED", status);
    }

    @Test
    public void multipleCallsTest()
    {
        int id = mockEventAccess.getEvent(event).getEventID();
        System.out.println(id);

        String date = mockEventAccess.deleteEvent(event1.getEventID());
        System.out.println(date);

    }
}
