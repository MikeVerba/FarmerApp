package utils;

public class TextMessages {
    public String welcome = "****Witaj w Aplikacji Farmer Manager****";
    public String unknownInput = "Niewłaściwe dane. Podaj właściwe dane.";
    public String moduleExit = "Wyjście z modułu.";
    public String programExit = "Wyjście z programu.";
    public String mainMenu = "****MENU GŁÓWNE****\n" +
            "Wybierz: \n" +
            "1 - Otwórz moduł zarządzania zwierzętami. \n" +
            "2 - Otwórz moduł zarządzania stodołami.\n" +
            "3 - Otwórz moduł zapisywania i odczytywania stanu aplikacji.\n" +
            "4 - Wyjdź z programu.\n";
    public String animalModule = "****ZWIERZĘTA****\n" +
            "Wybierz: \n" +
            "1 - Dodaj zwierzę.\n" +
            "2 - Usuń zwierzę.\n" +
            "3 - Wyświetl 5 najstarszych zwierząt.\n" +
            "4 - Wyświetl 5 najmłodszych zwierząt.\n" +
            "5 - Wyświetl najliczniejszy gatunek.\n" +
            "6 - Wyświetl szczepione zwierzęta.\n" +
            "7 - Wyjdź z modułu zwierzęta.\n";
    public String barnModule = "****STODOŁY****\n" +
            "Wybierz: \n" +
            "1 - Dodaj stodołę.\n" +
            "2 - Usuń stodołę.\n" +
            "3 - Wyświetl stodołę z najwiekszą ilością zwierząt.\n" +
            "4 - Wyjdź z modułu stodoły.\n";
    public String readAndWriteModule = "****ZAPIS I ODCZYT****\n" +
            "Wybierz: \n" +
            "1 - Zapisz stan aplikacji.\n" +
            "2 - Wczytaj ostatni zapisany stan aplikacji.\n" +
            "3 - Wyjdź z modułu zapis i odczyt.\n";

    public String barnWithLargestAmountOfAnimals = "Stodoła z największą ilością zwierząt:";
    public String vaccinedAnimals = "Szczepione zwierzęta:";

    public String fiveYoungestAnimals = "Pięć namłodszych zwierząt: ";
    public String fiveOldestAnimals = "Pięć najstarszych zwierząt: ";

    public String animalType = "Podaj typ zwierzęcia: \n" +
            "1 - Kaczka\n" +
            "2 - Krowa\n" +
            "3 - Koń\n" +
            "4 - Świnia\n";
    public String animalAge = "Podaj wiek zwierzęcia: ";
    public String animalIsVaccined = "Czy zwierze jest szczepione: \n" +
            "1 - Tak\n" +
            "2 - Nie\n";

    public String barnName = "Podaj nazwę stodoły.";
    public String barnId = "Podaj Id stodoły.";

    public String readingSucces = "Wczytano stan aplikacji z pliku";
    public String writingSucces = "Zapisano stan aplikacji do pliku";

    public String uknownBarn = "Nieznana stodoła. Wprowadź poprawne dane.";
    public String uknownAnimal = "Nieznane zwierze. Wprowadź poprawne dane";
    public String notEnoughAnimals = "Nie masz wystarczającej ilości zwierząt. Wprowadź dane.";
    public String notEnoughBarns = "Nie masz wystarczającej ilości stodół. Wprowadź dane.";
    public String mostNumerousType = "Najliczniejszy gatunek zwierzęcia to: ";

}
