package menu;


import structure.Animal;
import structure.Barn;
import structure.Farmer;
import utils.Printer;
import utils.TextMessages;


import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Printer printer;
    TextMessages textMessages;
    Farmer farmer;

    public Menu() {
        scanner = new Scanner(System.in);
        printer = new Printer();
        textMessages = new TextMessages();
        farmer = new Farmer();

    }

    public void start() {
        runMainMenu();
    }


    public void runMainMenu() {
        boolean isModuleRunning = true;
        printer.print(textMessages.welcome);
        while (isModuleRunning) {
            printer.print(textMessages.mainMenu);
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    runAnimalModule();
                    break;
                case "2":
                    runBarnModule();
                    break;
                case "3":
                    runReadAndWriteModule();
                    break;
                case "4":
                    printer.print(textMessages.programExit);
                    isModuleRunning = false;
                    break;
                default:
                    printer.print(textMessages.unknownInput);
            }
        }
    }

    public void runAnimalModule() {
        boolean isModuleRunning = true;
        while (isModuleRunning) {
            printer.print(textMessages.animalModule);
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    runAddAnimalSubmodule();
                    break;
                case "2":
                    runRemoveAnimalSubmodule();
                    break;
                case "3":
                    runFiveOldestAnimalsSubmodule();
                    break;
                case "4":
                    runFiveYoungestAnimalsSubmodule();
                    break;
                case "5":
                    runMostNumerousTypeSubmodule();
                    break;
                case "6":
                    runVaccinedAnimalsSubmodule();
                    break;
                case "7":
                    printer.print(textMessages.moduleExit);
                    isModuleRunning = false;
                    break;
                default:
                    printer.print(textMessages.unknownInput);
            }
        }

    }

    public void runBarnModule() {
        boolean isModuleRunning = true;

        while (isModuleRunning) {
            printer.print(textMessages.barnModule);
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    runAddBarnSubmodule();
                    break;
                case "2":
                    runRemoveBarnSubmodule();
                    break;
                case "3":
                    runBarnWithLargestAmountOfAnimalsSubmodule();
                    break;
                case "4":
                    printer.print(textMessages.moduleExit);
                    isModuleRunning = false;
                    break;
                default:
                    printer.print(textMessages.unknownInput);
            }
        }

    }

    public void runReadAndWriteModule() {
        boolean isModuleRunning = true;


        while (isModuleRunning) {
            printer.print(textMessages.readAndWriteModule);
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    runWriteSubmodule();
                    break;
                case "2":
                    runReadSubmodule();
                    break;
                case "3":
                    printer.print(textMessages.moduleExit);
                    isModuleRunning = false;
                    break;
                default:
                    printer.print(textMessages.unknownInput);
            }
        }

    }


    public void runAddAnimalSubmodule() {

        if (farmer.hasBarns()) {


            printer.print(textMessages.barnId);
            int barnId = Integer.valueOf(scanner.next());
            Animal animalToAdd = runAnimalExtractorSubmodule();
            farmer.addAnimalToBarn(barnId, animalToAdd);

        } else {
            printer.print(textMessages.notEnoughBarns);
        }
    }

    public void runRemoveAnimalSubmodule() {
        if (farmer.hasBarns() && farmer.hasAnimals()) {

            printer.print(textMessages.barnId);
            int barnId = Integer.valueOf(scanner.next());
            printer.print(textMessages.animalType);
            String typeChoice = scanner.next();
            Animal.Type type = null;
            boolean isModuleRuning = true;

            while (isModuleRuning) {
                switch (typeChoice) {
                    case "1":
                        type = Animal.Type.DUCK;
                        isModuleRuning = false;
                        break;
                    case "2":
                        type = Animal.Type.COW;
                        isModuleRuning = false;
                        break;
                    case "3":
                        type = Animal.Type.HORSE;
                        isModuleRuning = false;
                        break;
                    case "4":
                        type = Animal.Type.PIG;
                        isModuleRuning = false;
                        break;
                    default:
                        printer.print(textMessages.unknownInput);
                }
            }
            farmer.removeAnimalFromBarn(type, barnId);

        } else if (!farmer.hasBarns()) {
            printer.print(textMessages.notEnoughBarns);
        } else {
            printer.print(textMessages.notEnoughAnimals);
        }
    }

    public void runFiveOldestAnimalsSubmodule() {

        if (farmer.canGetFiveAnimals()) {
            printer.print(textMessages.fiveOldestAnimals);
            printer.print(farmer.getFiveOldestAnimals().toString());
        } else {
            printer.print(textMessages.notEnoughAnimals);
        }

    }

    public void runFiveYoungestAnimalsSubmodule() {
        if (farmer.canGetFiveAnimals()) {
            printer.print(textMessages.fiveYoungestAnimals);

            printer.print(farmer.getFiveYoungestAnimals().toString());
        } else {
            printer.print(textMessages.notEnoughAnimals);
        }

    }

    public void runMostNumerousTypeSubmodule() {

        if (farmer.hasAnimals()) {
            printer.print(textMessages.mostNumerousType);
            printer.print(farmer.getMostNumerousType().toString());

        } else {
            printer.print(textMessages.notEnoughAnimals);
        }

    }

    public void runVaccinedAnimalsSubmodule() {
        if (farmer.hasAnimals()) {

            printer.print(textMessages.vaccinedAnimals);
            for (Animal animal : farmer.getVaccinedAnimals()) {
                printer.print(animal.toString());
            }
        } else {
            printer.print(textMessages.notEnoughAnimals);
        }
    }


    public void runAddBarnSubmodule() {

        Barn addedBarn = runBarnExtractorSubmodule();
        farmer.addBarn(addedBarn);

    }

    public void runRemoveBarnSubmodule() {

        if (farmer.hasBarns()) {

            printer.print(textMessages.barnId);
            int barnId = Integer.valueOf(scanner.next());
            farmer.removeBarn(barnId);
        } else {
            printer.print(textMessages.notEnoughBarns);
        }

    }

    public void runBarnWithLargestAmountOfAnimalsSubmodule() {
        if (farmer.hasBarns() || farmer.hasAnimals()) {
            printer.print(textMessages.barnWithLargestAmountOfAnimals);
            printer.print(farmer.getBarnWithLargestAmountOfAnimals().toString());
        } else if (!farmer.hasAnimals()) {
            printer.print(textMessages.notEnoughAnimals);
        } else {
            printer.print(textMessages.notEnoughBarns);
        }
    }

    public void runReadSubmodule() {
        farmer = farmer.loadFarmer();
        printer.print(textMessages.readingSucces);
    }

    public void runWriteSubmodule() {
        farmer.writeFarmer();
        printer.print(textMessages.writingSucces);
    }

    public Animal runAnimalExtractorSubmodule() {

        Animal extractedAnimal;
        Animal.Type type = null;
        int age;
        boolean isVaccined = false;
        printer.print(textMessages.animalType);
        String typeChoice = scanner.next();
        switch (typeChoice) {
            case "1":
                type = Animal.Type.DUCK;
                break;
            case "2":
                type = Animal.Type.COW;
                break;
            case "3":
                type = Animal.Type.HORSE;
                break;
            case "4":
                type = Animal.Type.PIG;
                break;
            default:
                printer.print(textMessages.unknownInput);
        }
        printer.print(textMessages.animalAge);
        age = Integer.valueOf(scanner.next());
        printer.print(textMessages.animalIsVaccined);
        String vaccinedChoice = scanner.next();
        switch (vaccinedChoice) {
            case "1":
                isVaccined = true;
                break;
            case "2":
                isVaccined = false;
                break;
            default:
                printer.print(textMessages.unknownInput);
        }
        extractedAnimal = new Animal(age, isVaccined, type);
        return extractedAnimal;

    }

    public Barn runBarnExtractorSubmodule() {

        Barn extractedBarn;
        printer.print(textMessages.barnName);
        String name = scanner.next();
        printer.print(textMessages.barnId);
        int id = Integer.valueOf(scanner.next());
        extractedBarn = new Barn(name, id);
        return extractedBarn;

    }

}

