
public class Fence {
	protected int x,y;
	protected static final int SIZE = 40;
	public Fence(){
		
	}
	public Fence(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public static int getSize() {
		return SIZE;
	}
}
