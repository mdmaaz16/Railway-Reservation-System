import java.util.Scanner;
import java.io.*;
class Railway
{
    int train_number;
    String train_name;
    String source;
    String destination;
    int seat_num;
    int dup_seat_num;
    int price;
    Scanner in = new Scanner(System.in);
    void get()
    {
        in.nextLine();
        System.out.print("\t\t\t\t\tEnter Train Number:");
        train_number = in.nextInt();
        in.nextLine();
        System.out.print("\t\t\t\t\tEnter Train Name:");
        train_name = in.nextLine();
        System.out.print("\t\t\t\t\tEnter Train Source:");
        source = in.nextLine();
        System.out.print("\t\t\t\t\tEnter Train destination:");
        destination = in.nextLine();
        System.out.print("\t\t\t\t\tEnter Number of seat in Train:");
        seat_num = in.nextInt();
        dup_seat_num = seat_num;
        System.out.print("\t\t\t\t\tEnter the cost of one seat:");
        price = in.nextInt();
        try{
            File F= new File("TrainList.txt");
            FileWriter fw = new FileWriter(F,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(train_number+"|"+train_name+"|"+source+"|"+destination+"|"+dup_seat_num+"|"+price+"|"+seat_num+"|");
            fw.close();
            pw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    void disp()
    {
        try{
            File file = new File("Trainlist.txt");
            Scanner B = new Scanner(file);
            while(B.hasNext())
            {
                String line = B.nextLine();
                String [] val = line.split("\\|");
                System.out.println("\n\t\t\t\t\tTrain Number:"+val[0]);
                System.out.println("\t\t\t\t\tTrain Name:"+val[1]);
                System.out.println("\t\t\t\t\tTrain Source:"+val[2]);
                System.out.println("\t\t\t\t\tTrain destination:"+val[3]);
                System.out.println("\t\t\t\t\tNo of seats :"+val[4]);
                System.out.println("\t\t\t\t\tCost of a seat:"+val[5]);
            }
            B.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    int seatcalulate(int tnum)
    {
        int m=0,m1;
        m1=tnum;
        try{
            File oldfile = new File("Trainlist.txt");
            File newfile = new File("TempTrain.txt");
            FileWriter fw = new FileWriter(newfile);
            PrintWriter pw = new PrintWriter(fw);
            Scanner B = new Scanner(oldfile);
            while(B.hasNext())
            {
                String line = B.nextLine();
                String [] val = line.split("\\|");
                int n3 = Integer.parseInt(val[0]);
                if(n3==m1)
                {
                    int n1 = Integer.parseInt(val[6]);
                    int n2 = Integer.parseInt(val[4]);
                    int x = n1-n2+1;
                    n2 = n2-1;
                    m=x;
                    val[4]=String.valueOf(n2);
                }
                String
                s=val[0]+"|"+val[1]+"|"+val[2]+"|"+val[3]+"|"+val[4]+"|"+val[5]+"|"+val[6]+"|";
                pw.println(s);
            }
            B.close();
            pw.close();
            fw.close();
            oldfile.delete();
            File F = new File("Trainlist.txt");
            newfile.renameTo(F);
        }
        catch (IOException e1) {
            System.out.println(e1);
        }
        return m;
    }
    public static boolean loginverify(String Username,String Password)
    {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        System.out.print("\t\t\t\t\tENTER USERNAME:");
        String name = in.nextLine();
        in.nextLine();
        System.out.print("\t\t\t\t\tENTER PASSWORD:");
        String pass = in.nextLine();
        if(name.equals(Username) && pass.equals(Password))
        return true;
        else
        return false;
    }
    void deletetrain(int del_tr)
    {
        try
        {
            File oldfile = new File("Trainlist.txt");
            File newfile = new File("TempTrain.txt");
            FileWriter fw = new FileWriter(newfile);
            PrintWriter pw = new PrintWriter(fw);
            Scanner B = new Scanner(oldfile);
            while(B.hasNext())
            {
                String line = B.nextLine();
                String [] val = line.split("\\|");
                int n1 = Integer.parseInt(val[0]);
                if(n1==del_tr)
                continue;
                else
                pw.println(line);
            }
            B.close();
            pw.close();
            fw.close();
            oldfile.delete();
            oldfile.getName();
            File F = new File("Trainlist.txt");
            newfile.renameTo(F);
        }
        catch (IOException e1) {
            System.out.println(e1);
        }
        System.out.println("\t\t\t\t\tTRAIN DETAIL DELETED SUCCESSFULLY");
    }
    void Bookticket(int tr_num,int tic)
    {
        Passenger P1[] = new Passenger[10];
        c:
        try{
            int k=0,n2=0,n1=0,j2=0;
            String [] val={" "," "," "," "," "," "," "};
            File file = new File("Trainlist.txt");
            Scanner B = new Scanner(file);
            while(B.hasNext())
            {
                String line = B.nextLine();
                val = line.split("\\|");
                int i=Integer.parseInt(val[4]);
                if(i<tic)
                {
                    System.out.println("\t\t\t\t\tSEAT NOT AVAILABLE IN THE TRAIN");
                    break c;
                }
                n1 = Integer.parseInt(val[0]);
                int j1=0;
                if(n1==tr_num)
                {
                    j2=1;
                    System.out.println("\t\t\t\t\tTRAIN FOUND");
                    B.close();
                    break;
                }
            }
            while(k<tic && j2==1)
            {
                int m= seatcalulate(tr_num);
                P1[k]=new Passenger();
                P1[k].get(m,n1);
                k++;
            }
            if(j2==1)
            {
                k=0;
                System.out.println("\t\t\t\t\tRAILWAY RESERVATION SYSTEM");
                System.out.println("\t\t\t\t\tPAYMENT BILL");
                System.out.println("Passenger name"+"\t"+"Passenger Aadhar NO"+"\t"+"Passenger Number"+"\t"+"Passenger Seat No"+""+"Passenger Train Number"+" "+"Passenger cost");
                while(k<tic)
                {
                    n2 = Integer.parseInt(val[5]);
                    P1[k].disppaymentdetails(n2);
                    k++;
                }
                int totalcost= n2*tic;
                System.out.println("\t\t\t\t\tTHE TOTAL COST OF THE TICKET RESERVATION IS:"+totalcost);
                Payment P = new Payment();
                P.getdetails(totalcost);
            }
        }
        catch (IOException e1) {
            System.out.println(e1);
        }
    }
}
class Payment
{
    Scanner in = new Scanner(System.in);
    void getdetails(int totalcost)
    {
        System.out.println("\n\t\t\t\t\tEnter how do you want to do the Payment");
        System.out.println("\t\t\t\t\t1.Pyament by netbanking");
        System.out.println("\t\t\t\t\t2.Payment by Debit card");
        System.out.println("\t\t\t\t\t3.Payment by Credit card");
        System.out.println("\t\t\t\t\t4.Payment by UPI");
        System.out.print("\t\t\t\t\tEnter your option:");
        int opt = in.nextInt();
        if(opt==1)
        {
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the bank name:");
            String bankname=in.nextLine();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the Account Number:");
            String acc_no=in.nextLine();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the bank branch name:");
            String bankbranch=in.nextLine();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the IFSC code:");
            int IFSC=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter OPT Which is sent to your Phone number:");
            int otp=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter any key to pay the total amount of "+totalcost);
            in.nextLine();
            System.out.println("\t\t\t\t\tTHANK YOU!!!");
            System.out.println("\t\t\t\t\tYOUR RESERVATION IS SUCCESSFULL");
        }
        else if(opt==2)
        {
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the Debit card Number:");
            int cardnum=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter CVV Number:");
            int cvv=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the Card Holder name:");
            String bankbranch=in.nextLine();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter OPT Which is sent to your Phone number:");
            int otp=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter any key to pay the total amount of "+totalcost);
            in.nextLine();
            System.out.println("\t\t\t\t\tTHANK YOU!!!");
            System.out.println("\t\t\t\t\tYOUR RESERVATION IS SUCCESSFULL");
        }
        else if(opt==3)
        {
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the Credit card Number:");
            int cardnum=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter CVV Number:");
            int cvv=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter the Card Holder name:");
            String bankbranch=in.nextLine();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter OPT Which is sent to your Phone number:");
            int otp=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter any key to pay the total amount of "+totalcost);
            in.nextLine();
            System.out.println("\t\t\t\t\tTHANK YOU!!!");
            System.out.println("\t\t\t\t\tYOUR RESERVATION IS SUCCESSFULL");
        }
        else
        {
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter Phone Number:");
            int phone=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter UPI Password:");
            int upi=in.nextInt();
            in.nextLine();
            System.out.print("\t\t\t\t\tEnter any key to pay the total amount of "+totalcost);
            in.nextLine();
            System.out.println("\t\t\t\t\tTHANK YOU!!!");
            System.out.println("\t\t\t\t\tYOUR RESERVATION IS SUCCESSFULL");
        }
    }
}
class Passenger
{
    String Passenger_name;
    Long Passenger_aadharno;
    Long contact_no;
    int seat_no;
    int pass_train_number;
    Scanner in = new Scanner(System.in);
    void get(int x,int y)
    {
        in.nextLine();
        System.out.print("\t\t\t\t\tENTER PASSENGER NAME:");
        Passenger_name = in.nextLine();
        System.out.print("\t\t\t\t\tENTER PASSENGER AADHAR NO:");
        Passenger_aadharno = in.nextLong();
        System.out.print("\t\t\t\t\tENTER PASSENGER NUMBER:");
        contact_no = in.nextLong();
        seat_no = x;
        pass_train_number = y;
        try{
            File F= new File("PassengerList.txt");
            FileWriter fw = new FileWriter(F,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(Passenger_name+"|"+Passenger_aadharno+"|"+contact_no+"|"+seat_no+"|"+pass_train_number+"|");
            fw.close();
            pw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    void disppaymentdetails(int cost)
    {
        System.out.println(Passenger_name+"\t\t\t"+Passenger_aadharno+"\t\t\t"+contact_no+"\t\t\t"+seat_no+"\t\t\t"+pass_train_number+"\t\t"+cost);
    }
    void display()
    {
        try{
            File file = new File("PassengerList.txt");
            Scanner B = new Scanner(file);
            while(B.hasNext())
            {
                String line = B.nextLine();
                String [] val = line.split("\\|");
                System.out.println("\n\t\t\t\t\tPassenger Name:"+val[0]);
                System.out.println("\t\t\t\t\tPassenger Aadharno:"+val[1]);
                System.out.println("\t\t\t\t\tPassenger Contact Number:"+val[2]);
                System.out.println("\t\t\t\t\tPassenger Seat Number:"+val[3]);
                System.out.println("\t\t\t\t\tPassenger Train Number:"+val[4]);
            }
            B.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
class Admin2 extends Railway
{
    public static void main(String[] args) {
        int n=0,choice;
        String Username="admin";
        String Password="1234";
        Admin2 A = new Admin2();
        Passenger P = new Passenger();
        do
        {
            int opt=0;
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("\t\t\t\t\tWELCOME TO RAILWAY RESERVATION SYSTEM");
            System.out.println("\t\t\t\t\t\t1.ADMIN");
            System.out.println("\t\t\t\t\t\t2.TRAIN DETAILS");
            System.out.println("\t\t\t\t\t\t3.BOOK TICKET");
            System.out.println("\t\t\t\t\t\t4.EXIT");
            System.out.print("\t\t\t\t\tENTER YOUR OPTION:");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                if(Railway.loginverify(Username,Password))
                {
                    System.out.println("\t\t\t\t\tSUCCESSFULLY LOGGED IN");
                    System.out.println("\n\t\t\t\t\t1.ADD TRAIN");
                    System.out.println("\t\t\t\t\t2.DELETE TRAIN");
                    System.out.println("\t\t\t\t\t3.PASSENGER LIST");
                    System.out.println("\t\t\t\t\t4.BACK");
                    System.out.print("\t\t\t\t\tEnter your option:");
                    opt = in.nextInt();
                    if(opt==1)
                    {
                        System.out.println("\n\t\t\t\t\tWELCOME ADMIN");
                        System.out.println("\t\t\t\t\tADD TRAIN DETAILS");
                        System.out.print("\t\t\t\t\tENTER HOW MANY TRAIN DETAILS YOU WANT TO INSERT:");
                        int details = in.nextInt();
                        n=0;
                        while(n<details)
                        {
                            A.get();
                            n++;
                        }
                        System.out.println("\t\t\t\t\tTRAIN ADDED SUCCESSFULLY");
                    }
                    else if(opt==2)
                    {
                        int del_tr,i;
                        System.out.print("\t\t\t\t\tENTER THE TRAIN NUMBER YOU WANT TO DELETE:");
                        del_tr = in.nextInt();
                        A.deletetrain(del_tr);
                    }
                    else if(opt==3)
                    {
                        P.display();
                    }
                }
                else
                {
                    System.out.println("\t\t\t\t\tINVALID LOGIN");
                    System.out.println("\t\t\t\t\tPLEASE TRY AGAIN");
                }
                break;
                case 2:
                System.out.println("\t\t\t\t\tWELCOME");
                System.out.println("\n\t\t\t\t\tTRAIN DETAILS");
                A.disp();
                break;
                case 3:
                System.out.println("\t\t\t\t\tWELCOME TO TRAIN BOOKINGS SECTION");
                System.out.print("\t\t\t\t\tENTER TRAIN NUMBER TO BOOK THE TICKET:");
                int tr_num = in.nextInt();
                System.out.print("\t\t\t\t\tENTER HOW MANY TICKETS YOU WANT TO BOOK:");
                int tic = in.nextInt();
                A.Bookticket(tr_num,tic);
                break;
            }
            
        }while(choice!=4);
    }
}