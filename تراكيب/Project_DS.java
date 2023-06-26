
package project_ds;

import java.util.Scanner;

public class Project_DS {
    //node's head//
    private Node EmRe;
    //node Creation//
    private class Node{
        //next node//
        private Node next;

        //dataFields Employees info//
        private int emID;
        private String name;
        private String FirstDayOW;
        private String Address;
        private String phoneNumber;
        private double Hours;
        private double Salary;


        //assigning employee's data for the constructor//
        public Node(int emID,String name,String FirstDayOW,String Address,String phoneNumber,double Hours,double Salary){
            this.emID=emID;
        this.name=name;
        this.FirstDayOW=FirstDayOW;
        this.Address=Address;
        this.phoneNumber=phoneNumber;
        this.Hours=Hours;
        this.Salary=Salary;
        this.next=null;
    }
}

    /////////insertion method/////////
    public void insertion(int emID,String name,String FirstDayOW,String Address,String phoneNumber,double Hours,double Salary){
        if(!RecChecker(emID)){
            Node newEmployee= new Node(emID, name, FirstDayOW, Address, phoneNumber, Hours, Salary);
            Node temp = EmRe;
            if (EmRe==null){
                EmRe = newEmployee;
                System.out.println("(O)employee has been added successfully.");
                return;
            }
            while(temp.next !=null){
                temp=temp.next;
            }

            temp.next = newEmployee;
            System.out.println("(O)employee has been added successfully.");



        }else {
            System.out.println("(x)employee ID already assigned to another Employee.");
        }

    }

    /////////checker/////////
    public boolean RecChecker(int emID){

        //checker in linked list

        Node temp = EmRe;
        //false condition//
        if(temp == null){
            return false;
        }
        //true condition//

        //moving through node//
        while (EmRe !=null&&temp !=null){

            if(temp.emID==emID){
                return true;

            }
            temp = temp.next;
        }
        return false;

    }

    /////////Search Method/////////
    public void search(int emID){
        Node temp=EmRe;
        if(RecChecker(emID)){
            while(temp.next!=null&&temp.emID!=emID) {
                temp=temp.next;
            }

            System.out.println("------------------------");
            System.out.println("Employee ID: "+temp.emID+ "\n Name: "+temp.name+" \n First Day Of Work: "+temp.FirstDayOW+"\n Address: "+temp.Address+"\n PhoneNumber: "+temp.phoneNumber+"\n Hour: "+temp.Hours+"\n Salary: "+temp.Salary);
            System.out.println("------------------------");

            return; }else{
            System.out.println("(x)Employee Does Not Exist.");
            System.out.println("Employee doesn't exist"); }
    }
    /////////Record Method/////////
    public void EmRecords(){
        Node temp= EmRe;
        System.out.println("-----------------------------------------");
        while(temp!=null) {

            System.out.println("Employee ID: "+temp.emID+ "\n Name: "+temp.name+" \n First Day Of Work: "
                    +temp.FirstDayOW+"\n Address: "
                    +temp.Address+"\n PhoneNumber: "
                    +temp.phoneNumber+"\n Hour: "+temp.Hours+"\n Salary: "+temp.Salary);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            temp = temp.next;
        }
        System.out.println("-----------------------------------------");
    }
    /////////deletion/////////
    public int deletion(int ID){
        Node temp= EmRe;
        Node prev = null;
        if(temp != null && temp.emID == ID){
            EmRe = temp.next;
            return 1;
        }
        while(temp!=null&&temp.emID!=ID){
            prev = temp;
            temp = temp.next;
        }

        if(temp==null){
            return 0;
        }
        prev.next = temp.next;
        System.out.println("(O)Employee has been deleted successfully.");
        return 1;
    }

    /////////Update Salary/////////
    public void UpdateSalary(){
        if(EmRe==null){
            return;
        }
        Node temp = EmRe;
        while(temp!=null){
            if(temp.Hours>32) {
                temp.Salary += (temp.Salary * .02);
                System.out.println("(O)Salary has been updated. The new salary is: "+EmRe.Salary);

            }

            temp=temp.next;
        }
    }
    /////////Update Employee/////////
    public void UpdateEmployee(int emID){
        Scanner scan = new Scanner(System.in);
        Node temp=EmRe;
        if(RecChecker(emID)){
            System.out.println("Successfully exited ID.");

            //assigning the pointer temp to the correct ID//
            while(temp.emID!=emID){
                temp= temp.next;
            }

            //ID
            System.out.print("Enter the new ID: ");
            int newID= scan.nextInt();
            while(RecChecker(newID)){
                System.out.print("Sorry an exited ID try another one: ");
                newID= scan.nextByte();}
            temp.emID= newID;
            System.out.println("(O)successfully changed.");

            // fix glitch //
            scan.nextLine();
            //            //
            //Name
            System.out.print("Enter the new name: ");
            temp.name=scan.nextLine();
            System.out.println("(O)successfully changed.");


            //FirstDayOfWorking
            System.out.print("Enter the new First Day Of Working: ");
            temp.FirstDayOW=scan.nextLine();
            System.out.println("(O)successfully changed.");

            //Address
            System.out.print("Enter the new Address: ");
            temp.Address=scan.nextLine();
            System.out.println("(O)successfully changed.");

            //PhoneNumber
            System.out.print("Enter the new PhoneNumber: ");
            temp.phoneNumber=scan.nextLine();
            System.out.println("(O)successfully changed.");

            //Hours
            System.out.print("Enter the new Hours: ");
            temp.Hours=scan.nextDouble();
            System.out.println("(O)successfully changed.");

            //Salary
            System.out.print("Enter the new Salary: ");
            temp.Salary=scan.nextDouble();
            System.out.println("(O)successfully changed.");

            System.out.println("all new employee's information has been saved.");
        }else{
            System.out.println("(x)The required ID not found.");
        }
    }

    //main//
    public static void main(String[] args) {
        System.out.println("####Welcome to Employee record management system####\n ");

        Scanner scan =new Scanner(System.in);
        int choose,ID;
        double Hours,Salary;
        String name,Day,phoneNumber,Address;

        boolean flag=true;
        Project_DS employee =new Project_DS();

        while(flag){
            System.out.println("       1- Insert employee record.\n" +
                    "       2- Delete employee record.\n" +
                    "       3- Update employee record.\n" +
                    "       4- Show employee.\n" +
                    "       5- Search employee.\n" +
                    "       6- Update salary.\n"+
                    "       7- Exit of the system.\n");
            System.out.println("Select your choice ");
            choose=scan.nextInt();
            switch(choose){
                case 1:
                    System.out.print("Please enter the ID: ");
                    ID = scan.nextInt();
                    while(employee.RecChecker(ID)){
                        System.out.println("(x)please Enter another ID:");
                        ID = scan.nextInt();
                    }
                    System.out.println("(O)successfully added.");
                    //
                    //fix glitch
                    scan.nextLine();
                    //Name
                    System.out.print("Enter the name: ");
                    name=scan.nextLine();
                    System.out.println("(O)successfully added.");
                    //FirstDayOfWorking
                    System.out.print("Enter First Day Of Working: ");
                    Day=scan.nextLine();
                    System.out.println("(O)successfully added.");
                    //Address
                    System.out.print("Enter the Address: ");
                    Address=scan.nextLine();
                    System.out.println("(O)successfully added.");
                    //PhoneNumber
                    System.out.print("Enter the PhoneNumber: ");
                    phoneNumber=scan.nextLine();
                    System.out.println("(O)successfully added.");
                    //Hours
                    System.out.print("Enter the employee's Hours: ");
                    Hours=scan.nextDouble();
                    System.out.println("(O)successfully added.");
                    //Salary
                    System.out.print("Enter the employee's Salary: ");
                    Salary=scan.nextDouble();
                    System.out.println("(O)successfully added.");

                    employee.insertion(ID,name,Day,Address,phoneNumber,Hours,Salary);

                    System.out.println("The insertion has been completed.");

                    break;
                case 2:
                    System.out.println("Please enter the ID:");
                    ID = scan.nextByte();
                    if(employee.deletion(ID)==1){
                        System.out.println("The employee records has been deleted .");

                    }else{System.out.println("The employee's ID does not exist.' .");}
                    break;
                case 3:
                    System.out.print("Please enter the ID: ");
                    ID = scan.nextInt();
                    employee.UpdateEmployee(ID);
                    break;
                case 4:
                    employee.EmRecords();

                    break;
                case 5:
                    System.out.println("Please enter the ID:");
                    ID = scan.nextInt();
                    employee.search(ID);
                    break;
                case 6:
                    employee.UpdateSalary();
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice");


            }
        }
        //exit operation//
        System.out.println("Have a nice Day.");

    }

}