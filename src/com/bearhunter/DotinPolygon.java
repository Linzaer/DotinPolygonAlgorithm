package com.bearhunter;

/**
 * @author Linzai ���ڶ�������㷨
 */
public class DotinPolygon {

	public static void main(String[] args) {
		Dot testdot = new Dot(1.9, 1.9);
		Dot[] Dots = { new Dot(0, 0), new Dot(0, 2),/* new Dot(0.1, 2.1),
				new Dot(0.2, 2.2), new Dot(0.3, 2.3), new Dot(0.4, 2.4),
				new Dot(0.5, 2.5), new Dot(0.6, 2.6), new Dot(0.7, 2.7),
				new Dot(0.8, 2.8), new Dot(0.9, 2.9), */new Dot(2, 2),
				new Dot(4, 0) };
		long beforetime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {

			System.out
					.println(new DotinPolygon().pointInPolygon(Dots, testdot));
		}
		long aftertime = System.currentTimeMillis();
		System.out.println("�㷨��ʱ ��" + (aftertime - beforetime) + "���롣");
	}

	/**
	 * ���߷�
	 * 
	 * @param Dots
	 * @param testdot
	 * @return
	 */
	public String pointInPolygon(Dot[] Dots, Dot testdot) {

		int i, j = Dots.length - 1;
		boolean oddNodes = false;

		for (i = 0; i < Dots.length; i++) {
			if ((Dots[i].getX() < testdot.getX()
					&& Dots[j].getY() >= testdot.getY() || Dots[j].getY() < testdot.getY() && Dots[i].getY() >= testdot.getY())
					&& (Dots[i].getX() <= testdot.getX() || Dots[j].getX() <= testdot.getX())) {
				oddNodes ^= (Dots[i].getX() + (testdot.getY() - Dots[i].getY())
						/ (Dots[j].getY() - Dots[i].getY())
						* (Dots[j].getX() - Dots[i].getX()) < testdot.getX());
			}
			j = i;
		}

		return oddNodes ? "�õ����ڲ�" : "�õ㲻���ڲ�";
	}
}

/**
 * 
 * @author Linzai ������
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
