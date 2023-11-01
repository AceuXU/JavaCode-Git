import java.io.File;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "C:\\Code";
        String search = "oldText";
        String replace = "newText";

        File directory = new File(directoryPath);

        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();

            for(File file : files){
                String oldName = file.getName();
                String newName = oldName.replace(search, replace);

                File newFile = new File(directory, newName);

                if(file.renameTo(newFile)){
                    System.out.println("Renamed: " + oldName + " to " + newName);
                } else {
                    System.out.println("Error renaming: " + oldName);
                }
            }
        } else {
            System.err.println("Directory not found.");
        }
    }
}
