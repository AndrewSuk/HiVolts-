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

	public void paint(Graphics g){

		drawFences(g);
		drawMhos(g);
		drawPlayer(g);

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
/*
		switch (e.getKeyCode()){

		case KeyEvent.VK_W: b.p.move(0, -b.STEP);
			repaint();
		case KeyEvent.VK_A: b.p.move(-b.STEP, 0);
			repaint();
		case KeyEvent.VK_X: b.p.move(0,b.STEP);
			repaint();
		case KeyEvent.VK_D: b.p.move(b.STEP,0);
			repaint();


		System.out.println(b.p.getX());
		System.out.println(b.p.getY());
		repaint();
		}*/

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
