
public class PassbyRefVSPassbyVal {
	static class Point{
		private int x;
		private int y;
		public Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void tricky(Point arg1, Point arg2){
		arg1.x=100;
		arg1.y=100;
		Point tmp = arg1;
		arg1=arg2;
		arg2=tmp;
	}
	public static void main(String[] args){
		Point pt1 = new Point(0,0);
		Point pt2 = new Point(0,0);
		System.out.println("X: "+pt1.x+" Y: "+pt1.y);
		System.out.println("X: "+pt2.x+" Y: "+pt2.y);
		tricky(pt1,pt2);
		System.out.println("X: "+pt1.x+" Y: "+pt1.y);
		System.out.println("X: "+pt2.x+" Y: "+pt2.y);
	}
}
