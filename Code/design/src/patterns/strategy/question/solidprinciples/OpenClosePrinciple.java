package patterns.strategy.question.solidprinciples;

class BeforeOpenClosePrinciple{
    static class Entity{
        String name;
        int price;

        public Entity(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "Name= '" + name + '\'' +
                    ", Price= " + price +
                    '}';
        }
    }

    static class Invoice {
        Entity entity;
        int quantity;

        public Invoice(Entity entity, int quantity) {
            this.entity = entity;
            this.quantity = quantity;
        }

        /*
            Single and only reason to change the Invoice class, if there is a change only in calculating invoice logic
            For example, if there is a factor of discount and taxes
                            on the Entity while calculating the total amount
                            then we have to do change in the Invoice class
         */
        public int calculateTotal(){
            return entity.price*this.quantity;
        }

        @Override
        public String toString() {
            return "Invoice [" +
                    entity +
                    ",\tQuantity= " + quantity +
                    ",\tTotal=" + calculateTotal() +
                    "]\t";
        }
    }

    static class PrintInvoice {
        //Single and only reason to change the PrintInvoice class, if there is a change only in printing invoice logic
        static void printInvoice(Invoice invoice){
            System.out.println("Total : Rs. "+invoice.calculateTotal()+" /-");
        }
    }

    static class SaveInvoice{
        //Single and only reason to change the SaveInvoice class, if there is a change only in saving invoice logic
        static void saveInvoice(Invoice invoice){
            System.out.println("Just Saving "+invoice);
        }
    }

    public static void run() {
        Invoice invoice = new Invoice(new Entity("Studds Thunder D11",2000),3);
        BeforeOpenClosePrinciple.PrintInvoice.printInvoice(invoice);
        BeforeOpenClosePrinciple.SaveInvoice.saveInvoice(invoice);
    }

}
class AfterOpenClosePrinciple{
    static class Entity{
        String name;
        int price;

        public Entity(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "Name= '" + name + '\'' +
                    ", Price= " + price +
                    '}';
        }
    }

    static class Invoice {
        Entity entity;
        int quantity;

        public Invoice(Entity entity, int quantity) {
            this.entity = entity;
            this.quantity = quantity;
        }

        /*
            Single and only reason to change the Invoice class, if there is a change only in calculating invoice logic
            For example, if there is a factor of discount and taxes
                            on the Entity while calculating the total amount
                            then we have to do change in the Invoice class
         */
        public int calculateTotal(){
            return entity.price*this.quantity;
        }

        @Override
        public String toString() {
            return "Invoice [" +
                    entity +
                    ",\tQuantity= " + quantity +
                    ",\tTotal=" + calculateTotal() +
                    "]\t";
        }
    }

    static class PrintInvoice {
        //Single and only reason to change the PrintInvoice class, if there is a change only in printing invoice logic
        static void printInvoice(Invoice invoice){
            System.out.println("Total : Rs. "+invoice.calculateTotal()+" /-");
        }
    }

    static interface InvoiceDao{
        void save(Invoice invoice);
    }
    static class SaveInvoiceToDB implements InvoiceDao{
        //Single and only reason to change the SaveInvoice class, if there is a change only in saving invoice logic
        public void save(Invoice invoice){
            System.out.println("Saving "+invoice+" to Database");
        }
    }
    static class SaveInvoiceToFile implements InvoiceDao{
        //Single and only reason to change the SaveInvoice class, if there is a change only in saving invoice logic
        public void save(Invoice invoice){
            System.out.println("Saving "+invoice+" to File");
        }
    }

    public static void run(InvoiceDao invoiceDao) {
        Invoice invoice = new Invoice(new Entity("Studds Thunder D11",2000),3);
        AfterOpenClosePrinciple.PrintInvoice.printInvoice(invoice);
        invoiceDao.save(invoice);
    }

}
public class OpenClosePrinciple {

    public static void main(String[] args) {

        BeforeOpenClosePrinciple.run();

        AfterOpenClosePrinciple.SaveInvoiceToDB dao1 = new AfterOpenClosePrinciple.SaveInvoiceToDB();
        AfterOpenClosePrinciple.SaveInvoiceToFile dao2 = new AfterOpenClosePrinciple.SaveInvoiceToFile();

        AfterOpenClosePrinciple.run(dao1);
        AfterOpenClosePrinciple.run(dao2);
    }
}
