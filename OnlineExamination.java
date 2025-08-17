import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExamination {
    static Scanner sc = new Scanner(System.in);
    static boolean sessionActive = true;
    static Timer timer = new Timer();

    static String username = "admin";
    static String password = "1234";
    static String selectedAnswer = null;

    public static void main(String[] args) {
        System.out.println("=== ONLINE EXAMINATION SYSTEM ===");

        // Login
        System.out.print("Enter Username: ");
        String inputUser = sc.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = sc.nextLine();

        if (login(inputUser, inputPass)) {
            System.out.println("Login successful!");
            startTimer();

            while (sessionActive) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Update Profile");
                System.out.println("2. Attempt MCQ");
                System.out.println("3. Logout");
                System.out.print("Choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        updateProfile();
                        break;
                    case 2:
                        attemptMCQ();
                        break;
                    case 3:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    // Login Method
    static boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    // Profile Update
    static void updateProfile() {
        System.out.print("Enter new username: ");
        username = sc.nextLine();
        System.out.print("Enter new password: ");
        password = sc.nextLine();
        System.out.println("Profile updated successfully!");
    }

    // MCQ Attempt
    static void attemptMCQ() {
        System.out.println("\nQ: What is Java?");
        System.out.println("A. Programming Language");
        System.out.println("B. Coffee");
        System.out.println("C. Operating System");
        System.out.println("D. None of the above");
        System.out.print("Enter your answer (A/B/C/D): ");
        selectedAnswer = sc.nextLine().toUpperCase();
        System.out.println("You selected: " + selectedAnswer);
    }

    // Start Timer
    static void startTimer() {
        System.out.println("Exam started. You have 1 minute...");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (sessionActive) {
                    System.out.println("\nTime's up! Auto-submitting your answer...");
                    logout();
                }
            }
        }, 60000); // 60 seconds
    }

    // Logout Method
    static void logout() {
        sessionActive = false;
        timer.cancel();
        System.out.println("\nSession closed.");
        if (selectedAnswer != null) {
            System.out.println("Your submitted answer: " + selectedAnswer);
        } else {
            System.out.println("No answer submitted.");
        }
        System.out.println("Logged out successfully.");
    }
}