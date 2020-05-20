package hackerearth.hiring.paypal;

/**
 * There are N buildings in a locality. Each building must be painted with a type of paint. Initially,some buildings are painted with some
 * type of paint. The building that is painted cannot be painted again. You are given M types of paints.1 to M inclusive. The speciality of
 * the locality is defined as the number of contiguous  buildings that are painted with same type of paint. For Example, if six buildings
 * apartment are painted from left to right are (1,2,1,1,3) then the likelihood of the apartment is 4{{1},{2},{1,1},{3,3}}.
 * You are given an N8M matrix,where the ith row and jth column denotes the painting cost of the ith building with jth type of paint.
 * <p>
 * You are required to determine the minimum cost to paint all the buildings such that the speciality of the apartment is exactly K.
 * If it is not possible to paint all  building such that the likelihood of the apartment is exactly k. then print -1.
 * <p>
 * Input Format
 * a) The first line contains T denoting the number of test cases.
 * b) For each test case :
 * 1) The next line contains N,M, and K where N is the number of buildings in a locality, M is the number of types of paints, and K is the speciality
 * of the locality respectively.
 * 2)The next line contains N space separated integers where the ith Integer is either 0 or the type of paint from which the ith building is
 * already painted. Here 0 means that the building is not painted.
 * 3) The next line contains M space separated integers where the ith row and jth column denote the painting cost(cost ij) of the ith building with
 * the jth paint type.
 * <p>
 * Output format
 * <p>
 * Print the minimum cost to paint all building such that the speciality of the apartment is exactly K. If it is not possible to paint
 * all building such that the likelihood of the apartment is exactly k, then print -1.
 * <p>
 * Constraints
 * <p>
 * 1 <= T <= 10
 * 1 <= K <= N <= 100
 * 1 <= M <= 100
 * 1 <= COSTij <= 10^9
 * <p>
 * Sample Input
 * <p>
 * 1
 * 4 2 1
 * 0 0 0 2
 * 100 20
 * 30 59
 * 71 81
 * 9 200
 * <p>
 * Sample Output
 * 160
 */
public class PaintingBuilding {


}
