import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
class employee
{
    public static double cap=5000000;
    String name;
    String post;
    double salary;
    employee(String s,String po){
        name=s;post=po;
        if(po.equals("chef"))
            salary=40000;
        else if(po.equals("server"))
            salary=20000;
        else if(po.equals("manager"))
            salary=30000;
        else if(po.equals("housekeeping"))
            salary=15000;
    }
    void show()
    {
        System.out.println();
        System.out.println("NAME: "+name);
        System.out.println("DESGINATION: "+post);
        System.out.println("SALARY PER MONTH: "+salary);
    }
    void credit()
    {
        System.out.println();
        System.out.println("NAME: "+name);
        System.out.println("DESGINATION: "+post);
        System.out.println("SALARY OF AMOUNT "+salary+" IS CREDITED TO "+name);
        cap=cap-salary;
    }
}
class Customer{
    String Custname;
    int numofppl;
    int mobileno;
    String mailid;
    int custid;
    Customer(String name,int ppl,int no,String id){
        Custname=name;
        numofppl=ppl;
        mobileno=no;
        mailid=id;
    }
    void display(){
        System.out.println("Customer details");
        System.out.println("Customer name is : "+Custname);
        System.out.println("Number of people : "+numofppl);
        System.out.println("Customer mobileno : "+mobileno);
        System.out.println("Customer mailid :"+mailid);
        System.out.println("The customer id is : "+custid);
    }
}
class Menu{
    int itemid;
    void disveg(){
        String[] veg= new String[]{"Dosa Rs120","Poori Rs100","Chapati Rs100","Roti Rs60","Naan Rs70","Idli Rs50"};
        System.out.println("The dishes available in veg section are :");
        for (int i = 0; i < veg.length; i++) {
            System.out.println(veg[i]);
        }
    }

    void disnonv(){
        String[] nonveg=new String[]{"Chicken biryani Rs180","Mutton biryani Rs200","Butter chicken Rs160","Egg biryani Rs140"};
        System.out.println("The dishes available in nonveg section are :");
        for (int i = 0; i < nonveg.length; i++) {
            System.out.println(nonveg[i]);
        }
    }

    void menu(){
        disveg();
        disnonv();
    }

    void menu(int itemid){
        if(itemid==1)
            disveg();
        else if(itemid==2)
            disnonv();
    }
}
class Order{
    int min=1,max=10;
    int orderid=(int)(Math.random()*(max-min+1)+min);
    String itemname;
    int quantity;
    int number;
    int choice;
    public static int fprice;
    void placeorder(){
        System.out.println("Your order id is "+orderid);
        System.out.println();
        System.out.print("Enter the number of dishes to be ordered :");
        Scanner inpn=new Scanner(System.in);
        number=inpn.nextInt();
        inpn.nextLine();
        Dictionary dict=new Hashtable();
        String[] dishes=new String[number];
        System.out.println();
        for (int i =number,j=0; i >0; i--,j++) {
            System.out.print("Enter the dish ");
            itemname=inpn.nextLine();
            dishes[j]=itemname;
            System.out.print("Enter the quantity of dish ");
            quantity=inpn.nextInt();
            inpn.nextLine();
            dict.put(itemname,quantity);
        }
        System.out.println();
        String[] veg= new String[]{"Dosa","Poori","Chapati","Roti","Naan","Idli"};
        int[] vegp=new int[]{120,100,100,60,70,50};
        Dictionary vegd=new Hashtable();
        Dictionary alld=new Hashtable();
        for (int i = 0; i < vegp.length; i++) {
            vegd.put(veg[i], vegp[i]);
            alld.put(veg[i],vegp[i]);
        }
        String[] nonveg=new String[]{"Chicken biryani","Mutton biryani","Butter chicken","Egg biryani"};
        int[] nonvegp=new int[]{180,200,160,140};
        Dictionary nonvegd=new Hashtable();
        for (int i = 0; i < nonvegp.length; i++) {
            nonvegd.put(nonveg[i], nonvegp[i]);
            alld.put(nonveg[i], nonvegp[i]);
        }
        if(choice==1){ //veg
            for(int i=0;i<dishes.length;i++){
                int dishprice=(int)(vegd.get(dishes[i]));
                int qt=(int)(dict.get(dishes[i]));
                fprice=fprice + (dishprice*qt);
            }
            System.out.println("The total food cost is "+fprice);
        }
        else if(choice==2){ //nonveg
            for(int i=0;i<dishes.length;i++){
                int dishprice=(int)(nonvegd.get(dishes[i]));
                int qt=(int)(dict.get(dishes[i]));
                fprice=fprice + (dishprice*qt);
            }
            System.out.println("The total food cost is "+fprice);
        }
        else if(choice==3){ //both
            for(int i=0;i<dishes.length;i++){
                System.out.print(dishes);
                System.out.println(alld.get(dishes[i]));
                int dishprice=(int)(alld.get(dishes[i]));
                int qt=(int)(dict.get(dishes[i]));
                fprice=fprice + (dishprice*qt);
            }
            System.out.println("The total food cost is "+fprice);
        }
        System.out.println("Order has been placed successfully!!");
    }
}
class Billgeneration{
    int choicee;
    int room;
    int food;
    public static int totalcost;
    void bill(){
        totalcost=room+food;
        System.out.println("The total cost is "+totalcost);
    }
}
class Room{
    //Standard delux elite
    String type;
    int numofdays;
    int cost;
    public static int rprice;
    Room(int r,int n){
        numofdays=n;
        if(r==1){type="Standard";cost=2000;}
        else if(r==2){type="Delux";cost=3000;}
        else if(r==3){type="Elite";cost=5000;}
    }
    void price_cal(){
        rprice=cost*numofdays;
        System.out.println();
        System.out.println("The total room cost is "+rprice);
        System.out.println("The room has been booked succesfully!!");
        System.out.println();
    }
}
public class hotel {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        while(true) {
            System.out.print("\nEnter the choice 1.ADMIN 2.CUSTOMER SERVICE 3.FEEDBACK FORM 4.EXIT : ");
            int ch = inp.nextInt();
            if (ch == 1) {
                System.out.println("The initial capital of hotel is 50 crores");
                System.out.println("The updations in capital will be reflected for the current execution.");
                System.out.print("\nEnter the number of employees to add:");
                int numb = inp.nextInt();
                employee employees[] = new employee[10];
                while(true) {
                    System.out.println("\n1.ADD & DISPLAY EMPLOYEES");
                    System.out.println("2.CREDIT SALARY FOR EMPLOYEES & DISPLAY THE BALANCE AMOUNT WITH HOTEL");
                    System.out.println("3.STOP WITH EMPLOYEE OPERATIONS");
                    //add employees
                    int cho = inp.nextInt();
                    if (cho == 1) {
                        System.out.println("CREATING AN ARRAY OF OBJECTS FOR EMPLOYEES");
                        for (int k = 0; k < numb; k++) {
                            System.out.println("\nEnter Employee name :");
                            String na = inp.next();
                            System.out.println("Chef=40k Server=20k Manager=30k Housekeeping=15k PER MONTH IS SET");
                            System.out.println("Enter job assigned- chef/server/housekeeping/manager:");
                            String po = inp.next();
                            employees[k] = new employee(na,po);
                        }
                        for (int i = 0; i < numb; i++) employees[i].show();
                    }
                    else if (cho == 2) {
                        for (int i = 0; i < numb; i++) {
                            employees[i].credit();
                            System.out.println("CAPITAL IS REDUCED TO "+employees[i].cap);
                        }
                    }
                    else if(cho==3)
                        break;
                }
                System.out.println("DONE WITH ADMIN SIDE");
                //money transactions of hotel
                //employee details(salary generation)
            } else if (ch == 2) {
                System.out.println("You entered into CUSTOMER SERVICE side");
                System.out.println();
                int min = 1, max = 300;
                //CUSTOMER DETAILS ENTRY
                System.out.println("Enter Customer details");
                System.out.print("Enter customer name :");
                String name = inp.next();
                System.out.print("Enter number of people :");
                int noofppl = inp.nextInt();
                System.out.print("Enter mobile number :");
                int mobileno = inp.nextInt();
                System.out.print("Enter mailid :");
                String mailid = inp.next();
                Customer C = new Customer(name, noofppl, mobileno, mailid);
                C.custid = (int) (Math.random() * (max - min + 1) + min);
                System.out.println();
                C.display();
                System.out.println();
                //CUSTOMER CHOICE
                System.out.print("Do you want to ");
                System.out.print("1.BOOK ROOM ");
                System.out.print("2.ORDER FOOD ");
                System.out.print("3.ORDER FOOD AND BOOK ROOM ");
                int c = inp.nextInt();
                Billgeneration B = new Billgeneration();
                B.choicee = c;
                System.out.println();
                if (c == 1) {
                    System.out.print("Enter the room type 1.STANDARD 2.DELUX 3.ELITE : ");
                    int r = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter number of days of stay : ");
                    int n = inp.nextInt();
                    Room R = new Room(r, n);
                    R.price_cal();
                    B.room = R.rprice;
                    System.out.println();
                    B.bill();
                    System.out.println("out"+Room.rprice);
                } else if (c == 2) {
                    System.out.print("Enter your food choice 1.VEG 2.NONVEG 3.BOTH :");
                    System.out.println();
                    int f = inp.nextInt();
                    Menu M = new Menu();
                    if (f == 3)
                        M.menu();
                    else
                        M.menu(f);
                    Order O = new Order();
                    O.choice = f;
                    O.placeorder();
                    B.food = O.fprice;
                    System.out.println();
                    B.bill();
                    System.out.println("out"+Order.fprice);

                } else if (c == 3) {
                    System.out.print("Enter your food choice 1.VEG 2.NONVEG 3.BOTH :");
                    int f = inp.nextInt();
                    Menu M = new Menu();
                    if (f == 3)
                        M.menu();
                    else
                        M.menu(f);
                    Order O = new Order();
                    O.choice = f;
                    O.placeorder();
                    B.food = O.fprice;
                    System.out.println();
                    System.out.print("Enter the room type 1.STANDARD 2.DELUX 3.ELITE : ");
                    int r = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter number of days of stay : ");
                    int n = inp.nextInt();
                    Room R = new Room(r, n);
                    R.price_cal();
                    B.room = R.rprice;
                    B.bill();
                    System.out.println(Billgeneration.totalcost);
                }
                //customer object
                //food objects-server-bookorder-foodbill
                //room related tasks-room booking-roombill generation
                //food+room
                //total bill generation and terminate
            }
            else if(ch==3){
                System.out.println("CREATING A FEEDBACK FORM AND STORING IT INTO A TEXT FILE");
                feedback fwj= new feedback();
            }
            else if (ch == 4) {
                System.out.println("Thank you now exiting");
                System.exit(0);
            }
        }
    }
}
 
