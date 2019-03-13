import java.math.BigDecimal;
import java.math.MathContext;

public class Converter {
	
	private static double F_M = 3.28;
	
	private double myNumber;
	private String myUnit;
	private double myResult;
	
	public Converter(Double d, String s) {
		myNumber = d;
		myUnit = s;	
		myResult = 0;
		determineUnits();
	}
	
	private void determineUnits() {
		if (myUnit.equals("meters")) {
			metersToFeet();
		} else {
			feetToMeters();
		}
	}
	
	private void metersToFeet() {
		myResult = myNumber / F_M;
	}
	
	private void feetToMeters() {
		myResult = myNumber * F_M;
	}
	
	public String getResult() {
		BigDecimal b = new BigDecimal(myResult);
		b.round(new MathContext(1));
		return Double.toString(b.doubleValue());
	}
}
