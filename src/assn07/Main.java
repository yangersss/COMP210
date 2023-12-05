package assn07;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();


        passwordManager.put("instagram", "peepee");
        passwordManager.put("boobs", "poop");
        System.out.println(passwordManager.size());
        // your code below
//        String arg = scanner.next();
//        switch(arg){
//            case "New Password":
//                break;
//        }
    }
}
