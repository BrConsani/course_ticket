package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main(String args[]) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		System.out.print("Enter the number of products: ");
		int nb = sc.nextInt();
		for(int i=1; i<=nb; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				Product pdt = new ImportedProduct(name, price, customsFee);
				products.add(pdt);
			}else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product pdt = new UsedProduct(name, price, date);
				products.add(pdt);
			}else {
				Product pdt = new Product(name, price);
				products.add(pdt);
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product pdt: products) {
			System.out.println(pdt.priceTag());
		}
		
		
		sc.close();
	}

}
