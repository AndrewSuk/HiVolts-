import java.util.ArrayList;

//

public class Mho extends MobileObject{


	public Mho(int x, int y){

		
		this.x = x;
		this.y = y;

	}
	public void updatePosition(Player p){
		
	}
	public boolean canMove(ArrayList<Fence> fences){

		for(Fence fence:fences){
			if (fence.getX() == this.x  && fence.getY() == this.y){
				System.out.print(this.x + " ");
				System.out.println(this.x);
				//mhos.remove(mho);
				return false;
			}
		}
		return true;

	}
}

