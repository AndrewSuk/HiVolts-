//
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class HFrame extends JFrame implements KeyListener{

	public HFrame(){

		setSize(800,700);
		this.addKeyListener(this);
		repaint();

	}

	Board b = new Board();
	boolean gameStarted = false;

	public void paint(Graphics g){
		if (!gameStarted){
			drawFences(g);
			gameStarted = true;
		}

		drawMhos(g);
		drawPlayer(g);
		g.clearRect(b.p.getxOld(),b.p.getyOld(),b.p.SIZE,b.p.SIZE);

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
	public void drawPlayer(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(b.p.getX(),b.p.getY(),b.p.SIZE,b.p.SIZE);

	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Converts e.getKeyChar() to a string
		String keyPressed =  e.getKeyChar() + "";
		
		//only works if the player can move
		if (b.p.canMove(b.interiorFences, b.mhos) == true){
			
			switch (keyPressed){
			
			case "w": 
				b.p.move(0, -b.STEP);
				repaint();
				break;

			case "a": 
				b.p.move(-b.STEP, 0);
				repaint();
				break;
			case "x": 
				System.out.println("x");
				b.p.move(0,b.STEP);
				repaint();
				break;

			case "d": 
				System.out.println("d");
				b.p.move(b.STEP, 0);
				repaint();
				break;
			}
			if (keyPressed != "j"){
				for (Mho mho:b.mhos){
					mho.Ai(b.p);
					g.clearRect(mho.getxOld(),mho.getyOld(),mho.SIZE,mho.SIZE);
				}
			}
			//call repaint only a the end, call a method called update mhos first
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
