/* Objetivo: O programa irá ler os dados de N contribuentes (N fornecido pelo usuário),
 * os quais podem ser física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um, 
 * bem como o total de imposto arrecadado. */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of taxpayers: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.print("Taxpayer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual icome: ");
			Double anualIcome = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				Individual x = new Individual(name, anualIcome, healthExpenditures);
				list.add(x);
			} else {
				System.out.print("Number of employess: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIcome, numberOfEmployees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID");
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + " $" + String.format("%.2f", tp.tax()));
		}
		
		System.out.println();
		double sum = 0.0;
		for (TaxPayer tp : list) {
			sum += tp.tax();
		}
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();
	}
}
