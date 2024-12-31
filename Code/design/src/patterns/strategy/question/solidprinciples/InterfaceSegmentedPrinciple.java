package patterns.strategy.question.solidprinciples;

class BeforeInterfaceSegmented{
    static interface RestaurantEmployee {
        void cookFood();
        void serveCustomers();
        void washDishes();
    }

    static class Waiter implements RestaurantEmployee{

        public void cookFood() {
            //No need of this method to waiter class
        }

        public void serveCustomers() {
            System.out.println("Serving Food");
        }

        public void washDishes() {
            //No need of this method to waiter class
        }
    }

    public static void run() {
        Waiter a= new Waiter();
        a.serveCustomers();
    }
}

class AfterInterfaceSegmented{
    static interface WaiterEmployee {
        void serveCustomers();
        void takeOrders();
    }
    static interface ChefEmployee {
        void cookFood();
        void decideMenu();
    }

    static class Waiter implements WaiterEmployee{

        public void takeOrders() {
            System.out.println("Taking Orders");
        }

        public void serveCustomers() {
            System.out.println("Serving Food");
        }
    }
    static class Chef implements ChefEmployee{

        public void cookFood() {
            System.out.println("Cooking Food");
        }
        public void decideMenu() {
            System.out.println("Deciding Menu");
        }
    }

    public static void run() {
        WaiterEmployee a= new Waiter();
        ChefEmployee c=new Chef();
        c.decideMenu();
        a.takeOrders();
        c.cookFood();
        a.serveCustomers();

    }
}
public class InterfaceSegmentedPrinciple {
    public static void main(String[] args) {
        BeforeInterfaceSegmented.run();
        AfterInterfaceSegmented.run();
    }
}
