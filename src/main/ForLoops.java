package main;

import java.util.ArrayList;

import models.array.KthPermutationSequence;
import models.array.PermutationRank;
import models.array.PermutationRankArrayEditorial;
import models.array.PermutationRankArrayFastest;
import models.array.PermutationRankEditorial;
import models.array.PermutationRankFastest;
import models.array.PermutationRankLightWeight;

public class ForLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// System.out.println(new Factorial().get_factorial_rec(n));
		// System.out.println("FLOYDS TRIANGLE");
		// new Triangles().FloydsTriangle(n);
		// System.out.println("FLOYDS TRIANGLE_v1");
		// new Triangles().FloydsTriangle_v1(n);
		// System.out.println("PYRAMID");
		// new Triangles().Pyramid(n);
		// System.out.println("PYRAMID_v1");
		// new Triangles().Pyramid_v1(n);
		// System.out.println("PYRAMID_MIRROR");
		// new Triangles().Pyramid_mirror(n);
		// System.out.println("PYRAMID_v2");
		// new Triangles().Pyramid_v2(n);
		// System.out.println("TRAPECYA");
		// new Triangles().Trapecia(n);
		// System.out.println("MAIN DIAGONAL");
		// new Triangles().MainDiagonal(n);
		// System.out.println("SECOND DIAGONAL");
		// new Triangles().SecondDiagonal(n);
		// System.out.println("SECOND DIAGONAL v1");
		// new Triangles().SecondDiagonal_v1(n);
		// System.out.println("FULL DIAGONAL");
		// new Triangles().FullDiagonal(n);
		// System.out.println("FIND GAP " + Integer.toBinaryString(n));
		// System.out.println(new FindGap().Find_Gap(n));
		// System.out.println("FIND FIBONACCI NUMBERS ITERATIVE ");
		// new FibonacciNumbers().Get_Fib_Iterative(n);
		// System.out.println("\nFIND FIBONACCI NUMBERS RECURSIVE ");
		// new FibonacciNumbers().Print_N_Fibonacci(n);
		// System.out.println("\nREVERSE AN ARRAY TEMPORARY HALF");
		// int[] a = new ReverseArray().reverseArrayTemporaryHalf(new int[] { 1, 2, 3,
		// 4, 5, 6, 7, 8, 9 });
		// new Array().printArray(a);
		// System.out.println("\nREVERSE AN ARRAY TEMPORARY HALF XOR");
		// int[] b = new ReverseArray().reverseArrayTemporaryHalfXor(new int[] { 1, 2,
		// 3, 4, 5, 6, 7, 8, 9 });
		// new Array().printArray(b);
		// System.out.println("\nLOGICAL TEST");
		// System.out.println(new LogicalOperators().logical_operator(true, false,
		// false, true));
		// // 0011 1100 0101 1010 0110 1001
		// System.out.println("\nFIND ODD OCCURENCESS BRUTE FORCE");
		// System.out.println(new FindOddOccurences().get_odd_occurences_brute_force(new
		// int[] { 9, 3, 9, 3, 9, 7, 9 }));
		// System.out.println("\nFIND ODD OCCURENCESS BRUTE WITH HASHSET");
		// System.out.println(new FindOddOccurences().get_odd_occurences_optimal_v1(new
		// int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 }));
		// System.out.println("\nFIND ODD OCCURENCESS BRUTE WITH XOR");
		// System.out.println(new FindOddOccurences().get_odd_occurences_optimal_v2(new
		// int[] { 9, 3, 9, 3, 9, 7, 9 }));
		// System.out.println("\nCYCLICALY ROTATE AN ARRAY BY ONE");
		// new Array().printArray(new RotateArray().rotate_by_one(new int[] { 6, 3, 8,
		// 7, 9 }));
		// System.out.println("\nCYCLICALY ROTATE AN ARRAY BY ONE K STEPS");
		// new Array().printArray(new RotateArray().rotate_by_one_k_steps(new int[] { 6,
		// 3, 8, 7, 9 }, 3));
		// System.out.println("\nCYCLICALY ROTATE AN ARRAY BY K STEPS");
		// new Array().printArray(new RotateArray().rotate_by_k_steps_brute_force(new
		// int[] { 1 }, 3));
		// System.out.println("\nCYCLICALY ROTATE AN ARRAY BY EXTRA ARRAY");
		// new Array().printArray(new RotateArray().rotate_by_k_steps_extra_array(new
		// int[] { 1, 2, 3, 4, 5 }, 2));
		// System.out.println("\nCYCLICALY ROTATE AN ARRAY BY REVERSE");
		// new Array().printArray(new RotateArray().rotate_by_k_steps_using_reverse(new
		// int[] { 1, 2, 3, 4, 5 }, 2));
		// System.out.println("\nPERMUTATION ");
		// System.out.println(new Permutation().getPermutation(3, 3));
		// System.out.println("\nREVERSE STRING");
		// System.out.print(new ReverseString().reverseString("hello"));
		// System.out.println("\nFROG JUMP");
		// System.out.print(new FrogJump().get_jump(10, 85, 30));
		// System.out.println("\nTAPE EQUILIBRIUM BRUTE FORCE SOLUTION");
		// System.out.print(new TapeEquilibrium().getEquilibrium_brute_force(new int[] {
		// 3, 1, 2, 4, 3 }));
		// System.out.println("\nTAPE EQUILIBRIUM OPTIMAL SOLUTION");
		// System.out.print(new TapeEquilibrium().getEquilibrium_optimal(new int[] { 3,
		// 1, 2, 4, 3 }));
		// System.out.println("\nINTEGER SUM BRUTE FORCE SOLUTION");
		// System.out.println(new IntegerSum().getSum_brute_force(1000));
		// System.out.println("INTEGER SUM OPTIMAL SOLUTION_V1");
		// System.out.println(new IntegerSum().getSum_optimal_v2(1000));
		// System.out.println("INTEGER SUM OPTIMAL SOLUTION_V2");
		// System.out.println(new IntegerSum().getSum_optimal_v2(1000));
		// System.out.println("STRING PERMUTATION V1");
		// new Permutation().getPermutation_v1("ABC");
		// System.out.println("\nSTRING PERMUTATION V2");
		// new Permutation().getPermutation_v2("ABC");
		// System.out.println("\nSTRING PERMUTATION V3");
		ArrayList<Integer> listInput = new ArrayList<>();
		listInput.add(1);
		listInput.add(2);
		listInput.add(3);
		// new ListPermutation().printList(new ListPermutation().permute(listInput));
		System.out.println("\nGET Kth PERMUTATION");
		System.out.println(new KthPermutationSequence().getKthPermutation(3, 3));
		// System.out.println("\nGET ALL PERMUTATION ");
		// ListPermutation.printList(new ListPermutation().permute_v1(new int[] { 1, 1,
		// 2 }));
		// System.out.println("\nGET NEXT PERMUTATION ");
		// int[] a = new int[] { 1, 2, 1 };
		// NextPermutation.get_nextPermutation(a);
		// new Array().printArray(a);
		// System.out.println("\nALL CASE PERMUTATIONS ");
		// AllCasePermutation.permute("ab");
		// System.out.println("\nLIST OF LIST PERMUTATIONS ");
		// PermutingListOfList.permute(new String[][] { { "a1", "b1", "c1" }, { "a2",
		// "b2", "c2" } });
		// System.out.println(getPermutation(2, 2));
		System.out.println("\nGET Kth PERMUTATION FASTEST");
		System.out.println(KthPermutationSequence.getPermutationFastest(3, 3));
		System.out.println("\nGET Kth PERMUTATION LIGHTWEIGHT");
		System.out.println(KthPermutationSequence.getPermutationLightWeight(3, 3));
		System.out.println("\nGET Kth PERMUTATION LIGHTWEIGHT V1");
		System.out.println(KthPermutationSequence.getPermutationLightWeight_v1(3, 3));
		System.out.println("\nGET Kth PERMUTATION LIGHTWEIGHT WITH ARRAY");
		System.out.println(KthPermutationSequence.getPermutationArrayLightWeight(3, 3));
		System.out.println("\nGET Kth PERMUTATION FASTEST WITH ARRAY");
		System.out.println(KthPermutationSequence.getPermutationArrayFastest(3, 3));
		// System.out.println("\nGET NEXT PERMUTATION WITH ARRAYLIST");
		// NextPermutation.get_nextPermutation(listInput);
		// System.out.println(listInput.toString());
		// System.out.println("\nGET NEXT PERMUTATION EDITORIAL");
		// NextPermutation.get_nextPermutationEditorial(listInput);
		// System.out.println(listInput.toString());
		System.out.println(PermutationRank.getPermutationRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankEditorial().getRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankFastest().getRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankLightWeight().getRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankArrayEditorial().getRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankArrayEditorial().findRank("DTNGJPURFHYEW"));
		System.out.println(new PermutationRankArrayFastest().getRank("DTNGJPURFHYEW"));
	}

}