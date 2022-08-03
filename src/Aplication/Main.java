package Aplication;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        List<Product> list = new ArrayList<>();


        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product # " + i + 1 + " data: ");

            System.out.println("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);

            System.out.println("Name: ");
            String name = sc.nextLine();

            System.out.println("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {

                System.out.println("Customs fee:");
                double customsFree = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFree));

            } else if (ch == 'u') {

                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, date));

            } else {
                list.add(new Product(name, price));
            }

            System.out.println("PRICE TAG: ");

            for(Product prod: list){
                System.out.println(prod.pricetag());
            }


        }
    }
}