package patterns.strategy.question.solidprinciples;

class BeforeDependencyInversion {
    static interface Keyboard{    }
    static interface Mouse{    }

    static class WiredKeyboard implements Keyboard { }
    static class WirelessKeyboard implements Keyboard { }
    static class WiredMouse implements Mouse { }
    static class WirelessMouse implements Mouse { }

    static class Laptop{
        // The laptop is hardcoded with wired keyboard and
        // therefore it would be difficult to upgrade the keyboard later
        private static final WiredKeyboard keyboard = new WiredKeyboard();
        static void useKeyboard(){
            System.out.println("Using : "+keyboard);
        }
    }

    public static void run() {
        Laptop.useKeyboard();
    }

}
class AfterDependencyInversion {
    static interface Keyboard{    }
    static interface Mouse{    }

    static class WiredKeyboard implements Keyboard { }
    static class WirelessKeyboard implements Keyboard { }
    static class WiredMouse implements Mouse { }
    static class WirelessMouse implements Mouse { }

    static class Laptop{
        // The laptop is not hardcoded with wired keyboard and
        // therefore it would not be difficult to upgrade the keyboard later
        private final Keyboard keyboard;

        Laptop(Keyboard keyboard){
            this.keyboard=keyboard;
        }
        Laptop(){
            keyboard=new WiredKeyboard();
        }

        void useKeyboard(){
            System.out.println("Using : "+keyboard);
        }
    }

    public static void run() {
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop(new WirelessKeyboard());
        l1.useKeyboard();
        l2.useKeyboard();
    }

}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        BeforeDependencyInversion.run();
        AfterDependencyInversion.run();
    }
}
