import java.util.Arrays;

public class ArrayAlgorithm {

	public void reverse(long[] arr) {
		for (int i = 0, j = arr.length - 1; i != j; i++, j--) {
			long temp = arr[i];
			arr[i] = arr[j];
			arr[j] = arr[i];
		}
	}

	public static void main(String[] args) throws Exception {
		var arr = new long[]{30,10,70,50,60,20,40};
		var alg = new ArrayAlgorithm();
		alg.reverse(arr);
		Arrays.stream(arr)
			.forEach(elem -> System.out.print(elem+"\t"));
	}
}