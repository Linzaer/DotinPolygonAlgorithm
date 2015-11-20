package com.bearhunter;

/**
 * @author Linzai 点在多边形内算法
 */
public class DotinPolygon {

	public static void main(String[] args) {
		boolean f = false;
		Dot testdot = new Dot(1,0);
		Dot[] Dots = { new Dot(0, 0), new Dot(0, 2), new Dot(0.1, 2.1),
				new Dot(0.2, 2.2), new Dot(0.3, 2.3), new Dot(0.4, 2.4),
				new Dot(0.5, 2.5), new Dot(0.6, 2.6), new Dot(0.7, 2.7),
				new Dot(0.8, 2.8), new Dot(0.9, 2.9), new Dot(2, 2),
				new Dot(2, 0) };
		long beforetime = System.currentTimeMillis();
		DotinPolygon dotinPolygon = new DotinPolygon();
		for (int i = 0; i < 1000; i++) {
			f = dotinPolygon.pointInPolygon(Dots, testdot);
		}
		long aftertime = System.currentTimeMillis();
		System.out.println("算法耗时 ：" + (aftertime - beforetime) + "毫秒。");
		System.out.println(f ? "在内部" : "不在内部");
	}

	/**
	 * 射线法
	 * 
	 * @param Dots
	 * @param testdot
	 * @return
	 */
	public boolean pointInPolygon(Dot[] Dots, Dot testdot) {

		int i, j = Dots.length - 1;
		boolean oddNodes = false;

		for (i = 0; i < Dots.length; i++) {
			if ((Dots[i].getY() < testdot.getY()
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
