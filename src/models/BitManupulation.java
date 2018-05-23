package models;
public class BitManupulation {

	public int find_lsb_bit(int value) {
		int less = value - 1;
		value = (less | value) ^ less;
		return (int) Math.log(value + 1);

	}

	public int MSB(int n) { // Time Complexity of Solution: Best = Average = Worst = O(lg n).

		int index = 0;
		while (n > 1) {
			n = (n >> 1);
			index++;
		}
		return index;
	}

	public static int GetLSB(int intValue) {
		return (intValue & 0x0000FFFF);
	}

	public static int GetMSB(int value) {
		return (int) (value & 0xFFFF0000);
	}
}
