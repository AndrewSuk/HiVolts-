//
import java.util.ArrayList;
public class Player extends MobileObject{
	
	public Player(){
	
		
	}
	
	public boolean canMove(ArrayList<Fence> fences, ArrayList<Mho> mhos){
		for(int i=0;i<Board.numInteriorFences;i++){
			if (fences.get(i).getX() == this.x && fences.get(i).getY() == this.y){
				System.out.println("landed on fence");
				return false;
			}
			if (i<HFrame.b.mhos.size() && mhos.get(i).getX() == this.x && mhos.get(i).getY() == this.y){
				System.out.println("landed on mho");

				return false;
			}
		}
		return true;
		
	}
}
