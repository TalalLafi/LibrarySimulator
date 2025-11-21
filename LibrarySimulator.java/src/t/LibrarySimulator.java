package t;
import java.util.Scanner;

// Group Members: Talal, Faisal, Abdullah
// GitHub Repository Link: https://github.com/TalalLafi/LibrarySimulator/edit/LibrarySimulation/LibrarySimulator.java/src/t/LibrarySimulator.java
public class LibrarySimulator { 
    public static void main(String args[]) {  
        Scanner input = new Scanner(System.in);
        

        
        final int ID_1 = 1;
        final String UserName1 = "Faisal";
        Member member1 = new Member(ID_1, UserName1, 0); // كائن العضو الأول
        
        final int ID_2 = 2;
        final String UserName2 = "Talal";
        Member member2 = new Member(ID_2, UserName2, 0); // كائن العضو الثاني

        final int ID_3 = 3;
        final String UserName3 = "Abdullah";
        Member member3 = new Member(ID_3, UserName3, 0); // كائن العضو الثالث
        
        boolean running = true;
        
        // Main menu
        while(running) {
            System.out.println(" ------Welcome to The Library Simulator------");
            System.out.println("1. Login As "+ UserName1 + " (ID: "+ ID_1+ ")");
            System.out.println("2. Login As "+ UserName2 + " (ID: "+ ID_2+ ")");
            System.out.println("3. Login As "+ UserName3 + " (ID: "+ ID_3+ ")");
            System.out.println("4. Login As Administrator");
            System.out.println("5. Exit The Program");
            System.out.print("Choose An Option boyy : ");
            int choice = input.nextInt();
            input.nextLine(); // Cosume newLine
            

            Member currentMember = null; // سيشير هذا إلى العضو الذي سجل الدخول
            
            if (choice >= 1 && choice <= 3) {
                // Load user data based on choise
                if (choice == 1) {
                    currentMember = member1;
                } else if (choice == 2) {
                    currentMember = member2;
                } else if (choice == 3) {
                    currentMember = member3;
                }

                boolean sessionActive = true;
                while (sessionActive) {
                    System.out.println("\n--- Welcome "+ currentMember.getName() + "----"); 
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow A Book");
                    System.out.println("3. Return A Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Get Back TO Main Menu");
                    System.out.print("Choose An Option : ");
                    int userOption = input.nextInt();
                    input.nextLine(); // Consume newline

             
                    switch (userOption) {
                        case 1:
                            // View Current Borrowed Books
                            currentMember.viewBorrowedCount(); 
                            break;

                        case 2:
                            // Borrowing a book
                            currentMember.borrowOne(); 
                            break; 

                        case 3:
                            // Returning a book
                            currentMember.returnOne(); 
                            break;
                            
                        case 4:
                            // Session Summary
                            currentMember.displayStatistics(); 
                            break;
                            
                        case 5:
 
                            sessionActive = false; 
                            System.out.println("Logging out and returning to the Main Menu");
                            break;	
                        
                        default:
                            System.out.println("Invalid Option. Try Again.");
                    }
                }
            }
            else if (choice == 4) {
                // Administrator Login
                System.out.print("Enter Admin Password: ");
                String password = input.nextLine(); 
                
                if (password.equals("Admin")) { 
                    System.out.println("\n--- Administrator Panel ---");
                    System.out.printf("Total Library Revenue: $%.2f\n", Member.TotalRevenue);
                    System.out.println("Total Books Borrowed (Global): " + Member.TotalBorrows);
                    System.out.println("Total Books Returned (Global): " + Member.TotalReturns);
                    System.out.println("Total 'View Count' (Global): " + Member.TotalViewBorrowed); // إحصائية جديدة
                    
                    System.out.println("\n--- User Statistics ---");
                    System.out.println(member1.getName() + " (ID:" + member1.getId() + "): Currently Borrowed = " + member1.getBorrowedCount());
                    System.out.println(member2.getName() + " (ID:" + member2.getId() + "): Currently Borrowed = " + member2.getBorrowedCount());
                    System.out.println(member3.getName() + " (ID:" + member3.getId() + "): Currently Borrowed = " + member3.getBorrowedCount());
                
                } else {
                    System.out.println("Incorrect Password");
                }
            }
            else if (choice == 5) {
                System.out.println("Thank u and see ya later boyys");
                running = false;
            }
            else {
                System.out.println("Invalid Option. Please choose between 1 and 5.");
            }
        }
        input.close();
    }
    
}
