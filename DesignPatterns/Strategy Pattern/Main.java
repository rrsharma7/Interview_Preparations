package strategy_pattern;

import strategy_pattern.strategies.Consultant;
import strategy_pattern.strategies.LeadConsultant;
import strategy_pattern.strategies.SeniorConsultant;

public class Main {
    public static void main(String[] args) {
        Employee ram = new Employee("Ram", new Consultant());
        Employee rahul = new Employee("Rahul", new SeniorConsultant());

        System.out.println("=======Before promotion=======\n");

        ram.doWork();
        rahul.doWork();

        ram.promote(new SeniorConsultant());
        rahul.promote(new LeadConsultant());

        System.out.println("\n=======After promotion=======\n");

        ram.doWork();
        rahul.doWork();
    }
}
