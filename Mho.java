//

public class Mho extends Player{


	public Mho(int newX, int newY){

		super(newX, newY);
		x = newX;
		y = newY;

	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
		
	}
	public void Ai(Player p){
		
		if (x == p.x && y == p.y){
			System.out.println("Game Over");
			
		} else if (x == p.x){ //If mho is directly up or down from the player

			if (y < p.y){
				move(0,30); //Up

			} else{
				move(0,-30); //Down

			}
		} else if (y == p.y) {//If mho is directly left or right from the player

			if (x < p.x){
				move(30,0); //right
				
			} else {
				move(-30,0); //left
				
			}
		} else { //Diagonal
			
			if (x<p.x && y<p.y){//up left
				move(30, 30);
				
			} 
			if (x<p.x && y>p.y){//down left
				move(30, -30);
				
			}
			if (x>p.x && y<p.y){ //up right
				move(-30, 30);
				
			}
			if (x>p.x && y>p.y){ // down left
				move(-30, -30);
			}
			
			
		}



	}

}

