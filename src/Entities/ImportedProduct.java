package Entities;

public class ImportedProduct extends Product {
    private double customsFree;


    public ImportedProduct(String name, double price) {
        super(name, price);
    }

    public ImportedProduct(String name, double price, double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(double customsFree) {
        this.customsFree = customsFree;
    }

    public double totalPrice() {
        return getPrice() * customsFree;
    }

    @Override
    public String pricetag() {
        return getName() +
                " $ "
                + String.format("%.2f", totalPrice()) +
                "(Custom free: $ " +
                String.format("%.2f", customsFree)
                + ")";
    }
}