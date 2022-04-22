public class Test {

	public static void vector() {
		Vector x = new Vector(1.0, 2.0, 3.0, 4.0);
		Vector y = new Vector(5.0, 6.0, 7.0, 8.0);
		System.out.println("x    : " + x);
		System.out.println("y    : " + y);
		System.out.println("x+y  : " + x.plus(y));
		System.out.println("10x  : " + x.times(10));
		System.out.println("|x|  : " + x.magnitude());
		System.out.println("x.y  : " + x.dot(y));
		System.out.println("|x-y|: " + x.minus(y).magnitude());
	}

	public static void matrix() {
		Matrix m = new Matrix(2, 3);
		m.randomize();
		System.out.println(m);
		m.scale(100);
		System.out.println(m);
		System.out.println(Matrix.T(m));
		System.out.println(Matrix.add(m, m));
	}

	public static void main(String[] args) {
		
	}
}
