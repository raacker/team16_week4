package org.team16.team16_week4;

public class Silver implements Plan {
	private String planName;
	private double basicMonthlyRate;
	private int includeMinutes;
	private double ratePerExcessMinute;
	private double additionalLineRate;

	public Silver(){
		this.planName = "Silver";
		this.basicMonthlyRate = 29.95;
		this.includeMinutes = 500;
		this.ratePerExcessMinute = 0.54;
		this.additionalLineRate = 21.50;
	}

	public String getPlanName() {
		return this.planName;
	}

	public double getBasicMonthlyRate() {
		return this.basicMonthlyRate;
	}

	public int getIncludeMinutes() {
		return this.includeMinutes;
	}

	public double getRatePerExcessMinute() {
		return this.ratePerExcessMinute;
	}

	public double getAdditionalLineRate() {
		return this.additionalLineRate;
	}
}