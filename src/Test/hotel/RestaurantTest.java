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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantTest {

    private static RestaurantAccess mockRestaurantAccess;
    private static Restaurant restaurant1;
    private static Restaurant restaurant2;

    @Test
    public void whenCreateSpy_thenCreate() {
        Map spyRestaurantMap = Mockito.spy(new HashMap());
        Restaurant restaurant = new Restaurant(1, "Sunshine", "Meat, Red Wine, Dessert",  1000);
        spyRestaurantMap.put("1", "Sunshine");
        Mockito.verify(spyRestaurantMap).put("1", "Sunshine");
        assertEquals(restaurant.getRestaurantName(), spyRestaurantMap.get("1"));
    }

    @BeforeClass
    public static void initialize() {

        // mock restaurant object
        mockRestaurantAccess = mock(RestaurantAccess.class);

        restaurant1 = new Restaurant(100, "Charides Sea Food", "Charides , Wine, Dessert, Fruit ", 500);

        restaurant2 = new Restaurant(200, "Alacarte", "Meat, Red Wine, Dessert", 300);

        when(mockRestaurantAccess.getAll()).thenReturn(Arrays.asList(restaurant1, restaurant2));
        when(mockRestaurantAccess.updateRestaurant(restaurant2)).thenReturn(restaurant2.getRestaurantName());
        when(mockRestaurantAccess.deleteRestaurant(restaurant2)).thenReturn("RESTAURANT IS REMOVED");

    }

    @Test
    public void getAllTest()
    {
        List allRestaurants = mockRestaurantAccess.getAll();
        assertNotNull(allRestaurants);
        assertEquals(2, allRestaurants.size());
    }


    @Test
    public void updateRestaurantTest()
    {
        String restaurantName = mockRestaurantAccess.updateRestaurant(restaurant2);
        assertNotNull(restaurantName);
        assertEquals("Alacarte", restaurantName);
    }

    @Test
    public void deleteRestaurantTest()
    {
        String status = mockRestaurantAccess.deleteRestaurant(restaurant2);
        assertEquals("RESTAURANT IS REMOVED", status);
    }

}
