package practice.codility.challenges;
class Demo
{
	public int solution(int[] A)
	{
		int p = -1;
		for (int i = 0; i < A.length; i++) {
			long leftSum = 0;
			long rightSum = 0;
			for (int x = 0; x < i; x++) {
				leftSum += A[x];
			}
			for (int y = i + 1; y < A.length; y++) {
				rightSum += A[y];
			}
			if (leftSum == rightSum) {
				p = i;
				break;
			}
		}
		return p;
	}

	public int solution2(int[] A)
	{
		int p = -1;
		long leftSum = 0;
		long rightSum = 0;
		for (int y = 1; y < A.length; y++) {
			rightSum += A[y];
		}
		for (int i = 0; i < A.length; i++) {
			if (i != 0) {
				leftSum += A[i - 1];
				rightSum -= A[i];
			}
			if (leftSum == rightSum) {
				p = i;
				break;
			}
		}
		return p;
	}

	public static void main(String args[])
	{
		Demo solution = new Demo();
		int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };
		System.out.println(solution.solution2(A));
	}
}