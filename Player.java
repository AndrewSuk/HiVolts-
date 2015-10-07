//
public class Player {
	
	int x,y, xOld, yOld;
	final int SIZE = 20;
	
	public Player(int newX, int newY){
		
		x = newX;
		y = newY;
		
	}
	public Player(){
		
	}
	public void move(int distanceX, int distanceY){
		xOld=x;
		yOld=y;
		x+=distanceX;
		y+=distanceY;
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
	public int getxOld() {
		return xOld;
	}
	public void setxOld(int xOld) {
		this.xOld = xOld;
	}
	public int getyOld() {
		return yOld;
	}
	public void setyOld(int yOld) {
		this.yOld = yOld;
	}
}
