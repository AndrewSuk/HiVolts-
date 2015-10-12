import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class HFrame extends JFrame implements KeyListener{

	private final int frameSizeX = 1000;
	private final int frameSizeY = 900;
	
	public HFrame(){
		setSize(frameSizeX,frameSizeY);
		setBackground(Color.WHITE);
		this.addKeyListener(this);
		repaint();
	}

	public static Board b = new Board();
	boolean gameStarted = false;
	boolean gameOver = false;

	public void paint(Graphics g){
		/*if (gameOver){
			gameOver(g);
			System.out.println("Game Over");
		}*/
		if (!gameStarted){
			drawFences(g);
			gameStarted = true;
		}

		//b.updateMhos();
		drawMhos(g);
		drawPlayer(g);
		clearMhos(g);

		clearPlayer(g);
		b.checkMhos();
		
		
	}

	public void drawFences(Graphics g){
		g.setColor(Color.BLACK);
		drawInteriorFences(g);
		drawPerimeterFences(g);
	}
	public void drawInteriorFences(Graphics g){

		for (Fence fence:b.interiorFences){
			g.fillRect(fence.getX(), fence.getY(),fence.SIZE,fence.SIZE);
		}
	}
	public void drawPerimeterFences(Graphics g){

		for (Fence fence:b.perimeterFences){
			g.fillRect(fence.getX(), fence.getY(),fence.SIZE,fence.SIZE);
		}

	}
	public void drawMhos(Graphics g){
		g.setColor(Color.RED);
		for(Mho mho:b.mhos){
			g.fillRect(mho.getX(), mho.getY(), mho.SIZE, mho.SIZE);
		}
	}
	public void clearMhos(Graphics g){
		for(Mho mho:b.mhos){
			g.clearRect(mho.getxOld(),mho.getyOld(),mho.SIZE,mho.SIZE);
		}
	}
	public void drawPlayer(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(b.p.getX(),b.p.getY(),b.p.SIZE,b.p.SIZE);

	}
	public void clearPlayer(Graphics g){
		g.clearRect(b.p.getxOld(),b.p.getyOld(),b.p.SIZE,b.p.SIZE);
	}



	String[] keys = {"q","w","e","a","s","d","z","x","s","c","j"};
	int STEP = MobileObject.STEP;
	@Override
	public void keyPressed(KeyEvent e) {

		//Converts e.getKeyChar() to a string
		String keyPressed =  e.getKeyChar() + "";

		//only works if the player can move
		if (b.p.canMove(b.interiorFences, b.mhos) == true && contains(keys,keyPressed)){
			//System.out.println("valid key pressed");
			switch (keyPressed){

			case "w": 
				b.p.moveUp();
				break;
			case "a": 
				b.p.moveLeft();
				break;
			case "x": 
				b.p.moveDown();
				break;
			case "d": 
				b.p.moveRight();
				break;
			case "q":
				b.p.moveUpLeft();
				break;
			case "e":
				b.p.moveUpRight();
				break;

			case "z":
				b.p.moveDownLeft();
				break;
			case "c":
				b.p.moveDownRight();
				break;
			case "j":
				b.jump(b.p);
				break;

			}
			if (keyPressed != "j"){
				for (Mho mho:b.mhos){
					//Doesnt work
					mho.updatePosition(b.p);
				}
			} 

			
		} 
		
		repaint();

	}
	public void gameOver(Graphics g){
		g.drawString("Game Over", 100, 100);
	}
	public boolean contains(String[] a, String b){
		for (String element:a){
			if (element.equals(b)){

				return true;
			}
		}
		return false;
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {


	}

}
