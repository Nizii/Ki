import java.util.ArrayList;

public class Level {
	static ArrayList<Integer> tempMemory;
	static int links = 0;
	static int rechts = 0;
	static int standort = 3;
	static int s;
	static boolean verletzt = true;
	static int schritt = 0;
	static int routine = 1;
	
	public Level() {
	
	}
	
	public static void schritt() {
		Gui.setResulttext(" ");
		int min = 0;
		int max = 1;
		schritt++;

		verletzt = true;
		tempMemory = Memory.getMemory();
		links = (int)(Math.random() * ((max - min) + 1)) + min;
		if (links == 0) {
			rechts = 1;
		} else {
			rechts = 0;
		}
		
		System.out.println();
		System.out.println("Schritt: " + schritt + " || Routine: " + routine);
		System.out.println();
		System.out.println("Level");
		System.out.println(links + " (*_*) " + rechts);
		System.out.println();
		
		standort = goLeft();
		s = think();
		if (routine == 3){
			tempMemory.add(0);
			System.out.println("Ki hat gelernt das die 1 sicher ist ohne zu sterben");
			System.out.println("Ki schliesst die 0 aus");
			System.out.println("Ki hat richtig entschieden und lebt");
			String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() + "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n" + "Ki hat gelernt das die 1 sicher ist ohne zu sterben" + "\n" + "Ki schliesst die 0 aus" + "\n" + "Ki hat richtig entschieden und lebt"; 
			Gui.setText(guiText);
			routine++;
		} else {
			
		if (standort == 0 && !(s == 0)) {
			System.out.println("Ki schaut nach links");
			System.out.println("Ki geht nach links");
			System.out.println("Ki hat falsch entschieden");
			String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() +  "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n" + "Ki schaut nach links" + "\n" + "Ki geht nach links" + "\n" + "Ki hat falsch entschieden";
			Gui.setText(guiText);
			Memory.addThoughts(standort);
			verletzt = false;
			
		} else if (standort == 0 && s == 0) {
			standort = goRight();
					System.out.println("Ki schaut nach links");
					System.out.println("Ki erkennt die Gefahr links und geht nicht nach links");
					System.out.println("Ki schaut nach rechts");
					System.out.println("Ki geht nach rechts");
					System.out.println("Ki hat richtig entschieden");
					String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() +  "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n" + "Ki schaut nach links"+ "\n" + "Ki erkennt die Gefahr links und geht nicht nach links" + "\n" + "Ki schaut nach rechts" + "\n" + "Ki geht nach rechts" + "\n" + "Ki hat richtig entschieden";
					Gui.setText(guiText);
					routine++;
					
				} else if (standort == 1 && s == 1) {
					System.out.println("Ki schaut nach links");
					System.out.println("Ki geht nach links");
					System.out.println("Ki hat richtig entschieden");
					String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() +  "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n"+ "Ki schaut nach links"+ "\n" +"Ki geht nach links"+ "\n" + "Ki hat richtig entschieden";
					Gui.setText(guiText);
					routine++;
				}
			
			if (standort == 0 && !(s == 0) && verletzt == true) {
				System.out.println("Ki schaut nach rechts");
				System.out.println("Ki geht nach rechts");
				System.out.println("Ki hat falsch entschieden");
				String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() +  "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n Ki schaut nach rechts \n Ki geht nach rechts \n Ki hat falsch entschieden";
				Gui.setText(guiText);
				Memory.addThoughts(standort);
				verletzt = false;
				
			} else if (standort == 0 && s == 0 && verletzt == true) {
				System.out.println("Ki schaut nach rechts");
				System.out.println("Ki geht nach rechts");
				System.out.println("Ki hat richtig entschieden");
				String guiText = "Schritt: " + schritt + " || Routine: " + routine + " || Blick ins Gehirn: " + Memory.getMemory() +  "\n" + "\n" +"Level" + "\n" + links + " (*_*) " + rechts + "\n \n Ki schaut nach rechts \n Ki geht nach rechts \n Ki hat richtig entschieden";
				Gui.setText(guiText);
				routine++;
			} else if (verletzt == false) {
				System.out.println("Ki ist verletzt");
			}
		}
	}
	
	
	public static int goLeft(){
		return links;
	}
	
	public static int goRight(){
		return rechts;
	}
	
	public static int think(){
		for(int i = 0; i < tempMemory.size(); i++){
			if (tempMemory.get(i) == standort){
				s = 0;
			} else {
				s = 1;
			}
		}
		return s;
	}

	public static void setSchritt() {
		schritt = 0;
	}
	
	public static void setRoutine() {
		routine = 1;
	}
}
