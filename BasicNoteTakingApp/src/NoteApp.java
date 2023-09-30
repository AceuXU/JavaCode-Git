import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteApp {
    private static List<String> notes = new ArrayList<>();
    private static final String FILENAME = "notes.txt";

    public static void main(String[] args) {
        loadNotes();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Note Taking App");
            System.out.println("1. View Notes");
            System.out.println("2 Add a Note");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    viewNotes();
                    break;
                case 2:
                    addNote(scanner);
                    break;
                case 3:
                    saveNotes();
                    System.out.println("Exiting Note Taking App. SeeYa");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 3);
        scanner.close();
    }


    private static void viewNotes() {
        System.out.println("Your Notes");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    private static void addNote(Scanner scanner){
        System.out.println("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note added Successfully. ");
    }

    private static void loadNotes(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
            String line;
            while ((line = reader.readLine()) != null){
                notes.add(line);
            }
        }
        catch (IOException e){
            // File does not exist or cannot be read, which is fine for a new user.
        }
    }
    private static void saveNotes(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))){
            for (String note : notes){
                writer.write(note);
                writer.newLine();
            }
        }
        catch (IOException e){
            System.err.println("Error: Unable to save Notes");;
        }
    }
}

