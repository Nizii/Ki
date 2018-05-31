import java.util.ArrayList;

public class Memory {
	static ArrayList<Integer> negativeExperience;
	
	public Memory() {
		negativeExperience = new ArrayList<>();
		negativeExperience.add(3);
	}
	
	public static void addThoughts(int i) {
		negativeExperience.add(i);
	}
	
	public static void deleteThoughts() {
		negativeExperience.clear();
		negativeExperience.add(3);
		Gui.setResulttext("Erinnerungen Gelöscht!");
	}
	
	public static ArrayList getMemory() {
		return negativeExperience;
	}
}
