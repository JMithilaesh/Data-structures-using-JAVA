import java.io.*;

public class PetList {

    private static final String INPUT_FILE = "./pet_data.csv";
    private static final String OUTPUT_FILE = "./pet_report.txt";

    private static String[] petData;
    private static Pet[] pets;
    private static int numPets = 0;
    private static int catCounter = 0;
    private static int dogCounter = 0;
    private static float avgAgeCats = 0;
    private static float avgAgeDogs = 0;

    public static void main (String[] args) {
        retrievePetData();
        convertPetDataToPetObjects();
        //showMe();
        writeOutput();
        System.out.println (catCounter);
        System.out.println(dogCounter);
    }

    private static void retrievePetData() {
        int incrementSize = 1;
        petData = new String[incrementSize];
       
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) { 
            String line;
            while ((line = br.readLine()) != null) {
                petData[numPets] = line;
                numPets++;      
                if (numPets == petData.length) {
                    String[] tmpData = new String[petData.length + incrementSize];
                    for (int idx = 0; idx < petData.length; idx++) {
                        tmpData[idx] = petData[idx];
                    }
                    petData = tmpData;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.print(e.getClass().getName() + " ");
            System.out.println(e.getMessage());
        }
    }
    
    private static void showMe()
    {
        for (int i = 0; i < petData.length; i++)
        {
            System.out.println (petData[i]);
        }
    }
    
    private static void convertPetDataToPetObjects(){
        String species = "";
        String name = "";
        int age = 0;
        String speak = "";
        Pet tempArray[] = new Pet[30];
        int currentLoc = 0;
        for (int i = 0; i < petData.length-1; i++)
        {
            Pet tmpPet = new Pet();
            if (petData[i].substring(0,3).equals("Dog") || petData[i].substring(0,3).equals("Cat"))
            {
                species = petData[i].substring(0,3);
                if (howManyComas(petData[i]) == 2)
                {
                    int secondComa = 0;
                    secondComa = petData[i].indexOf(",", petData[i].indexOf(",") + 1);  
                    if (petData[i].substring(petData[i].indexOf(",")+1,secondComa).length() > 0 )
                    {
                        name = petData[i].substring(petData[i].indexOf(",")+1,secondComa);
                        String ageSlot = petData[i].substring(secondComa+1, petData[i].length());
                        if(isInteger(ageSlot))
                        {
                            age = Integer.parseInt(ageSlot);
                            if (species.equals("Dog"))
                            {
                                dogCounter++;
                                speak = "woof";
                                avgAgeDogs += age;
                            }
                            else if (species.equals("Cat"))
                            {
                                catCounter++;
                                speak = "meow";
                                avgAgeCats += age;
                            }
                            tmpPet.setSpecies(species);
                            tmpPet.setName(name);
                            tmpPet.setAge(age);
                            tmpPet.setSpeak(speak);
                        } 
                        else
                        {
                            tmpPet.setSpecies("error");
                        }
                    }
                    else
                    {
                        tmpPet.setSpecies("error");
                    }
                }
                else
                {
                    tmpPet.setSpecies("error");
                }
            }
            else
            {
                tmpPet.setSpecies("error");
            }
            if (!tmpPet.getSpecies().equals("error")) 
            {
                tempArray[currentLoc] = tmpPet; 
            currentLoc++;
            }
        }
        pets = tempArray;
    }

    private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    
    private static int howManyComas(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ',') 
            {
                count++;
            }
        }
        return count;
    }
    
    private static void writeOutput () {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(OUTPUT_FILE)); 
            writePetObjects(pw);
            writePetStatistics(pw);
            pw.close();
        } catch (Exception e) {
            System.out.print(e.getClass().getName() + " ");
            System.out.println(e.getMessage());
        }
    }

    private static void writePetObjects (PrintWriter pw) {
        if (pets != null) {
            for (Pet aPet: pets) {
                if (aPet != null) pw.println(aPet.toString()); 
            } 
        }
    }

    private static void writePetStatistics (PrintWriter pw) {
        int numberOfCats = catCounter;
        int numberOfDogs = dogCounter;
        float averageCatAge = avgAgeCats/catCounter;
        float averageDogAge = avgAgeDogs/dogCounter;

        pw.println("Number of cats: " + numberOfCats);
        pw.println("Number of dogs: " + numberOfDogs);
        pw.println("Average cat age: " + averageCatAge);
        pw.println("Average dog age: " + averageDogAge);
    }

}
