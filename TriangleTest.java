package chapter1;

import inf.v3d.view.Viewer;

public class TriangleTest {

	public static void main(String[] args) {
		Triangle test = new Triangle();
		test.printAttribute();
		//test.draw(test);
		Viewer z = new Viewer();
		double area = test.Area();
		System.out.println(area);
		test.draw(z);
		test.drawCircle(z);
		System.out.println(test.checkPoint(1, 1));
		System.out.println(test.checkPoint(0.4, 0.5));

	}

}
