package Practice_Interface;

import java.io.File;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        boolean validInput = false;
        do{
            System.out.println("-----------------MENU-----------------");
            System.out.println("1. Add accountant information");
            System.out.println("2. Show all accountants");
            System.out.println("3. Delete an accountant ");
            System.out.println("4. Filter accountants by high salary");
            System.out.println("5. Search information ");
            System.out.println("6. Sort accountants by First Name ( ASC )");
            System.out.println("7. Sort by Basic Salary (DESC)");
            System.out.println("8. Update information ");
            System.out.println("9. Write to file ");
            System.out.println("10. Read from file ");
            System.out.println("0. Exit ");
            System.out.println("--------------------------------------");
            do{
                try {
                    choice = FunctionToCheck.inputInterger("Input your choice (0-9) --------> ");
                    if (choice < 0 || choice > 10){
                        throw new Exception();
                    }
                    else {
                        validInput = true;
                    }
                }
                catch (Exception e){
                    System.out.println("Input again ( 0-9 ) !!!");
                    validInput = false;
                }
            }while (!validInput);

            switch (choice){

                case 1:{
                    FunctionToWork.inputInformationOfAccountants();
                    System.out.println("Done !!!");
                    break;
                }

                case 2:{
                    FunctionToWork.showInformation();
                    System.out.println("Done !!!");
                    break;
                }

                case 3:{
                    FunctionToWork.removeAccountantByName();
                    System.out.println("Done !!!");
                    break;
                }

                case 4:{
                    FunctionToWork.highSalary();
                    System.out.println("Done !!!");
                    break;
                }

                case 5:{
                    FunctionToWork.chooseToSearch();
                    System.out.println("Done !!!");
                    break;
                }
                case 6:{
                    FunctionToWork.sortByFirstName();
                    System.out.println("Done !!! ");
                    break;
                }

                case 7:{
                    FunctionToWork.sortByBasicSalary();
                    System.out.println("Done !!!");
                    break;
                }
                case 8:{
                    FunctionToWork.updateInformation();
                    System.out.println("Done !!!");
                    break;
                }
                case 9:{
                    String fileName = FunctionToCheck.inputString("Input the name of file to save: ");
                    File fw = new File(fileName);
                    FunctionToWork.writeTheFile(fw);
                    System.out.println("Done !!!");
                    break;
                }
                case 10:{
                    String fileName = FunctionToCheck.inputString("Input the name of file to read: ");
                    File fr = new File(fileName);
                    FunctionToWork.readFromFile(fr);
                    System.out.println("Done !!!");
                    break;
                }

                case 0:{
                    FunctionToWork.Exit();
                    break;
                }
            }

        }while (true);
    }

}
