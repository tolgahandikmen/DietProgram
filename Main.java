
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String commandsFile = args[0];
		String peopleFile = "people.txt";
		String foodFile = "food.txt";
		String sportFile = "sport.txt";

		String[][] commands = new String[252000][5];
		String[][] people = new String[50][6];
		String[][] food = new String[100][3];
		String[][] sport = new String[100][3];
		BufferedReader br = null;
		String line = "";
		int lineCounter = 0;
		int personCounter = 0;
		int foodCounter = 0;
		int sportCounter = 0;

		try {

			br = new BufferedReader(new FileReader(commandsFile));
			while ((line = br.readLine()) != null) {

				// use tab character as separator
				String[] columns = line.split("\t");

				for (int j = 0; j < columns.length; j++) {
					commands[lineCounter][j] = columns[j];
				}
				// System.out.println("command: " + commands[lineCounter][0]);
				lineCounter++;
			}
			br.close();

			br = new BufferedReader(new FileReader(peopleFile));
			while ((line = br.readLine()) != null) {

				// use tab character as separator
				String[] clm = line.split("\t");

				for (int j = 0; j < clm.length; j++) {
					people[personCounter][j] = clm[j];
				}
//				System.out.println("people: " + people[personCounter][1]);
				personCounter++;
			}
			br.close();
			
			br = new BufferedReader(new FileReader(foodFile));
			while ((line = br.readLine()) != null) {

				// use tab character as separator
				String[] clm = line.split("\t");

				for (int j = 0; j < clm.length; j++) {
					food[foodCounter][j] = clm[j];
				}
//				System.out.println("food: " + food[foodCounter][1]);
				foodCounter++;
			}
			br.close();

			br = new BufferedReader(new FileReader(sportFile));
			while ((line = br.readLine()) != null) {

				// use tab character as separator
				String[] clm = line.split("\t");

				for (int j = 0; j < clm.length; j++) {
					sport[sportCounter][j] = clm[j];
				}
//				System.out.println("sport: " + sport[sportCounter][1]);
				sportCounter++;
			}
			br.close();
			
			Person[] person = new Person[personCounter];
			for (int i = 0; i < person.length; i++) {
				person[i] = new Person(Integer.parseInt(people[i][0]), people[i][1], people[i][2],
						Integer.parseInt(people[i][3]), Integer.parseInt(people[i][4]), Integer.parseInt(people[i][5]));
			}
			//System.out.println(person[2].getName() + " " + person[2].getYearOfBirth());

			Food[] foodObj = new Food[foodCounter];
			for (int i = 0; i < foodObj.length; i++) {
				foodObj[i] = new Food(Integer.parseInt(food[i][0]), food[i][1], Integer.parseInt(food[i][2]));
			}
			//System.out.println(foodObj[2].getName() + " " + foodObj[2].getCalorie());

			Sport[] sportObj = new Sport[sportCounter];
			for (int i = 0; i < sportObj.length; i++) {

				sportObj[i] = new Sport(Integer.parseInt(sport[i][0]), sport[i][1], Integer.parseInt(sport[i][2]));
			}
			//System.out.println(sportObj[2].getName() + " " + sportObj[2].getBurnedCalorie());

			
			for (int i = 0; i < commands.length; i++) {
				if (commands[i][1] != null) {
					for (int j = 0; j < person.length; j++) {
						if (person[j].getPersonId() != Integer.parseInt(commands[i][0])) {
							continue;
						}
						else {
							for (int j2 = 0; j2 < foodObj.length; j2++) {
								if (foodObj[j2].getFoodId() == Integer.parseInt(commands[i][1]) ) {
									person[j].setTakenCalorie(foodObj[j2].getCalorie() * Float.parseFloat(commands[i][2]));
									System.out.println(person[j].getPersonId()+"\thas\ttaken\t"+(int)Math.round(foodObj[j2].getCalorie() * Float.parseFloat(commands[i][2]))+"kcal\tfrom\t"+foodObj[j2].getName());
								}
							}
							for (int j3 = 0; j3 < sportObj.length; j3++) {
								if (sportObj[j3].getSportId() == Integer.parseInt(commands[i][1]) ) {
									person[j].setBurnedCalorie(sportObj[j3].getBurnedCalorie() * Float.parseFloat(commands[i][2]) / 60);
									System.out.println(person[j].getPersonId()+"\thas\tburned\t"+(int)Math.round(sportObj[j3].getBurnedCalorie() * Float.parseFloat(commands[i][2])/60)+"kcal\tthanks\tto\t"+sportObj[j3].getName());
								}
							}
							
						}
					}
				}
				else if (commands[i][0] != null){
					/* print personId or printList commands */
					System.out.println(commands[i][0]);
					if (commands[i][0].contains("print(")) {
						commands[i][0] = commands[i][0].replace("print(", "");
						commands[i][0] = commands[i][0].replace(")", "");
						for (int j = 0; j < person.length; j++) {
							if (person[j].getPersonId() != Integer.parseInt(commands[i][0])) {
								continue;
							}
							else {
								System.out.println(person[j].getName()+"\t"+(2018-person[j].getYearOfBirth())+"\t"+Math.round(person[j].getDailyCalorie())+"kcal\t"+Math.round(person[j].getTakenCalorie())+"kcal\t"+Math.round(person[j].getBurnedCalorie())+"kcal\t"+Math.round(person[j].calculateResult(person[j].getDailyCalorie(), person[j].getTakenCalorie(), person[j].getBurnedCalorie()))+"kcal");
							}
						}	
					}
					if (commands[i][0].contains("printList")) {
						System.out.println("2");
					}
					
				}
				if (i < lineCounter-1) {
					System.out.println("***************");
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
