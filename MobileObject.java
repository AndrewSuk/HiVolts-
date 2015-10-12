
public class MobileObject extends Fence {
	protected int xOld,yOld;
	protected static final int STEP = (int)((int) Player.SIZE * 1.5);
	
	public MobileObject() {
		
	}
	
	
	public void move(int STEPX, int STEPY){
		xOld=x;
		yOld=y;
		x+=STEPX;
		y+=STEPY;
	}

	public void moveRight(){
		move(STEP,0);
	}
	public void moveLeft(){
		move(-STEP,0);
	}
	public void moveUp(){
		move(0,-STEP);
	}
	public void moveDown(){
		move(0,STEP);
	}
	public void moveUpRight(){
		move(STEP,-STEP);
	}
	public void moveUpLeft(){
		move(-STEP,-STEP);
	}
	public void moveDownLeft(){
		move(-STEP,STEP);
	}
	public void moveDownRight(){
		move(STEP,STEP);
		
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
