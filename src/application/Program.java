package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("*Enter Cliente Data*");
		Client client = new Client();
		System.out.print("Name: ");
		client.setName(sc.nextLine());
		System.out.print("Email: ");
		client.setEmail(sc.nextLine());
		System.out.print("Birth date (DD/MM/YYYY): ");
		client.setBirthDate(sdf.parse(sc.next()));
		
		System.out.println("-----------------------------------------------------");
		System.out.println("*Enter Order Data*");
		System.out.print("Status (PENDING_PAYMENT/PROCESSING/SHIPPED/DELIVERED): ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?: ");
		Integer quantity = sc.nextInt();
		for(int i=0; i<quantity; i++) {
			System.out.println("---------------------------------------------------");
			System.out.println("*Enter #" + (i +1)  + " item data*");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quant = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quant, productPrice, product);
			order.addItem(item);
		}
		System.out.println("-------------------------------------------------------");
		System.out.println(order);
		
		sc.close();
	}

}
