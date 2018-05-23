package models;

public class LogicalOperators {

	public static boolean logical_operator(boolean a, boolean b, boolean c, boolean d) {
		// 0011 1100 0101 1010
		return (!a & !b & c & d) ^ (a & b & !c & !d) ^ (!a & b & !c & d) ^ (a & !b & c & !d) ^ (!a & b & c & !d) ^ (a & !b & !c & d);
	}
}
