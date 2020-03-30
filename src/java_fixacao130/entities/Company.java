package java_fixacao130.entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;
	private static final Integer NUMBER_OF_EMPLOYEES_DISCOUNT_MINIMUM = 10;
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		
		Double totalTax;
		
		if (numberOfEmployees > NUMBER_OF_EMPLOYEES_DISCOUNT_MINIMUM) {
			totalTax = (getAnualIncome() * 14 / 100);
		} else {
			totalTax = (getAnualIncome() * 16 / 100);
		}
		
		return totalTax;
		
	}

}
