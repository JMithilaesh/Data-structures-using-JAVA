
public class Pet {
    String species = "";
    String name = "";
    int age = 0;
    String speak = "";

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }
    
    public String toString(){
        String output = "";
        output = getSpecies() + " " + getName() + " " + getAge() + " " + getSpeak();
        return output;
    }
}
