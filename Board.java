import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

//

public class Board {

	ArrayList<Fence> perimeterFences = new ArrayList<Fence>();//Creates an empty arrayList of Perimeter Fences
	ArrayList<Fence> interiorFences = new ArrayList<Fence>();
	ArrayList<Mho> mhos = new ArrayList<Mho>();
	Player p = new Player();

	ArrayList<Integer> openSpaces = new ArrayList<Integer>();

	final int STEP = 30;
	final int OFFSET = 70;

	public Board(){
		makePerimeter();


		makeOpenSpaces();
		//System.out.println(openSpaces.size());

		makeRandomFences();
		for (int i=0;i<20;i++){
			//System.out.print(interiorFences.get(i).getX());
			//System.out.println(" " + interiorFences.get(i).getY());
		}
		makeMhos();
		makePlayer();

	}

	public int randInt(int min, int max){
		int range = max-min + 1;
		return (int) (Math.random() * range) + min;
	}

	public int gridToCoords(int coord){
		return (coord*STEP)+OFFSET;
	}

	//Converts a space number(0-100), into an x grid Coordinate (0-12)
	public int spaceToXGrid(int a){

		return a%10 +1;

	}

	public int spaceToXCoord(int a){
		return gridToCoords(spaceToXGrid(a));
	}
	//Converts a space number(0-100), into a y grid Coordinate (0-12)
	public int spaceToYGrid(int a){

		return a/10 +1;

	}

	public int spaceToYCoord(int a){
		return gridToCoords(spaceToYGrid(a));
	}
	//initializes the openSpaces array to have 100 spaces
	public void makeOpenSpaces(){

		for (int i=0;i<100;i++){
			openSpaces.add(i);
		}
	}

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

	public void makeRandomFences(){

		for (int i=0;i<20;i++){
			//finds a random open space
			int space = findOpenSpace();
			///adds a fence to that space
			interiorFences.add(new Fence(spaceToXCoord(space), spaceToYCoord(space)));
		}

	}

	public void makeMhos(){

		for (int i=0;i<12;i++){
			//finds a random open space
			int space = findOpenSpace();

			//adds a mho to that space
			mhos.add(new Mho(spaceToXCoord(space), spaceToYCoord(space)));
		}
	}

	public void makePlayer(){
		int space = findOpenSpace();
		p.setX(spaceToXCoord(space));
		p.setY(spaceToXCoord(space));

	}
	
	//encapsulate?
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
