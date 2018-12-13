package structure;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farmer implements Serializable {

    private List<Barn> barnArrayList;


    public Farmer() {
        barnArrayList = new ArrayList<>();
    }

    public List<Barn> getBarnArrayList() {
        return barnArrayList;
    }

    public void addBarn(Barn barn) {
        barnArrayList.add(barn);
    }

    public void removeBarn(int barnId) {

        for (int i = 0; i < barnArrayList.size(); i++) {
            if (barnArrayList.get(i).getId() == barnId) {
                barnArrayList.remove(barnArrayList.get(i));
            }
        }
    }

    public void addAnimalToBarn(int barnId, Animal animal) {
        for (Barn barn : barnArrayList)
            if (barn.getId() == barnId) {
                barn.addAnimal(animal);

            }
    }

    public void removeAnimalFromBarn(Animal.Type type, int barnId) {
        for (Barn barn : barnArrayList) {
            if (barn.getId() == barnId) {
                for (Animal animal : barn.getAnimalList()) {
                    if (animal.getType().equals(type)) {
                        barn.getAnimalList().remove(animal);
                        break;
                    }
                }
            }
        }
    }

    public List<Animal> createListOfAllAnimals() {

        List<Animal> listOfAllAnimals = new ArrayList<>();
        for (Barn barn : barnArrayList) {
            listOfAllAnimals.addAll(barn.getAnimalList());
        }
        return listOfAllAnimals;
    }

    public boolean canGetFiveAnimals() {
        List<Animal> listOfAllAnimals = createListOfAllAnimals();
        if (listOfAllAnimals.size() > 4) return true;
        return false;

    }

    public boolean hasAnimals() {
        if (createListOfAllAnimals().size() > 0) return true;
        return false;
    }

    public boolean hasBarns() {
        if (getBarnArrayList().size() > 0) return true;
        return false;
    }

    public List<Animal> getFiveOldestAnimals() {
        List<Animal> listOfAllAnimals = createListOfAllAnimals();
        listOfAllAnimals.sort(new Animal.AgeCompare());
        return listOfAllAnimals.subList(listOfAllAnimals.size() - 5, listOfAllAnimals.size());
    }

    public List<Animal> getFiveYoungestAnimals() {
        List<Animal> listOfAllAnimals = createListOfAllAnimals();
        listOfAllAnimals.sort(new Animal.AgeCompare());
        return listOfAllAnimals.subList(0, 5);
    }

    public Barn getBarnWithLargestAmountOfAnimals() {
        barnArrayList.sort(new Barn.AnimalsAmountCompare());
        return barnArrayList.get(barnArrayList.size() - 1);
    }

    public List<Animal> getVaccinedAnimals() {
        List<Animal> listOfAllAnimals = createListOfAllAnimals();
        List<Animal> listOfVaccinedAnimals = new ArrayList<>();
        for (Animal animal : listOfAllAnimals) {
            if (animal.isVaccined()) {
                listOfVaccinedAnimals.add(animal);
            }
        }
        return listOfVaccinedAnimals;

    }

    public void writeFarmer() {

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("farmer.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Farmer loadFarmer() {

        Farmer loadedFarmer = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("farmer.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            loadedFarmer = (Farmer) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedFarmer;
    }

    public Animal.Type getMostNumerousType() {
        Map<Animal.Type, Integer> map = new HashMap<>();

        for (Barn barn : barnArrayList) {
            for (Animal animal : barn.getAnimalList()) {
                if (map.containsKey(animal.getType())) {
                    map.put(animal.getType(), map.get(animal.getType()) + 1);
                } else {
                    map.put(animal.getType(), 1);
                }
            }
        }

        int max = 0;
        Animal.Type type = null;
        for (Map.Entry<Animal.Type, Integer> typeIntegerEntry : map.entrySet()) {
            if (max < typeIntegerEntry.getValue()) {
                max = typeIntegerEntry.getValue();
                type = typeIntegerEntry.getKey();
            }
        }
        return type;

    }


}
