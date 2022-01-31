package hotel;
import java.util.Collections;
import java.util.List;

public class RestaurantAccess {


    // creating an object
    private static RestaurantAccess restaurantAccess = new RestaurantAccess();

    private RestaurantAccess() { }

    // static method to create object
    public static RestaurantAccess getInstance() {
        return restaurantAccess;
    }

    // add employee
    public Restaurant getCapacity(int capacity) {
        return null;
    }

    public List getAll() {
        return Collections.emptyList();
    }


    public String restaurantInfo(Restaurant restaurant) {
        return restaurant.getRestaurantName()+restaurant.getMenu()+restaurant.getMenuprice();
    }


    public String updateRestaurant(Restaurant restaurant) {
        restaurant.setRestaurantName("Sunshine");
        return restaurant.getRestaurantName();
    }


    public String deleteRestaurant(Restaurant restaurant) {
        return "RESTAURANT IS REMOVED";
    }


}
