package assn07;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        //Master password
        System.out.println("Enter Master Password");
        String input = scanner.nextLine();

        while (!passwordManager.checkMasterPassword(input)) {
            System.out.println("Enter Master Password");
            input = scanner.nextLine();
        }

        //commands
        while (true){
            String arg = scanner.nextLine();
            switch(arg){
                case "New password": {
                    String website = scanner.nextLine();
                    String password = scanner.nextLine();
                    passwordManager.put(website, password);
                    System.out.println("New password added");
                    break;
                }
                case "Get password":{
                    String website = scanner.nextLine();
                    String password = passwordManager.get(website);
                    if (password == null) System.out.println("Account does not exist");
                    else System.out.println(password);
                    break;
                }
                case "Delete account":{
                    String website = scanner.nextLine();
                    String password = passwordManager.remove(website);
                    if (password == null) System.out.println("Account does not exist");
                    else System.out.println("Account deleted");
                    break;
                }
                case "Check duplicate password":{
                    String password = scanner.nextLine();
                    List<String> list = passwordManager.checkDuplicate(password);
                    if (list.size() == 0) System.out.println("No account uses that password");
                    else {
                        System.out.println("Websites using that password:");
                        for (String s : list) System.out.println(s);
                    }
                    break;
                }
                case "Get accounts":{
                    Set<String> set = passwordManager.keySet();
                    System.out.println("Your accounts:");
                    for (String s : set) System.out.println(s);
                    break;
                }
                case "Generate random password":{
                    int length = scanner.nextInt();
                    System.out.println(passwordManager.generateRandomPassword(length));
                    break;
                }
                case "Exit":{
                    System.exit(0);
                }
                default:{
                    System.out.println("Command not found");
                }
            }
        }
    }
}