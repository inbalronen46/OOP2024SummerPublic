import java.io.File;
import java.io.NotActiveException;
import java.util.Scanner;

import org.junit.experimental.theories.Theories;

public class GraphUtils {

	private static double PRECISION = 1.0e-2;

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
