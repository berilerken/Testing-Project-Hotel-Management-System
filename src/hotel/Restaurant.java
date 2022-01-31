package hotel;

public class Restaurant {

    private int capacity;
    private String RestaurantName;
    private String Menu;
    private int Menuprice;

    public Restaurant(int capacity, String restaurantName, String menu, int menuprice) {
        this.capacity = capacity;
        RestaurantName = restaurantName;
        Menu = menu;
        Menuprice = menuprice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public int getMenuprice() {
        return Menuprice;
    }

    public void setMenuprice(int menuprice) {
        Menuprice = menuprice;
    }


}