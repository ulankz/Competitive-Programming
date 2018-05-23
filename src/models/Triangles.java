package models;

public class Triangles {

	public static void FloydsTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	public static void FloydsTriangle_v1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1 - i; j >= 0; j--) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	public static void Pyramid(int n) {
		int count = n - 1;

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < count; i++) {
				System.out.print(" ");
			}
			count--;
			for (int j = 0; j < 2 * k + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void Pyramid_mirror(int n) {
		int countU = n - 1;
		int countD = 0;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < countU; i++) {
				System.out.print(" ");
			}
			countU--;
			for (int j = 0; j < 2 * k + 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		for (int k = 0; k < n; k++) {

			for (int i = 0; i < countD; i++) {
				System.out.print(" ");
			}
			countD++;
			for (int j = 0; j < 2 * n - 2 * k - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void Pyramid_v1(int n) {
		int count = 0;

		for (int k = 0; k < n; k++) {

			for (int i = 0; i < count; i++) {
				System.out.print(" ");
			}
			count++;
			for (int j = 0; j < 2 * n - 2 * k - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void Pyramid_v2(int n) {

		for (int k = n; k > 0; k--) {
			for (int i = 0; i < n - k; i++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * k - 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		for (int k = n; k < n; k++) {

			for (int i = 0; i < n - k; i++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * k - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void Trapecia(int n) {

		for (int k = n / 2; k < n; k++) {

			for (int i = 0; i < n - k; i++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * k - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int k = n; k > 0; k--) {

			for (int i = 0; i < n - k; i++) {
				System.out.print(" ");
			}
			for (int j = 2 * k - 1; j > 0; j--) {
				System.out.print("*");

			}
			System.out.println();
		}
	}

	public static void MainDiagonal(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j)
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void SecondDiagonal(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j + 1) % n == 0)
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void SecondDiagonal_v1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j == n - 1)
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void FullDiagonal(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j + 1) % n == 0 || i == j)
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
