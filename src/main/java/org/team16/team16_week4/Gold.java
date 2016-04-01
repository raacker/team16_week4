package org.team16.team16_week4;

public class Gold implements Plan {
	private String planName;
	private double basicMonthlyRate;
	private int includeMinutes;
	private double ratePerExcessMinute;
	private double additionalLineRate;

	public Gold(){
		this.planName = "Gold";
		this.basicMonthlyRate = 49.95;
		this.includeMinutes = 1000;
		this.ratePerExcessMinute = 0.45;
		this.additionalLineRate = 14.50;
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
