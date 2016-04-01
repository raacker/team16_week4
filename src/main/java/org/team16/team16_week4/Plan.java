package org.team16.team16_week4;

public interface Plan {
	public String getPlanName();
	
	public double getBasicMonthlyRate();
	
	public int getIncludeMinutes();
	
	public double getRatePerExcessMinute();
	
	public double getAdditionalLineRate();
	
}