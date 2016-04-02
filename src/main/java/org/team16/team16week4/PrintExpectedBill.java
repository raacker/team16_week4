package org.team16.team16week4;

public class PrintExpectedBill {

	private DetailedCost detailedCost;
	
	public PrintExpectedBill(DetailedCost aDetailedCost){
		this.detailedCost = aDetailedCost;
	}
	
	public String printTotalCostEvaluation(){
		String expresion = this.detailedCost.getUserData().getUserPlan().getBasicMonthlyRate() + "";
		if(this.detailedCost.getUserData().getUsedMinutes() > this.detailedCost.getUserData().getUserPlan().getIncludeMinutes())
		{
			expresion = expresion + printOverExcessMinutesCostEvaluation();
		}
		if(this.detailedCost.getUserData().getNumberOfLines() > 0)
		{
			expresion = expresion + printAdditionalLineCostEvaluation();
		}
		
		return expresion + " = " + this.detailedCost.getTotalCost();
	}
	
	public String printOverExcessMinutesCostEvaluation(){
		return " + (" + (this.detailedCost.getUserData().getUsedMinutes()-this.detailedCost.getUserData().getUserPlan().getIncludeMinutes()) + "*" + this.detailedCost.getUserData().getUserPlan().getRatePerExcessMinute() + ")";
	}
	
	public String printAdditionalLineCostEvaluation(){
		if(this.detailedCost.getUserData().getFamilyDiscount()){
			if(this.detailedCost.getUserData().getNumberOfLines()==4)
				return " + (" + 2 + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ")" + " + " + this.detailedCost.getUserData().getUserPlan().getFamilyDiscountFee();
			else
				return " + (" + 2 + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ") + (" + (this.detailedCost.getUserData().getNumberOfLines()-3) + "*" + this.detailedCost.getUserData().getUserPlan().getFamilyDiscountFee() + ")";
		}
		else{
			if(this.detailedCost.getUserData().getNumberOfLines()==2)
				return this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + "";
			else
				return " + (" + this.detailedCost.getUserData().getNumberOfLines() + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ")"; 
		}
	}
}