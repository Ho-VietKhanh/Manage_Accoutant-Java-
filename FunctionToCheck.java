package Practice_Interface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FunctionToCheck {

    public static String inputString (String statement){
        System.out.print(statement);
        String inputS = new Scanner(System.in).nextLine();
        return inputS;
    }


    public static int inputInterger ( String statement){
        int inputI = 0;
        boolean valid = false;
        do{
            try{
                   String temp = inputString(statement);
                   inputI = Integer.parseInt(temp);
                   valid = true;
            }
            catch (Exception e){
                System.out.println("Please input integer !!!");
                valid = false;
            }
        }while (!valid);

        return inputI;
    }


    public static double InputDouble (String statement){
        double inputD = 0;
        boolean valid = false;
        do{
            try {
                String temp = inputString(statement);
                inputD = Double.parseDouble(temp);
                valid = true;
            }
            catch (Exception e){
                System.out.println("Input again !!!");
            }
        }while (!valid);
        return inputD;
    }

    public static boolean inputGender (String statement){
        String temp ="";
        do{
            temp = inputString(statement);
            if (!temp.equals("1") && !temp.equals("0")){
                System.out.println("Please input again !!!");
            }
        }while (!temp.equals("1") && !temp.equals("0"));

        return temp.equals("1"); // Sẽ trả về true khi nhập 1 ( Nam ) và trả về false khi nhập 0 ( nữ )
    }

    public static Date inputDateOfBirth (String statement){
        boolean valid = false;
        int day = 0, month = 0, year = 0;
        /* Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        sdf.setLenient(false);
        do{
            try {
                String temp = inputString(statement);
                date = sdf.parse(temp);
                valid = true;
            }
            catch (Exception e){
                System.out.println("Input right with format dd-mm-yy");
            }
        }while (!valid);
        return date;*/

        // Nhập ngày
        do{
            try{
                day = inputInterger("Input day of birth: ");
                if (day < 1 || day > 31){
                    throw new Exception("Invalid day, please input day between 1 and 31 !!!");
                }
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid, please input valid day");
                valid = false;
            }
        }while (!valid);

        // Nhập tháng
        do{
            try{
                month = inputInterger("Input month of birth: ");
                if (month < 1 || month > 12){
                    throw new Exception("Invalid month, please input month between 1 and 12 !!!");
                }
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid, please input valid month");
                valid = false;
            }
        }while (!valid);

        // Nhập năm
        do{
            try{
                year = inputInterger("Input year of birth: ");
                if (year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)){ // Dòng này là để kiểm tra năm hiện tại để so sánh với năm nhập vào
                    throw new Exception("Invalid year, please input day between 1900 and now !!!");
                }
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid, please input valid year");
                valid = false;
            }
        }while (!valid);


        // Tạo hàm kiểm tra tính hợp lệ của ngày tháng năm và kết hợp lại
        Calendar cld = Calendar.getInstance();
        cld.setLenient(false); // Tăng tính chặt chẽ khi kiểm tra
        try{
            cld.set( year, month - 1, day); // Thiết lập ngày tháng năm cụ thể cho đối tượng cld
            return cld.getTime(); // Trả về đối tượng Date hợp lệ
        }
        catch (Exception e){
            System.out.println("Invalid Date. Please try again !!!");
            return inputDateOfBirth(statement); // Gọi lại hàm inputDateOfBirth để người dùng nhập lại nếu nhập không hợp lệ
        }

    }

}
