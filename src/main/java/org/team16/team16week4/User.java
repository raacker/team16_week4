package org.team16.team16week4;

public class User {
	private Plan _plan;
	private int _numberOfLines;
	private int _usedMinutes;
	private boolean _familyDiscount;
	
	public User(Plan plan, int lines, int minutes)
	{
		this._plan = plan;
		this._numberOfLines = lines;
		this._usedMinutes = minutes;
		if(this._numberOfLines >= 3)
			this._familyDiscount = true;
		else
			this._familyDiscount = false;
	}
	
	public Plan getUserPlan()
	{
		return this._plan;
	}
	public int getNumberOfLines()
	{
		return this._numberOfLines;
	}
	public int getUsedMinutes()
	{
		return this._usedMinutes;
	}
	public boolean getFamilyDiscount()
	{
		return this._familyDiscount;
	}
	
	
}
