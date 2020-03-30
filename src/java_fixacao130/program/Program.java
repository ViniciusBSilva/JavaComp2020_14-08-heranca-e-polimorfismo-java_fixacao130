package java_fixacao130.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import java_fixacao130.entities.Company;
import java_fixacao130.entities.Individual;
import java_fixacao130.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of tax payers: ");
		int quant = sc.nextInt();

		System.out.println();
		
		List<TaxPayer> taxPayers = new ArrayList<>();

		for (int i = 0; i < quant; i++) {
			System.out.print("Select tax payer type. Company (C) or Individual (I): ");
			char type = sc.next().toUpperCase().charAt(0);

			System.out.print("Enter tax payer name: ");
			String name = sc.next();

			System.out.print("Enter tax payer anual income: US$ ");
			Double anualIncome = sc.nextDouble();

			switch (type) {
			case ('I'):
				System.out.print("Enter tax payer health expenditures: US$ ");
				Double healthExpenditures = sc.nextDouble();

				Individual individual = new Individual(name, anualIncome, healthExpenditures);
				taxPayers.add(individual);
				break;

			case ('C'):
				System.out.print("Enter tax payer number of employees: ");
				Integer numberOfEmployees = sc.nextInt();

				Company company = new Company(name, anualIncome, numberOfEmployees);
				taxPayers.add(company);
				break;

			default:
				System.out.println("Wrong type entered");
				break;
			}
			
			System.out.println();

		}

		System.out.println();
		
		System.out.println("|-------------------------------------------------------|");
		System.out.format("| %-30s | %-20s | %n", "Tax Payer Name", "Tax Payed");
		System.out.println("|-------------------------------------------------------|");

		Double totalTax = 0.00;

		for (TaxPayer taxPayer : taxPayers) {

			System.out.format("| %-30s | US$ %-16.2f | %n", taxPayer.getName(), taxPayer.tax());

			totalTax += taxPayer.tax();

		}
		System.out.println("|-------------------------------------------------------|");
		System.out.format("| Total Tax: US$ %-38.2f | %n", totalTax);
		System.out.println("|-------------------------------------------------------|");

		sc.close();

	}

}
