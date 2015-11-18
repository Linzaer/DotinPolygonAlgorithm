package com.bearhunter;

/**
 * @author Linzai 点在多边形内算法
 */
public class DotinPolygon {

	public static void main(String[] args) {
		Dot testdot = new Dot(0.36, 0.45);
		Dot[] Dots = { new Dot(0, 0), new Dot(0, 2), new Dot(2, 2),
				new Dot(0, 2) };

		System.out.println(new DotinPolygon().pointInPolygon(Dots, testdot));
	}

	/**
	 * 射线法
	 * @param Dots
	 * @param testdot
	 * @return
	 */
	public boolean pointInPolygon(Dot[] Dots, Dot testdot) {

		int i, j = Dots.length - 1;
		boolean oddNodes = false;

		for (i = 0; i < Dots.length; i++) {
			if ((Dots[i].getX() < testdot.getX()
					&& Dots[j].getY() >= testdot.getY() || Dots[j].getY() < testdot
					.getY() && Dots[i].getY() >= testdot.getY())
					&& (Dots[i].getX() <= testdot.getX() || Dots[j].getX() <= testdot
							.getX())) {
				oddNodes ^= (Dots[i].getX() + (testdot.getY() - Dots[i].getY())
						/ (Dots[j].getY() - Dots[i].getY())
						* (Dots[j].getX() - Dots[i].getX()) < testdot.getX());
			}
			j = i;
		}

		return oddNodes;
	}
}

/**
 * 
 * @author Linzai 点坐标
 */
class Dot {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Dot(double d, double e) {
		super();
		this.x = d;
		this.y = e;
	}

}
