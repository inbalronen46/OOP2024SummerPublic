
public class HW2Utils {
	private static double PRECISION = 1.0e-2;
	
	public static double getPRECISION() {
		return PRECISION;
	}

	/**
	 * @param d : double
	 * @return String represents d with 2 places after the decimal point.
	 */
	public static String formatDouble(double d) {
		String res = String.format("%.2f", d);
		if (res.equals("-0.00"))
			res = "0.00";
		return res;
	}
	
	public static boolean areEqual(double d1, double d2) {
		return Math.abs(d1 - d2) < PRECISION;
	}
}
