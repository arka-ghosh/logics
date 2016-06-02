package practice.codility.challenges;
class RakutenTest
{
	public int solution(int[] A)
	{
		int p = 0;
		long bigBinarian = 0;
		for (int y = 0; y < A.length; y++) {
			bigBinarian += Math.pow(2, A[y]);
		}
		while (true) {
			int x = 1;
			while (true) {
				long smallBinarian = (long) Math.pow(2, x);
				if (smallBinarian > (bigBinarian)) {
					bigBinarian = bigBinarian - (smallBinarian / 2);
					p++;
					break;
				}
				x++;
			}
			if (bigBinarian == 0) {
				break;
			}
		}

		return p;
	}

	public static void main(String args[])
	{
		RakutenTest solution = new RakutenTest();
		int[] A = { 1, 0, 2, 0, 0, 2 };
		System.out.println(solution.solution(A));
	}
}