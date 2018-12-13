package structure;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Animal implements Serializable {

    public enum Type {
        DUCK, COW, HORSE, PIG;

        @Override
        public String toString() {
            String typeInPolish = null;
            if (this.equals(DUCK)) {
                typeInPolish = "Kaczka";
            }
            if (this.equals(COW)) {
                typeInPolish = "Krowa";
            }
            if (this.equals(HORSE)) {
                typeInPolish = "Koń";
            }
            if (this.equals(PIG)) {
                typeInPolish = "Świnia";
            }
            return typeInPolish;
        }
    }

    private Type type;
    private int age;
    private boolean isVaccined;

    public Animal(int age, boolean isVaccined, Type type) {
        this.age = age;
        this.isVaccined = isVaccined;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isVaccined() {
        return isVaccined;
    }

    public static class AgeCompare implements Comparator<Animal> {
        @Override
        public int compare(Animal o1, Animal o2) {
            if (o1.age > o2.age) return 1;
            if (o1.age < o2.age) return -1;
            return 0;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                isVaccined == animal.isVaccined &&
                type == animal.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, age, isVaccined);
    }

    @Override
    public String toString() {
        return "****INFORMACJE O ZWIERZĘCIU****\n" +
                "Gatunek zwierzęcia: " + type + "\n" +
                "Wiek zwierzęcia: " + age + "\n" +
                "Czy zwierzę jest szczepione: " + isVaccined + "\n";
    }
}
