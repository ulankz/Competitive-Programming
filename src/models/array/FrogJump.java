package models.array;

public class FrogJump {

	public int get_jump(int x, int y, int d) {
		int count = 0;
		count = (y - x) / d;
		if (((y - x) - count * d) != 0)
			count++;

		return count;
	}
}
