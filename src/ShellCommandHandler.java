import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        // TODO: Initialize currentDirectory to the user's current working directory
        // Hint: Use System.getProperty("user.dir")
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public void printWorkingDirectory() { // מציג את הנתיב המלא של התיקייה הנוכחית
        // TODO: Print the absolute path of the current directory
        System.out.println(currentDirectory.getAbsolutePath());
    }

    public void listDirectory() {//מציג את כל הקבצים והתיקיות בתיקייה הנוכחית
        // TODO: List all files and directories in the current directory
        // For directories, prefix with "[DIR] "
        // For files, prefix with "[FILE]"
        File[] files = currentDirectory.listFiles(); // יצירת מערך של אובייקטים או קבצים באורך של רשימת כל הקבצים במאגר כל מיקום במערך מייצג קובץ בתיקייה
        if (files != null) {
            for (int i = 0; i < files.length; i++) { // לולאה שעוברת על כל קבצי המערך של האובייקטים
                File file = files[i]; // שומר את הקובץ או התיקייה לתוך משתנה
                if (file.isDirectory()) // אם המשתנה הוא תיקייה מדפיס הודעה
                {
                    System.out.println("[DIR]" + file.getName());
                } else{ // אם המשתנה הוא קובץ מדפיס הודעה
                    System.out.println("[FILE]" + file.getName());
                }
            }
        }
    }

    public void changeDirectory(String name) { //שנה תיקייה נוכחית(cd(
        //פונקציה לשינוי התיקיה הנוכחית לפי השם שהמשתמש הכניס
        // TODO: Implement the change directory command
        // If name is null, show usage message: "Usage: cd [directory_name]"
        // If name is "..", move to parent directory if possible
        // Otherwise, try to move to the specified directory
        // If directory doesn't exist, print error message: "Directory not found: [name]"
        if (name == null) { // אם המשתמש לא הכניס כלום מדפיס הודעה
            System.out.println("Usage : cd " + name);
            return;
        }
        File target;
        if (name.equals("..")) { // אם המשתמש מנסה לעלות קובץ אחד למעלה
            target = currentDirectory.getParentFile(); // מעביר לתיקייה אחת אחורה
            if (target == null) { //אם המשתמש לא הזין לאן הוא רוצה לעבור מדפיסנהודעה
                System.out.println("Already at root directory.");
                return;
            }
        } else { //אם המשתמש הקליד שם של תיקייה רגילה
            target = new File(currentDirectory, name); //יוצר אובייקט חדש של תיקייה ומכניס לתוכו תיקייה חדשה בשם שהמשתמש הכניס
        }
        if (target != null && target.isDirectory()) { //אם התיקייה קיימת
            currentDirectory = target; //משנה את התיקייה הנוכחית לתיקייה החדשה שהמשתמש הכניס
        } else {
            System.out.println("Directory not found: " + name); // אם התיקייה או הקובץ שהשמתמש הכניס לא קיים מדפיס הודעה
        }
    }

    public void makeDirectory(String name) { // יוצרת תיקייה חדשה
        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        // If directory already exists, print: "Directory already exists."
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
        if(name == null){
            System.out.println("Usage: mkdir " + name); // שלב ראשון אם השם של התיקייה ריק מחזיר הודעה
        return;
        }
        File newDir = new File(currentDirectory, name); //יוצר אובייקט חדש של קבצים תיקיות
        if(newDir.exists()){
            System.out.println("Directory already exists."); // בודק אם התיקייה הזאת קיימת במחשב
        } else if(newDir.mkdir()){
            System.out.println("Directory created: " + name); // יוצר תיקייה חדשה
        }else{
            System.out.println("Failed to create directory."); // הודעת שגיאה אם מאיזשהי סיבה אי אפשר ליצור תיקייה
        }
    }

    public void createFile(String name) throws IOException { // יוצר קובץ חדש
        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        // If file already exists, print: "File already exists."
        // If file creation is successful, print: "File created: [name]"
        // If file creation fails, print error message with exception details
        if(name == null) { //אם המשתמש לא נתן שם לקובץ מדפיס הודעה
            System.out.println("Usage: touch" + name);
            return;
        }
            File newFile = new File(currentDirectory, name); //אובייקט חדש בשם של קובץ חדש שהמשתמש הזין
        if(newFile.exists()){ //אם השם של הקובץ קיים כבר במערכת
            System.out.println("File already exists.");
    }
        boolean created = newFile.createNewFile(); //בדיקה אם הצליח ליצור קובץ אם כן מחזיר אמת

        if(created){ //יוצר קובץ חדש בתיקייה
            System.out.println("File created: " + name);
        }else{ // אם יש שגיאה מדפיס הודעה
            System.out.println("Failed to create file.");
        }
    }

    public void printHelp() { // מציגה את הפקודות הנתמכות
        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions
        System.out.println("Available commands:");
        System.out.println("pwd - Print the current working directory");
        System.out.println("ls - List files and directories in the current directory.");
        System.out.println("cd [dir] - Change to the specific directory (use .. to move up)");
        System.out.println("mkdir [dir] - Create new file or directory.");
        System.out.println("touch [file] - Create new empty file");
        System.out.println("help - Show this help message");
        System.out.println("exit - Exit the program");
    }

    public File getCurrentDirectory() { // מחזיר את התיקייה הנוכחית
        // TODO: Return the current directory
        //מחזיר את התיקייה הנוכחיתץ של המשתמש
        return currentDirectory; // Replace this with your implementation
    }
}