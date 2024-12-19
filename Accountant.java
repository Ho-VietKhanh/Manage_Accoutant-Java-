package Practice_Interface;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Accountant extends Person implements Working, Serializable {
    private static final long serialVersionUID = 1L;
    private double basicSalary;
    private int reward;

    public Accountant(){
        basicSalary = 0;
        reward = 0;
    }

    public Accountant(String id, String firstName, String surName, Date birthday, boolean gender, String phone, double basicSalary, int reward) {
        super(id, firstName, surName, birthday, gender, phone);
        this.basicSalary = basicSalary;
        this.reward = reward;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public double earnMoney(){
        return basicSalary + reward ;
    }

    @Override
    public double tax(){
        double tax_1000_3000;
        double tax_more_3000;

        if (earnMoney() < 1000){
            System.out.println("No tax");
            return 0 ;
        }

        else if (earnMoney() >= 1000 && earnMoney() < 3000){
            tax_1000_3000 = (earnMoney() - 1000) * ((double) 10/100);
            return tax_1000_3000;
        }

        else {
            tax_more_3000 = 200 + (earnMoney() - 3000) *((double) 25/100);
            // Với 200 là mức thuế cho phần thu nhập từ 1000-2999 ( đây là khoảng thu nhập bị đánh thuế 10% là 200$  ( 3000-1000 )
            // earnMoney - 3000 : Tức là phần thuế vượt mức 3000
            return tax_more_3000;
        }

    }

    @Override
    public String toString() {
        return String.format("%s %-23.2f %-10d", super.toString(), basicSalary, reward);
    }


}
