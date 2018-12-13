package structure;

import java.io.Serializable;
import java.util.*;

public class Barn implements Serializable {

    private String name;
    private int id;
    private List<Animal> animalList;

    public Barn(String name, int id) {
        this.name = name;
        this.id = id;
        animalList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void addAnimal(Animal animal) {

        animalList.add(animal);
    }

    public static class AnimalsAmountCompare implements Comparator<Barn> {

        @Override
        public int compare(Barn o1, Barn o2) {
            if (o1.getAnimalList().size() > o2.getAnimalList().size()) return 1;
            if (o1.getAnimalList().size() < o2.getAnimalList().size()) return -1;
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barn barn = (Barn) o;
        return id == barn.id &&
                Objects.equals(name, barn.name) &&
                Objects.equals(animalList, barn.animalList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, animalList);
    }

    @Override
    public String toString() {
        return "****INFORMACJE O STODOLE****\n" +
                "Nazwa stodoły: " + name + "\n" +
                "Id stodoły: " + id + "\n" +
                "Ilość zwierząt w stodole: " + animalList.size() + "\n";
    }
}
