package Practice_Interface;

import java.io.*;
import java.security.PublicKey;
import java.util.*;

public class FunctionToWork  {
   static List<Accountant> listAccountants = new ArrayList<>();
    // Tạo hàm nhập thông tin
    public static void inputInformationOfAccountants (){
        String ID = FunctionToCheck.inputString("Input ID: ");
        String FirstName = FunctionToCheck.inputString("Input FirstName: ");
        String SurName = FunctionToCheck.inputString("Input SurName: ");
        Date Birthday = FunctionToCheck.inputDateOfBirth("Input Date of Birth: ");
        boolean Gender = FunctionToCheck.inputGender("Input Gender( 1 for Male, 0 for Female ):  ");
        String Phone = FunctionToCheck.inputString("Input Phone number: ");
        double BasisSalary = FunctionToCheck.InputDouble("Input B.Salary of accountant: ");
        int Reward = FunctionToCheck.inputInterger("Input Reward of accountant: ");

        Accountant people = new Accountant(ID, FirstName, SurName, Birthday, Gender, Phone, BasisSalary, Reward);
        listAccountants.add(people);
    }


    // Tạo hàm in ra danh sách
    public static void showInformation(){
        System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
        System.out.println("           ID                   Surname                First Name               Birthday                 Gender                 Phone.No                Salary                   Reward");
        System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");

        if (listAccountants.size() == 0){
            System.out.println("Have 0 person !!!");
        }
        for(Accountant PeopleInformation : listAccountants){
            System.out.println(PeopleInformation);
        }
        System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
    }


    //Tạo hàm xóa bằng ID
    public static void removeAccountantByName () {
        if (listAccountants.size() == 0) {
            System.out.println("Have 0 person !!!");
        }
        else {
            // Phải xóa ngoài vòng lặp vì Java không cho phép xóa phần tử xóa phần tử khi đang duyệt qua danh sách, do đó chúng ta phải đánh dấu ngay phần tử cần xóa và thực hiện xóa sau khi vòng lặp hoàn tất để không gặp lỗi ConcurrentModificationException
            String inputID;
            inputID = FunctionToCheck.inputString("Input the ID's accountant to remove: ");

            Accountant personToRemove = null;
            // Duyệt qua từng phần tử
            for (Accountant person : listAccountants) {
                if (person.getId().equalsIgnoreCase(inputID)) {
                    personToRemove = person; // Lưu phần tử cần xóa
                    break;// Thoát vòng lặp sau khi tìm thấy phần tử cần xóa
                }
            }
            // Nếu tìm thấy phần tử cần xóa, thực hiện việc xóa ngoài vòng lặp ( vì lí do ở trên )
            if (personToRemove != null) {
                listAccountants.remove(personToRemove);
            }
            else {
                System.out.println("Not found !!! ");
            }
        }
    }


    // Tạo hàm in ra thông tin những người có mức lương lớn hơn 3000
    // Sẽ có 2 trường hợp là:
    // 1. Cả list không có ai lương > 3000
    // 2. Trong list, có người lương > 3000, có người lương < 3000
    public static void highSalary (){
        if (listAccountants.size() == 0){
            System.out.println("Have 0 person !!!");
        }
        else {
            boolean checkMore3000 = false; // Đánh dấu khi tìm ra những người nào có mức lương > 3000
            for (Accountant personMore3000 : listAccountants){
                if (personMore3000.earnMoney()>= 3000){
                    System.out.println(personMore3000);
                    checkMore3000 = true;
                }
            }

            if (!checkMore3000){
                System.out.println("No one !!! ");
            }

        }
    }

    // Tạo hàm tìm bằng FirstName
    public static void searchByFirstName(){
        if (listAccountants.size() == 0){
            System.out.println("Have 0 person !!!");
        }
        else {
            boolean checkFName = false; // mục đích đặt như thế này là để đánh dấu lại những phần tử trong list đúng so với những gì ta muốn search
            String searchByFirstName = FunctionToCheck.inputString("Input first name: ");
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
            System.out.println("           ID                   Surname                First name               Birthday                 Gender                 Phone.No                Salary                   Reward");
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
            for (Accountant fName : listAccountants){
                if (fName.getFirstName().toLowerCase().equalsIgnoreCase(searchByFirstName)) {
                    System.out.println(fName);
                    checkFName = true;
                }
            }
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");

            if (!checkFName){
                System.out.println("Not found !!!");
            }
        }
    }


    // Tạo hàm tìm bằng ID
    public static void searchByID(){
        if (listAccountants.size() == 0){
            System.out.println("No person !!!");
        }
        else {
            boolean checkID = false;
            String searchByID = FunctionToCheck.inputString("Input ID: ");
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
            System.out.println("           ID                   Surname                First name               Birthday                 Gender                 Phone.No                Salary                   Reward");
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");
            for ( Accountant ID : listAccountants){
                if (ID.getId().toLowerCase().equalsIgnoreCase(searchByID)){
                    System.out.println(ID);
                    checkID = true;
                }
            }
            System.out.println("|----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------||----------------------|");

            if (!checkID){
                System.out.println("Not found !!! ");
            }

        }
    }

    // Tạo một hàm để chọn chế độ search
    public static void chooseToSearch(){
        int miniChoice = 0;
        boolean validInput = false;
        do{
            System.out.println("1. Search accountant by ID");
            System.out.println("2. Search accountant by First Name");
            System.out.println("3. Back to menu !!!");
            do{
                try{
                    miniChoice = FunctionToCheck.inputInterger("Input your choice (1-3) -------> ");
                    if (miniChoice < 1 || miniChoice > 3){
                        throw new Exception();
                    }
                    validInput =true;
                }
                catch (Exception e){
                    System.out.println("Please input again !!!");
                    validInput = false;
                }

            }while (!validInput);

            switch (miniChoice){
                case 1:{
                    FunctionToWork.searchByID();
                    break;
                }

                case 2:{
                    FunctionToWork.searchByFirstName();
                    break;
                }
                case 3:{
                    break;
                }
            }
        }while (miniChoice != 3);
    }


    // Tạo hàm sắp xếp theo First Name
    public static void sortByFirstName(){
        // Tạp một đối tượng ảo để so sánh 2 phần tử
        Comparator<Accountant> listSortByFirstName = new Comparator<Accountant>() {
            @Override
            public int compare(Accountant firstName1, Accountant firstName2) {
                return firstName1.getFirstName().compareToIgnoreCase(firstName2.getFirstName());
            }
        };

        // Gọi sort method để tiến hành sắp xếp
        Collections.sort(listAccountants, listSortByFirstName);

    }


    // Tạo hàm sắp xếp theo basic Salary
    public static void sortByBasicSalary(){
        Comparator<Accountant> listSortBySalary = new Comparator<Accountant>() {
            @Override
            public int compare(Accountant basicSalary1, Accountant basicSalary2) {

                if(basicSalary1.getBasicSalary() < basicSalary2.getBasicSalary() ){
                    return 1; // Lương thấp hơn thì xuống dưới
                }

                else if(basicSalary1.getBasicSalary() > basicSalary2.getBasicSalary()){
                    return -1; // Lương cao hơn thì lên đầu
                }

                else {
                    return 0; // lương bằng nhau
                }
            }
        };
        // Tiến hành sắp xếp lương từ cao đến thấp
        Collections.sort(listAccountants, listSortBySalary);
    }



   /* //Tạo hàm sắp xếp theo ngày tháng năm sinh
    public static void sortByBirth(){
       Comparator<FunctionToCheck> listSortByBirth = new Comparator<FunctionToCheck>() {
           @Override
           public int compare(FunctionToCheck o1, FunctionToCheck o2) {
               if (o1.so)
           }
       };
    }*/

    // Tạo Hàm update thông tin cá nhân
     public static void updateInformation(){
         boolean check = false;
         int choiceToUpdate = 0;
         do {
             System.out.println("1. Choose ID to search");
             System.out.println("2. Choose First Name to search");
             System.out.println("3. Back to menu");
             System.out.println("");
             do {
                 try {
                     choiceToUpdate = FunctionToCheck.inputInterger("Input your choice");
                     if (choiceToUpdate < 1 || choiceToUpdate > 3){
                         throw new Exception();
                     }
                     check = true;
                 }
                 catch (Exception e){
                     System.out.println("Input again ( 1-3 )!!! ");
                     check = false;
                 }
             }while (!check);

             switch (choiceToUpdate){
                 case 1: {
                     String updateByID = FunctionToCheck.inputString("Input ID to update");
                     for ( Accountant updByID : listAccountants){
                         if (updByID.getId().equalsIgnoreCase(updByID.getId())){

                         }
                     }
                     break;
                 }
                 case 2:{

                     break;
                 }
                 case 3:{
                     break;
                 }
             }
         }while (choiceToUpdate != 3);
     }


     // Tạo hàm exit
    public static void Exit(){
        int choiceToExit = 0;
        boolean checkToExit = false;
        System.out.println("Really to Exit ???");

        do{
            System.out.println("1. Yes ");
            System.out.println("2. No ( Back to menu ) ");

            do {
                try {
                    choiceToExit = FunctionToCheck.inputInterger("Input your choice: ");
                    if (choiceToExit < 1 || choiceToExit > 2){
                        throw new Exception();
                    }
                    checkToExit = true;
                }
                catch (Exception e){
                    System.out.println("Input again 1 or 2 !!!");
                    checkToExit = false;
            }
            }while (!checkToExit);

            switch (choiceToExit){
                case 1:{
                    System.out.println("");
                    System.out.println("<3 <3 <3 <3 <3 <3 GOOD BYE <3 <3 <3 <3 <3 <3 ");
                    System.exit(0);
                    break;
                }
                case 2: {
                    break;
                }
            }
        }while (choiceToExit != 2);
    }

    // Tạo hàm ghi dữ liệu xuống file
    public static void writeTheFile(File file){
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            for (Accountant object : listAccountants){
                oos.writeObject(object);
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Tạo hàm đọc dữ liệu từ file
    public static void readFromFile(File f){
        try {
            InputStream is = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(is);
            Accountant object = null;
            while(true){
                Object oj = ois.readObject();
                if (oj == null){
                    break;
                }
                if (oj != null){
                    object = (Accountant) oj;
                    listAccountants.add(object);
                }
            }
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
