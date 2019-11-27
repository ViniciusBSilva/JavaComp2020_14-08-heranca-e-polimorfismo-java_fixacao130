package java_fixacao130.entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	private static final Double INCOME_BRACKET_LIMIT = 20000.00;

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {

		Double healthExpendituresDiscount = 0.00;

		if (healthExpenditures > 0) {
			healthExpendituresDiscount = healthExpenditures * (50 / 100);
		}

		Double totalTax;

		if (getAnualIncome() > INCOME_BRACKET_LIMIT) {
			totalTax = (getAnualIncome() + (getAnualIncome() * 25 / 100)) - healthExpendituresDiscount;
		} else {
			totalTax = (getAnualIncome() + (getAnualIncome() * 15 / 100)) - healthExpendituresDiscount;
		}

		return totalTax;

	}

}
