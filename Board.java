import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

//

public class Board {
	
	//Lists that store all of the objects on the board
	ArrayList<Fence> perimeterFences = new ArrayList<Fence>();
	ArrayList<Fence> interiorFences = new ArrayList<Fence>();
	ArrayList<Mho> mhos = new ArrayList<Mho>();
	Player p = new Player();

	//Stores the positions of all the empty spaces
	ArrayList<Integer> openSpaces = new ArrayList<Integer>();

	//how far each entity moves
	final int STEP = 30;
	
	final int OFFSET = 100;

	//Constructs a new Board with all of the fences, mhos, and player. Also initializes the openSpaces method.
	public Board(){
		makePerimeter();

		makeOpenSpaces();


		makeRandomFences();

		makeMhos();
		makePlayer();

	}

	/**
	 * generates a random number between a minimum and maximum value
	 * @param min is the lowest possible value
	 * @param max is the highest possible
	 * @return returns the random integer
	 */
	public int randInt(int min, int max){
		int range = (max-min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public int gridToCoords(int coord){
		return (coord*STEP)+OFFSET;
	}

	/**
	 * Converts a space number(0-99) to a x grid coordinate(1-12)
	 * main purpose is to serve as an intermediate method for spaceToXCoord
	 * @param a is the space number
	 * @return returns the corresponding x grid coordinate
	 */
	public int spaceToXGrid(int a){

		return a%10 +1;

	}
	/**
	 * Converts a space number(0-99) to a x coordinate
	 * @param a is the space number
	 * @return returns the x coordinate
	 */
	public int spaceToXCoord(int a){
		return gridToCoords(spaceToXGrid(a));
	}

	/**
	 * Converts a space number(0-99) to a y grid coordinate(1-12)
	 * main purpose is to serve as an intermediate method for spaceToYCoord
	 * @param a is the space number
	 * @return returns the corresponding y grid coordinate
	 */
	public int spaceToYGrid(int a){

		return a/10 +1;

	}
	/**
	 * Converts a space number(0-99) to a y coordinate
	 * @param a is the space number
	 * @return returns the y coordinate
	 */
	public int spaceToYCoord(int a){
		return gridToCoords(spaceToYGrid(a));
	}
	/**
	 * Initializes the openSpaces array to have 100 spaces
	 * these 100 spaces are the 100 that are on the interior of the perimeter
	 */
	public void makeOpenSpaces(){

		for (int i=0;i<100;i++){
			openSpaces.add(i);
		}
	}
	/**
	 * makes the fences that are on the perimeter
	 */
	public void makePerimeter(){

		for(int i=0;i<12;i++){
			//top and bottom rows
			perimeterFences.add(new Fence(gridToCoords(i),gridToCoords(0)));

			perimeterFences.add(new Fence(gridToCoords(i),gridToCoords(11)));

			//left and right columns
			if (i!=0 && i!=11){
				perimeterFences.add(new Fence(gridToCoords(0), gridToCoords(i)));

				perimeterFences.add(new Fence(gridToCoords(11), gridToCoords(i)));
			}
		}
	}
	
	/**
	 * makes the randomly generated fences
	 */
	public void makeRandomFences(){

		for (int i=0;i<20;i++){
			//finds a random open space
			int space = findOpenSpace();
			///adds a fence to that space
			interiorFences.add(new Fence(spaceToXCoord(space), spaceToYCoord(space)));
		}

	}

	/**
	 * makes the randomly generated mhos
	 */
	public void makeMhos(){

		for (int i=0;i<12;i++){
			//finds a random open space
			int space = findOpenSpace();

			//adds a mho to that space
			mhos.add(new Mho(spaceToXCoord(space), spaceToYCoord(space)));
		}
	}

	/**
	 * makes the player
	 */
	public void makePlayer(){
		int space = findOpenSpace();
		p.setX(spaceToXCoord(space));
		p.setY(spaceToXCoord(space));

	}

	//encapsulate?
	/**
	 * finds a random open space on the board, and makes it an occupied space
	 * @return returns the random space on the board
	 */
	public int findOpenSpace(){
		//Picks a random non-occupied square
		int index = randInt(0,openSpaces.size()-1);
		int randNum = openSpaces.get(index);

		//Takes the last element of the array and set it to the index of the square that was just picked
		openSpaces.set(index, openSpaces.get(openSpaces.size()-1));

		//removes the last index
		openSpaces.remove(openSpaces.size()-1);

		return randNum;
	}

}
