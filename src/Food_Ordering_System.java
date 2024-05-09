import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import net.efabrika.util.DBTablePrinter;
import java.util.Calendar;
import java.lang.*;
import net.efabrika.util.DBTablePrinter;
import java.time.*;
import java.time.format.DateTimeFormatter;

 public class Food_Ordering_System {

    static Scanner sc = new Scanner(System.in);

    // main method
    public static void main(String[] args) throws Exception{
        String dburl = "jdbc:mysql://localhost:3306/food_ordering_system";
        String dbuser = "root";
        String dbpaasword = "";
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);
        Connection c = DriverManager.getConnection(dburl, dbuser, dbpaasword);
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", dbuser, dbpaasword);
        if(c != null){
            System.out.println("Connection successfull");
        }
        else{
            System.out.println("Connection unsccessfull");
        }
        Food_Ordering_System fos = new Food_Ordering_System();
        Thread.sleep(500);
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                    |");
        System.out.println("|                    ONLINE FOOD ORDERING SYSTEM                     |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        fos.User(c,c1);
    }

    // user method 
    public static void User(Connection c,Connection c1) throws Exception{
        while(true){
        System.out.println();
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                    |");
        System.out.println("|                           INTERFACE                                |");
        System.out.println("|                                                                    |");
        System.out.println("|                 Press 1 ---> If You Are Admin.                     |");
        System.out.println("|                 Press 2 ---> If You Are Customer.                  |");
        System.out.println("|                                                                    |");
        System.out.println("|                 Press 3 ---> Exit.                                 |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");    
        System.out.println();
        System.out.print("Enter your choice : ");
        int choice ;
        try{
           choice = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
           choice = -1;
           System.out.println();
           System.out.println(e+"\n");
        }
        switch(choice){
          case 1:{
              admin(c,c1);
              break;
          }
          case 2:{
            customer(c,c1);
              break;
          }
          case 3:{
            System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
            System.out.println("|                                                                    |");
            System.out.println("|                        EXITING THE PROGRAM                         |");
            System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
              System.exit(0);
          }
          default :{
              System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
              System.out.println();   
              System.out.println("Invalid choice (enter 1 or 2 or 3)");
              System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");   
          }
        }
    }
}

// admin method
public static void admin(Connection c,Connection c1) throws Exception{
    admin_password();
    System.out.println();
    Thread.sleep(500);
    System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
    System.out.println("|                                                                    |");
    System.out.println("|              ==== WELCOME TO ADMIN INTERFACE ===                   |");
    System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
    while(true){
    System.out.println();
    System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
    System.out.println("|                                                                    |");
    System.out.println("|                        ADMIN HOME PAGE                             |");
    System.out.println("|                                                                    |");
    System.out.println("|         Press 1. To get Food items details.                        |");
    System.out.println("|         Press 2. To add new food items in menu.                    |");
    System.out.println("|         Press 3. To update any food items prices in list.          |");
    System.out.println("|         Press 4. To delete any food items from the list.           |");
    System.out.println("|         Press 5. Return.                                           |");
    System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
    System.out.println();
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");    
    System.out.println();
    System.out.print("Enter your choice : ");
    int choice ;
    try{
         choice = Integer.parseInt(sc.nextLine());
    }catch(Exception e){
        choice = -1;
        System.out.println();
        System.out.println(e+"\n");
    }
    switch(choice){
        case 1:{
            getItemsDetais(c,c1);
            break;
        }
        case 2:{
            addItems(c);
            break;
        }
        case 3:{
            update(c);
            break;
        }
        case 4:{
            delete(c);
            break;
        }
        case 5:{
            User(c,c1);
            break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("Invalid choice (enter between 1 to 5 )");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        }
      }
   }
}

// method to get food items
public static void getItemsDetais(Connection c,Connection c1) throws Exception{
    
    Thread.sleep(500);
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    String sql = "Select * from menu";
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DBTablePrinter.printResultSet(rs, 15);
    while(rs.next()){
    System.out.println("No : " + rs.getInt(1));
    System.out.println("Item Name : " + rs.getString(2));
    }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        System.out.println("Which Food Details You want...");
        System.out.println();
        System.out.print("Enter your choice : "); 
        int choice  ;
        try{
            choice = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println();
            choice = -1;
            System.out.println(e+"\n");
        }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
   switch(choice){
    case 1:{
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Tea";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 15);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
    }
    case 2:{
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Burger";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 15);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
    }
    case 3:{
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Sandwich";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 28);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
    }
    case 4 :{
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Pizza";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 30);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
    }
    case 5 :{
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Shakes";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 25);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
    }
    case 6:{  
        Thread.sleep(500);
        System.out.println();
        String sql1 = "Select * from Ice_Cream";
        Statement st1 = c.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        DBTablePrinter.printResultSet(rs1, 15);
        while(rs1.next()){
            System.out.println("No : " + rs1.getInt(1));
            System.out.println("Item Name : " + rs1.getString(2));
        }
        break;
     }
   }
}

// method to update any food 
public static void update(Connection c) throws Exception{
    Thread.sleep(500);
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    String sql = "Select * from menu";
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DBTablePrinter.printResultSet(rs, 15);
    while(rs.next()){
    System.out.println("No : " + rs.getInt(1));
    System.out.println("Item Name : " + rs.getString(2));
    }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    System.out.println("In Which Food You want to update...?");
    System.out.println();
    System.out.print("Enter your choice : ");
    int choice ;
    try{
        choice = Integer.parseInt(sc.nextLine()); 
    }catch(Exception e){
        System.out.println();
        choice = -1;
        System.out.println(e+"\n");
    }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    switch(choice){
        case 1:{
            Thread.sleep(500);
            String sql1 = "Select * from Tea";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
            int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Tea Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update tea set Prices = ? where id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

            }
            break;
        }
        case 2:{
            Thread.sleep(500);
            String sql1 = "Select * from Burger";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
             int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Burger Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update Burger set Prices = ? where id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            }
           break;
        }
        case 3:{
            Thread.sleep(500);
            String sql1 = "Select * from Sandwich";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 28);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
             int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Sandwich Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update Sandwich set Prices = ? where id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
           break;
        }
        case 4 :{
            Thread.sleep(500);
            String sql1 = "Select * from Pizza";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 30);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
             int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Pizza Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update Pizza set Prices = ? where id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println();
            }
           break;
        }
        case 5 :{
            Thread.sleep(500);
            String sql1 = "Select * from Shakes";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 25);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
             int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Shake Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update Shakes set Prices = ? where id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            break;
        }
        case 6:{  
            Thread.sleep(500);
            String sql1 = "Select * from Ice-Cream";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
             int s ;
            double p ;
            while(true){
            try{
                System.out.print("Enter Ice-Cream Id : ");
                s = Integer.parseInt(sc.nextLine());
                System.out.println();
                System.out.print("Enter Prices to update : ");
                p = Double.parseDouble(sc.nextLine());
                break;
            }catch(Exception e){
                  s = 0 ;
                  p = 0.0;
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "Update Ice-Cream set Prices = ? where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setDouble(1, p);
            pst.setInt(2,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("UPDATED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT UPDATE");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
           break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("invalid choice (enter between 1 to 6)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        }
    }
}

//method to delete food 
public static void delete(Connection c) throws Exception{
    Thread.sleep(500);   
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    String sql = "Select * from menu";
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DBTablePrinter.printResultSet(rs, 15);
    while(rs.next()){
    System.out.println("No : " + rs.getInt(1));
    System.out.println("Item Name : " + rs.getString(2));
    }
    System.out.println();
    System.out.println("In Which Food You want to delete...");
    System.out.println();
    System.out.print("Enter your choice : ");
    int choice  ;
    try{
        choice = Integer.parseInt(sc.nextLine());
    }catch(Exception e){
        System.out.println();
        choice = -1;
        System.out.println(e+"\n");
    }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    switch(choice){
        case 1:{
            Thread.sleep(500);
            String sql1 = "Select * from Tea";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Tea Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from tea where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            break;
        }
        case 2:{
            Thread.sleep(500);
              String sql1 = "Select * from Burger";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Burger Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from burger where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
           break;
        }
        case 3:{
            Thread.sleep(500);
            String sql1 = "Select * from Sandwich";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 28);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
           System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Sandwich Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from Sandwich where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
           break;
        }
        case 4 :{
            Thread.sleep(500);
            String sql1 = "Select * from Pizza";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 30);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Pizza Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from Pizza where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
           break;
        }
        case 5 :{
            Thread.sleep(500);
            String sql1 = "Select * from Shakes";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 25);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
          System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Shake Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from shakes where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            }
            break;
        }
        case 6:{  
            Thread.sleep(500);
            String sql1 = "Select * from Ice-Cream";
            Statement st1 = c.createStatement();
            ResultSet rs1 = st1.executeQuery(sql1);
            DBTablePrinter.printResultSet(rs1, 15);
            while(rs1.next()){
                 System.out.println("No : " + rs1.getInt(1));
                 System.out.println("Item Name : " + rs1.getString(2));
            }
            System.out.println();
            int s;
            while(true){
            try{
            System.out.print("Enter Ice-Cream Id : ");
            s = Integer.parseInt(sc.nextLine());
            break;
            }catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
        }
            String sql2 = "delete from Ice-Cream where Id = ?";
            PreparedStatement pst = c.prepareStatement(sql2);
            pst.setInt(1,s);
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println();
                System.out.println("DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

                
            }
            else{
                System.out.println();
                System.out.println("NOT DELETED");
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 

            }
           break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("invalid choice (enter between 1 to 6)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        }
    }
}

// method to add new food items
public static void addItems(Connection c) throws Exception{
    Thread.sleep(500);   
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    System.out.println();
    String sql = "Select * from menu";
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DBTablePrinter.printResultSet(rs, 15);
    while(rs.next()){
     System.out.println("No : " + rs.getInt(1));
     System.out.println("Item Name : " + rs.getString(2));
    }
    System.out.println();
    System.out.print("In Which Food You want to add items :");
    int choice  ;
    try{
        choice = Integer.parseInt(sc.nextLine());
        
    }catch(Exception e){
        System.out.println();
        choice = -1;
        System.out.println(e+"\n");
    }
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
    switch(choice){
        case 1:{
        Thread.sleep(500);
         System.out.println();
         String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Tea name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Tea Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into tea (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
             System.out.println();
             System.out.println("ADDED");
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
            System.out.println();
             System.out.println("NOT ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         break;
     }
     case 2:{
        Thread.sleep(500);
         System.out.println();
          String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Burger name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Burger Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into Burger (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
             System.out.println();
             System.out.println("ADDED");
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
            System.out.println();
            System.out.println("NOT ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
        break;
     }
     case 3:{
        Thread.sleep(500);
         System.out.println();
         String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Sandwich name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Sandwich Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into Sandwich (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
            System.out.println();
             System.out.println("ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
             System.out.println();
             System.out.println("NOT ADDED");
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
 }
        break;
     }
     case 4 :{
        Thread.sleep(500);
         System.out.println();
         String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Pizza name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Pizza Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into Pizza (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
            System.out.println();
             System.out.println("ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
            System.out.println();
            System.out.println("NOT ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
        break;
     }
     case 5 :{
        Thread.sleep(500);
        System.out.println();
          String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Shake name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Shake Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into Shakes (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
            System.out.println();
            System.out.println("ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
            System.out.println();
             System.out.println("NOT ADDED");
             System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         break;
     }
     case 6:{  
        Thread.sleep(500);
         System.out.println();
          String s;
         double p;
         while(true){
         try{
         System.out.print("Enter Ice-Cream name : ");
         s = sc.nextLine().toUpperCase().trim();
         System.out.println();
         System.out.print("Enter Ice-Cream Prices :");
           p = Double.parseDouble(sc.nextLine());
            break;
         }catch(Exception e){
            s = null;
            p = 0.0;
            System.out.println("\n"+e+"\n");
         }
        }
         String sql1 = "insert into ice_cream (name,Prices,rating) values(?,?,?)";
         PreparedStatement pst = c.prepareStatement(sql1);
         pst.setString(1,s);
         pst.setDouble(2, p);
         pst.setDouble(3,0);
         int r = pst.executeUpdate();
         if(r>0){
            System.out.println();
             System.out.println("ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
         else{
             System.out.println();
             System.out.println("NOT ADDED");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         }
        break;
     }
     default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("invalid choice (enter between 1 to 6)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
     }
 }
}
  
  static int password = 1234;
  // method to verify admin 
  public static void admin_password() throws Exception{
      System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
      System.out.println();
      System.out.print("Enter your password (4-digit) : ");
      while(true){
      String pass = sc.nextLine() ;
      if(pass.length() == 4){
         if(pass.equals("1234")){
            break;
         }else{
            Thread.sleep(500);
            System.out.println();
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
            System.out.println();
            System.out.println("Entered Password Is Wrong!");
            System.out.println();
            System.out.print("Re-Enter Your Password : "); 
         }
      }
      else{
         Thread.sleep(500);
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println();
        System.out.println("Please Enter 4-Digit Password "); 
        System.out.println();
        System.out.print("Re-Enter Your Password : "); 
      }
    }
  }

  // method for customer as user
  public static void customer(Connection c,Connection c1) throws Exception{
    Thread.sleep(500);
    System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
    System.out.println("|                                                                    |");
    System.out.println("|              ==== WELCOME TO CUSTOMER INTERFACE ===                |");
    System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
    customer_interface(c,c1);
    while(true){
    System.out.println();
    System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
    System.out.println("|                                                                    |");
    System.out.println("|                       CUSTOMER HOME PAGE                           |");
    System.out.println("|                                                                    |");
    System.out.println("|            Press 1. To see all Food items menu.                    |");
    System.out.println("|            Press 2. To add items into cart.                        |");
    System.out.println("|            Press 3. To show the cart                               |");
    System.out.println("|            Press 4. To update any food in cart.                    |");
    System.out.println("|            Press 5. To delete any food in cart.                    |");
    System.out.println("|            Press 6. To Place order.                                |");
    System.out.println("|            Press 7. Return                                         |");
    System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
    System.out.println();
    System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");    
    System.out.println();
    int s ;
    while(true){
    try{
         System.out.print("Enter your choice : ");
        s = Integer.parseInt(sc.nextLine());
        break;
     }catch(Exception e){
        System.out.println("\n"+e+"\n");
     }
  }  
    switch(s){
        case 1:{
             getItemsDetais(c,c1);
             break;
        }
        case 2:{
            add_to_cart(c,c1);
            break;
        }
        case 4:{
            update_Cart(c1);
           break;
        }
        case 5:{
            delete_cart(c1);
            break;
        }
        case 3:{
            show(c1);
            break;
        }
        case 6:{
            placeorder(c,c1);
            break;
        }
        case 7:{
             String sql12 = "delete from my_cart";
                 Statement sat = c1.createStatement();
                 sat.executeUpdate(sql12);
                 User(c, c1);
                 break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("invalid choice (enter between 1 to 7)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        }
      }
   }
}
    

   
    // method to add to cart for customer
    public static void add_to_cart(Connection c,Connection c1) throws Exception{
        boolean f1 = true;
        while(f1){
            Thread.sleep(500);
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        System.out.println();
        String sql = "Select * from menu";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DBTablePrinter.printResultSet(rs, 15);
        while(rs.next()){
        System.out.println("No : " + rs.getInt(1));
        System.out.println("Item Name : " + rs.getString(2));
        }
        System.out.println();
        int cho;
        while(true){
        try{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.print("Which Food items you want to Add : ");
            cho = Integer.parseInt(sc.nextLine());
            System.out.println();
            break;
        }catch(Exception e){
            cho = -1;
            System.out.println("\n"+e+"\n");
        }
    }
        switch(cho){
            case 1:{
                boolean f = true;
                while(f){
                Thread.sleep(500);    
                String sql1 = "Select * from Tea";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 15);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Tea Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from tea where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from tea ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
                break;
            }
            case 2:{
                boolean f = true;
                while(f){
                    Thread.sleep(500);
                String sql1 = "Select * from burger";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 15);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Burger Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from burger where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from burger ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                  while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
                break;
            }
            case 3:{
                boolean f = true;
                while(f){
                    Thread.sleep(500);
                String sql1 = "Select * from sandwich";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 15);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Sandwich Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from sandwich where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                 String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from sandwich ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                  while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
              break;
            }
            case 4:{
                boolean f = true;
                while(f){
                    Thread.sleep(500);
                String sql1 = "Select * from pizza";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 15);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Pizza Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from pizza where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from pizza ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                  while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
                break;
            }
            case 5:{
                boolean f = true;
                while(f){
                    Thread.sleep(500);
                String sql1 = "Select * from shakes";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 20);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Shake Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from shakes where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                  String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from shakes ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                 while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
                break;
            }
            case 6:{
                boolean f = true;
                while(f){
                    Thread.sleep(500);
                String sql1 = "Select * from ice_cream";
                Statement st1 = c.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                DBTablePrinter.printResultSet(rs1, 15);
                while(rs1.next()){
                     System.out.println("No : " + rs1.getInt(1));
                     System.out.println("Item Name : " + rs1.getString(2));
                }
                System.out.println();
                int s1 ;
                int q ;
                while(true){
                    try{
                         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                         System.out.println();
                         System.out.print("Enter Ice-Cream Id : ");
                         s1 = Integer.parseInt(sc.nextLine());
                         System.out.println();
                         System.out.print("Enter the Quantity : ");
                         q = Integer.parseInt(sc.nextLine());
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                String sql2 = "Select name , Prices from ice_cream where Id = ?";
                PreparedStatement pst = c.prepareStatement(sql2);
                pst.setInt(1, s1);
                ResultSet r = pst.executeQuery();
                while(r.next()){
                  String n = r.getString("name");
                  double p = r.getDouble("Prices");
                  double t = p * q;
                String sql3 = "insert into my_cart (item_name,quantity,Prices,total_prices)values(?,?,?,?)";
                PreparedStatement pst1 = c1.prepareStatement(sql3);
                pst1.setString(1, n);
                pst1.setInt(2, q);
                pst1.setDouble(3, p);
                pst1.setDouble(4, t);
                int get = pst1.executeUpdate();
                if(get>0){
                    Thread.sleep(500);
                    System.out.println();
                    System.out.println("ADDED TO CART");
                }
                }
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("Do you want to add another item from ice-cream ");
                System.out.println("Press 1. Yes");
                System.out.println("Press 2. No");
                System.out.println();
                int ch ;
                  while(true){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
                }
                break;
            }
            default :{
                System.out.println("invalid choice");
            }
        }
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("Do you want to add another item from menu ");
            System.out.println("Press 1. Yes");
            System.out.println("Press 2. No");
            System.out.println();
            int ch ;
            while(true){
                System.out.print("Enter your choice : ");
                try{
                    ch = Integer.parseInt(sc.nextLine());
                    break;
                }catch(Exception e){
                    System.out.println("\n"+e+"\n");
                }
            }
            boolean f2 = true;
                while(f2){
                switch(ch){
                    case 1:{
                        f1 = true;
                        f2 = false;
                        break;
                    }
                    case 2:{
                        f1 = false;
                        f2 = false;
                        break;
                    }
                    default :{
                        System.out.println("Invalid choice");
                        f2 = true;
                    }
                }
            }
        }
    }

    // method for customer to update cart
    public static void update_Cart(Connection c1) throws Exception{
        int count = countRecords(c1);
        if(count>0){
        ArrayList<ShowCart> show = new ArrayList<>();
        String sql = "select * from my_cart";
        Statement st = c1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String n = rs.getString(1);
            int q = rs.getInt(2);
            double p = rs.getDouble(3);
            double t = rs.getDouble(4);
            ShowCart s = new ShowCart(n, q, p, t);
            show.add(s);
        }
        Thread.sleep(800);
        System.out.println();  
        System.out.println();               
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println("|                                                                      |");
        System.out.println("|                              YOUR CART                               |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _ __ __ __ __ __ __ __|");  
        System.out.println("|                        |             |          |                    |");
        System.out.println("|       Food Name        |   Qunatity  |   Price  |   Total Price      |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ __|"); 
        System.out.println("|                        |             |          |                    |");
        for(ShowCart s11 : show){
          System.out.printf("|  %-20s  |   %5s     |%8s  |  %10s        |\n", s11.getName(),s11.getQuantity(),s11.getPrices(),s11.getTotal_prices());
        }
        System.out.println("|                        |             |          |                    |");
        System.out.println("|                        |             |          |                    |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ __|");    
        boolean f1 = true;
        while(f1){
        String s1;
        int q;
        while(true){
                    try{
                        while(true){
                         int flag = 0;
                         System.out.println();
                         System.out.print("Enter Food Name : ");
                         s1 = sc.nextLine().toUpperCase().trim();
                         String sql10 = "select item_name from my_cart where item_name = ?";
                         PreparedStatement pst11 = c1.prepareStatement(sql10);
                         pst11.setString(1,s1);
                         ResultSet rs1 = pst11.executeQuery();
                         while(rs1.next()){
                            String name = rs1.getString("item_name");
                            if(s1.equalsIgnoreCase(name)){
                               flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                         }
                         if(flag == 1){
                           System.out.println();
                           System.out.print("Enter the Quantity : ");
                           q = Integer.parseInt(sc.nextLine());
                           break;
                         }
                         else{
                            System.out.println();
                            
                         }System.out.println("Entered food name is wrong check your cart.");
                         }
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
            }
            if(q>0){
            String sql1 = "Select Prices from my_cart where item_name = '"+s1+"'";
            Statement st1 = c1.createStatement();
            ResultSet rs1 = st.executeQuery(sql1);
            while(rs1.next()){
            double p = rs1.getDouble(1);
            double t = q*p;
            String sql5 = "update my_cart set quantity = ? , total_prices = ? where item_name = ?";
            PreparedStatement pst = c1.prepareStatement(sql5);
            pst.setInt(1, q);
            pst.setDouble(2,t);
            pst.setString(3, s1);
             int r = pst.executeUpdate();
              if(r>0){
                Thread.sleep(800);
                System.out.println();
                System.out.println("CART IS UPDATE");
            }
            else{
                System.out.println();
                System.out.println("CART IS NOT UPDATE");
            }
        }
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        System.out.println();
        System.out.println("Do you want to update any other item in cart ");
        System.out.println("Press 1. Yes");
        System.out.println("Press 2. No");
        System.out.println();
        int ch ;
        boolean f = true;
          while(f){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        f = true;
                        f2 = false;
                        f1 = true;
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        f1 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
        }
        else if(q == 0){
             String sql1 = "Delete from my_cart where item_name = ?";
             PreparedStatement pst = c1.prepareStatement(sql1);
             pst.setString(1,s1);
             pst.executeUpdate();
             System.out.println();
             Thread.sleep(500);

             System.out.println("Food item is removed 5from cart(Because quantity is 0)");
             f1 = false;
        }
        else if(q < 0){
            Thread.sleep(500);
            System.out.println();
            System.out.println("Sorry you can't enter quantity in negative value.");
            f1 = true;
        }
    }
}else{
        System.out.println();
        System.out.println("YOUR CART IS EMPTY");
    }
    }

    // method for customer to delete from cart
    public static void delete_cart(Connection c1) throws Exception{
        int count = countRecords(c1);
        if(count>0){
        ArrayList<ShowCart> show = new ArrayList<>();
        String sql = "select * from my_cart";
        Statement st = c1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String n = rs.getString(1);
            int q = rs.getInt(2);
            double p = rs.getDouble(3);
            double t = rs.getDouble(4);
            ShowCart s = new ShowCart(n, q, p, t);
            show.add(s);
        }
        Thread.sleep(800);
        System.out.println();               
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println("|                                                                      |");
        System.out.println("|                              YOUR CART                               |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _ __ __ __ __ __ __ __|"); 
        System.out.println("|                        |             |          |                    |");
        System.out.println("|       Food Name        |   Qunatity  |   Price  |   Total Price      |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ __|"); 
        System.out.println("|                        |             |          |                    |");
        for(ShowCart s11 : show){
          System.out.printf("|  %-20s  |   %5s     |%8s  |  %10s        |\n", s11.getName(),s11.getQuantity(),s11.getPrices(),s11.getTotal_prices());
        }
        System.out.println("|                        |             |          |                    |");
        System.out.println("|                        |             |          |                    |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ __|");
        boolean f1=true;
        while(f1){
        String s1;
        while(true){
                    try{
                        while(true){
                         int flag = 0;
                         System.out.println();
                         System.out.print("Enter Food Name : ");
                         s1 = sc.nextLine().toUpperCase().trim();
                         String sql10 = "select item_name from my_cart where item_name = ?";
                         PreparedStatement pst11 = c1.prepareStatement(sql10);
                         pst11.setString(1,s1);
                         ResultSet rs1 = pst11.executeQuery();
                         while(rs1.next()){
                            String name = rs1.getString("item_name");
                            if(s1.equalsIgnoreCase(name)){
                               flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                         }
                         if(flag == 1){
                           break;
                         }
                         else{
                            System.out.println();
                            
                         }System.out.println("Entered food name is wrong check your cart.");
                         }
                         break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
            }
            String sql5 = "Delete from my_cart where item_name = ?";
            PreparedStatement pst = c1.prepareStatement(sql5);
            pst.setString(1, s1);
            int r = pst.executeUpdate();
            if(r>0){
                Thread.sleep(800);
                System.out.println();
                System.out.println("ITEM IS REMOVED FROM CART");
            }
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
        System.out.println();
        System.out.println("Do you want to delete any other item in cart ");
        System.out.println("Press 1. Yes");
        System.out.println("Press 2. No");
        System.out.println();
        int ch ;
        boolean f = true;
          while(f){
                    try{
                        boolean f2 = true;
                        System.out.print("Enter your choice : ");
                         while(f2){
                              ch = Integer.parseInt(sc.nextLine());
                    switch(ch){
                    case 1:{
                        int record = 0;
                        String sqlQuery = "Select * from my_cart";
                        Statement statement = c1.createStatement();
                        ResultSet set = statement.executeQuery(sqlQuery);
                        while(set.next()){
                            record++;
                        }
                        if(record>0){
                        f = true;
                        f2 = false;
                        f1 = true;
                        }else{
                            System.out.println();
                            System.out.println("YOUR CART IS EMPTY");
                             f = false;
                             f2 = false;
                             f1 = false;
                        }
                        break;
                    }
                    case 2:{
                        f = false;
                        f2 = false;
                        f1 = false;
                        break;
                    }
                    default :{
                        System.out.println();
                        System.out.println("Invalid choice");
                        f2 = true;
                      }
                   }
                }
                        break;
                    }catch(Exception e){
                        System.out.println("\n"+e+"\n");
                    }
                }
        }
    }else{
        System.out.println();
        System.out.println("YOUR CART IS EMPTY");
    }
    }

    public static int countRecords(Connection c) throws Exception{
        String sql = "select * from my_cart";
        Statement st = c.createStatement();
        ResultSet r = st.executeQuery(sql);
        int c1 = 0;
        while(r.next()){
               c1++;
        }
        return c1;
    }

    // method for login/sign of customer
    public static void customer_interface(Connection c,Connection c1) throws Exception{
        boolean f = true;
        while(f){
        System.out.println();
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                    |");
        System.out.println("|                        Press 1 ---> Login.                         |");
        System.out.println("|                        Press 2 ---> Sign Up.                       |");
        System.out.println("|                                                                    |");
        System.out.println("|                        Press 3 ---> Return.                        |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.println();
         int s ;
        while(true){
        try{
            System.out.print("Enter your choice : ");
            s = Integer.parseInt(sc.nextLine());
            break;
        }catch(Exception e){
            System.out.println("\n"+e+"\n");
        }
    }
    switch(s){
        case 1:{
            login(c,c1);
            f = false;
            break;
        }
        case 2:{
            signUp(c);
            f = false;
            break;
        }
        case 3:{
            User(c, c1);
            break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();   
            System.out.println("Invalid choice (enter 1 or 2 or 3)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            f = true;
        }
       }
      }
     }

     // method for customer login
    public static void login(Connection c,Connection c1) throws Exception{
        boolean flag = true;
        int f = 0;
        Thread.sleep(800);
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
        System.out.println(); 
        System.out.print("Enter your moblie number (starts Between 7 - 9) : ");
         while(flag){
            moblie = sc.nextLine();
            if(moblie.matches("[987]\\d{9}")){
                          flag = false;
                          break;
            }
            else{  
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
                System.out.println(); 
                System.out.println("Please Enter Valid Number (Don't Write Alphabets & Number should be  ");
                System.out.println("length of 10 digits)");
                System.out.println();
                System.out.print("Re-Enter Your Mobile Number (starts between 7-9 ): ");
            }
            }
            String sql = "Select moblie_number from customer_details where moblie_number = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1,moblie);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String no = rs.getString("Moblie_Number");
                if(moblie.equals(no)){
                     f = 1;
                }
                else{
                    f = 0;
                }
            }
            if(f == 1){
                System.out.println();
                System.out.println("LOGIN SUCCESSFULL.");
                return;
            }
            else{
                Thread.sleep(800);
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("This Moblie Number is not found in Database.(You Need to signUp)");
                customer_interface(c,c1);
            }
    }

    static String moblie;
    // method for customer to sign up
    public static void signUp(Connection c) throws Exception{
           
            boolean flag = true;
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.print("Enter your first name : ");
            String f_name = sc.nextLine().toUpperCase();
            System.out.println();
            System.out.print("Enter your last name : ");
            String l_name = sc.nextLine().toUpperCase();
            System.out.println();
            System.out.print("Enter your current address : ");
            String address = sc.nextLine().toUpperCase();
            System.out.println();
            System.out.print("Enter your moblie number (starts Between 7 - 9) : ");
            while(flag){
            moblie = sc.nextLine();
            int record = 0;
            if(moblie.matches("[987]\\d{9}")){
                 String sql11 = "Select moblie_number from customer_details";
                 Statement st = c.createStatement();
                 ResultSet set = st.executeQuery(sql11);
                 while(set.next()){
                    String m = set.getString("moblie_number");
                    if(moblie.equalsIgnoreCase(m)){
                        System.out.println();
                        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
                        System.out.println();
                        System.out.println("Please Entered different Number for sign up(Number is already Present)");
                        System.out.println();
                        System.out.print("Re-Enter Your Mobile Number (starts between 7-9 ): ");
                       record = 1;
                    }
                    }
                    if(record == 0){
                        flag = false;
                    }
            }
            else{  
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _");
                System.out.println(); 
                System.out.println("Please Enter Valid Number (Don't Write Alphabets & Number should be  ");
                System.out.println("length of 10 digits)");
                System.out.println();
                System.out.print("Re-Enter Your Mobile Number (starts between 7-9 ): ");
            }
            }
            verified(f_name, l_name, moblie, address, c);
}

      public static void verified(String f_name,String l_name,String moblie,String address,Connection c) throws Exception{
   
         boolean f = true;
         System.out.println();
         System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
         System.out.println();
         System.out.println("Sending OTP To Your Device....");
        while(f){
          
          Thread.sleep(2000);
          System.out.println();
          int r = (int)(Math.random()*10000);
          System.out.println("OTP Received On Your Phone : "+r);
          System.out.println();
          System.out.print("Enter Your OTP : ");
          int r1 = sc.nextInt();
          sc.nextLine();
              if(r1==r){
                String sql = "insert into customer_details (first_name,Last_name,Moblie_Number,address) values(?,?,?,?)";
                PreparedStatement pst = c.prepareStatement(sql);
                pst.setString(1, f_name);
                pst.setString(2, l_name);
                pst.setString(3, moblie);
                pst.setString(4, address);
                pst.executeUpdate();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                   f = false;
              }
              else{
                  System.out.println();
                  System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                  System.out.println();      
                  System.out.println("Entered OTP Is Wrong!");
                  System.out.println();
                  System.out.println("Re-sending the OTP...");
              }
        }
   }

   // method for  customer to show its cart
   public static void show(Connection c1) throws Exception{
    int count = countRecords(c1);
    if(count > 0){
        ArrayList<ShowCart> show = new ArrayList<>();
        String sql = "select * from my_cart";
        Statement st = c1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String n = rs.getString(1);
            int q = rs.getInt(2);
            double p = rs.getDouble(3);
            double t = rs.getDouble(4);
            ShowCart s = new ShowCart(n, q, p, t);
            show.add(s);
        }
        double sum = 0.0;
        for(ShowCart a : show){
            sum = sum + a.getTotal_prices();
        }
        Thread.sleep(800);
        System.out.println();                 
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                       |");
        System.out.println("|                              YOUR CART                                |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _ __ __ __ __ __ __ ___|"); 
        System.out.println("|                        |             |          |                     |");
        System.out.println("|       Food Name        |   Qunatity  |   Price  |   Total Price       |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ ___|"); 
        System.out.println("|                        |             |          |                     |");
        for(ShowCart s1 : show){
          System.out.printf("|  %-20s  |   %5s     |%8s  |  %10s         |\n", s1.getName(),s1.getQuantity(),s1.getPrices(),s1.getTotal_prices());
        }
        System.out.println("|                        |             |          |                     |");
        System.out.println("|                        |             |          |                     |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ ___|"); 
        System.out.println("|                                                 |                     |");
        System.out.println("|                Total Amount To Pay              |      "+(int)sum+" Rs         |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _|__ __ __ __ __ __ ___|"); 
   }else{
        System.out.println();
        System.out.println("YOUR CART IS EMPTY");
   }
}

  static double sum = 0.0;
  // method for customer to place Order
   public static void placeorder(Connection c,Connection c1) throws Exception{
    int count = countRecords(c1);
    if(count>0){
        ArrayList<ShowCart> show = new ArrayList<>();
        String sql = "select * from my_cart";
        Statement st = c1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String n = rs.getString(1);
            int q = rs.getInt(2);
            double p = rs.getDouble(3);
            double t = rs.getDouble(4);
            ShowCart s = new ShowCart(n, q, p, t);
            show.add(s);
        }
        for(ShowCart a : show){
            sum = sum + a.getTotal_prices();
        }
        Thread.sleep(800);
        System.out.println();                 
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                       |");
        System.out.println("|                              YOUR BILL                                |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _ __ __ __ __ __ __ ___|"); 
        System.out.println("|                        |             |          |                     |");
        System.out.println("|       Food Name        |   Qunatity  |   Price  |   Total Price       |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ ___|"); 
        System.out.println("|                        |             |          |                     |");
        for(ShowCart s1 : show){
          System.out.printf("|  %-20s  |   %5s     |%8s  |  %10s         |\n", s1.getName(),s1.getQuantity(),s1.getPrices(),s1.getTotal_prices());
        }
        System.out.println("|                        |             |          |                     |");
        System.out.println("|                        |             |          |                     |");
        System.out.println("|__ __ __ __ __ __ __ __ |__ __ __ __ _| __ __ __ |__ __ __ __ __ __ ___|"); 
        System.out.println("|                                                 |                     |");
        System.out.println("|                Total Amount To Pay              |      "+(int)sum+" Rs         |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _|__ __ __ __ __ __ ___|"); 
        System.out.println();
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        boolean f = true;
        boolean t = true;
        while(t){
        System.out.println();
        System.out.print("Do you want to order....?(Yes/No) : ");
        String op = sc.nextLine().toUpperCase();
        if(op.equalsIgnoreCase("Yes")){
    
       while(f){
        Thread.sleep(500);
        System.out.println();
        System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println("|                                                                    |");
        System.out.println("|                           PAYMENT MODE                             |");
        System.out.println("|                                                                    |");
        System.out.println("|                   Press 1 ---> Cash On Delivery.                   |");
        System.out.println("|                   Press 2 ---> Credit/Debit card                   |");
        System.out.println("|                   Press 3 ---> UPI                                 |");
        System.out.println("|__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __|");
        System.out.println();
        int s ;
        while(true){
        try{
            System.out.print("Enter your choice : ");
            s = Integer.parseInt(sc.nextLine());
            break;
        }catch(Exception e){
            System.out.println("\n"+e+"\n");
        }
    }
    switch(s){
        case 1:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println(" TOTAL Bill : "+(int)sum);
            System.out.println();
            Thread.sleep(2500);
            boolean f16 = true;
                while(f16){
          
          Thread.sleep(2000);
          System.out.println();
          int r = (int)(Math.random()*10000);
          System.out.println("OTP Received On Your Phone : "+r);
          System.out.println();
          System.out.print("Enter Your OTP : ");
          int r1 = sc.nextInt();
          sc.nextLine();
              if(r1==r){
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("---> Pay bill to the delivery man on hand.");
                System.out.println();
                System.out.println("---> Your Order is Confirmed. Thankyou");
                 String sql12 = "delete from my_cart";
                 Statement sat = c1.createStatement();
                 sat.executeUpdate(sql12);
                 sum = 0.0;
                   f16 = false;
              }
              else{
                  System.out.println();
                  System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                  System.out.println();      
                  System.out.println("Entered OTP Is Wrong!");
                  System.out.println();
                  System.out.println("Re-sending the OTP...");
              }
        }
            f = false;
            t = false;
            User(c, c1);
            break;
        }
        case 2:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.print("Enter Your Bank Name : ");
            String b_name = sc.nextLine();
            Long no;
            while(true){
                try{
                    System.out.println();
               System.out.print("Enter 16 digit credit card number : ");
                no = Long.parseLong(sc.nextLine());
                String cr = no.toString();
                if(cr.length() == 16){
                    System.out.println();
                   break;
                }
                else{
                    System.out.println();
                    System.out.println("Invalid card length.");
                }
                }catch(Exception e){
                    System.out.println("\n"+e+"\n");
                }
            }
            Long y;
            while(true) {
                try{
            System.out.print("Enter Expire year in YYYY : ");
            y = Long.parseLong(sc.nextLine());
            String cr1 = y.toString();
            if(cr1.length() == 4){
                System.out.println();
                break;
            }else{
                System.out.println();
                System.out.println("Invalid Year Entered.");
                System.out.println();
            }}catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
            }
           
          Long y1;
            while(true) {
                try{
            System.out.print("Enter Expire month in MM : ");
            y1 = Long.parseLong(sc.nextLine());
            String cr2 = y1.toString();
            if(cr2.length() > 2 || y1 > 12){
                System.out.println();
                System.out.println("Invalid Month Entered.");
                System.out.println();
            }
            else{
                 System.out.println();
                break;
            }}catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
            }
            Long y2;
            while(true) {
                try{
            System.out.print("Enter CVV : ");
            y2 = Long.parseLong(sc.nextLine());
            String cr3 = y2.toString();
            if(cr3.length() == 3){
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid CVV Entered.");
                System.out.println();
            }}catch(Exception e){
                System.out.println("\n"+e+"\n");
            }
            }
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);        // Current year
            int month = cal.get(Calendar.MONTH);      // Current month
            if(y > year){
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();
            System.out.println("TOTAL Bill : "+sum);
            System.out.println();
            Thread.sleep(2500);
            boolean f16 = true;
                while(f16){
          
          Thread.sleep(2000);
          System.out.println();
          int r = (int)(Math.random()*10000);
          System.out.println("OTP Received On Your Phone : "+r);
          System.out.println();
          System.out.print("Enter Your OTP : ");
          int r1 = sc.nextInt();
          sc.nextLine();
              if(r1==r){
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("---> Your Order is Confirmed. Thankyou");
                 String sql12 = "delete from my_cart";
                 Statement sat = c1.createStatement();
                 sat.executeUpdate(sql12);
                 sum = 0.0;
                   f16 = false;
              }
              else{
                  System.out.println();
                  System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                  System.out.println();      
                  System.out.println("Entered OTP Is Wrong!");
                  System.out.println();
                  System.out.println("Re-sending the OTP...");
              }
        }
                 f = false;
                 t = false;
                Thread.sleep(500);
                 User(c,c1);
            }
            else if(y == year){
                if(y1 > month){
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                    System.out.println("TOTAL Bill : "+(int)sum);
                  
            Thread.sleep(2500);
            boolean f16 = true;
                while(f16){
          
          Thread.sleep(2000);
          System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
          System.out.println();
          int r = (int)(Math.random()*10000);
          System.out.println("OTP Received On Your Phone : "+r);
          System.out.println();
          System.out.print("Enter Your OTP : ");
          int r1 = sc.nextInt();
          sc.nextLine();
              if(r1==r){
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("---> Your Order is Confirmed. Thankyou");
                 String sql12 = "delete from my_cart";
                 Statement sat = c1.createStatement();
                 sat.executeUpdate(sql12);
                  sum = 0.0;
                   f16 = false;
              }
              else{
                  System.out.println();
                  System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                  System.out.println();      
                  System.out.println("Entered OTP Is Wrong!");
                  System.out.println();
                  System.out.println("Re-sending the OTP...");
                }
              }
                   f = false;
                   t = false;
                   Thread.sleep(500);
                    User(c,c1);
                }
                else if(y1 < month){
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();      
              System.out.println("Credit/Debit card has been expired choose another option.");
             f = true;
                }
            }
            else{
                System.out.println();
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();      
              System.out.println("Credit/Debit card has been expired choose another option.");
             f = true;
            }
         break;
        }
        case 3:{
            String upiId;
                    while (true) {
                        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                        System.out.println();
                        System.out.print("Enter Your UPI id : ");
                        upiId = sc.nextLine();
                        if (upiId.contains("@")) {
                            String[] a = upiId.split("@");
                            if ((a[1].equals("paytm") || a[1].equals("icici") || a[1].equals("hdfc")
                                    || a[1].equals("hsbc") || a[1].equals("sbi")) && (a[0].length() == 10)) {
                                System.out.println();
                                System.out.println("UPI ID Successfull");
              System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
              System.out.println();
            System.out.println("TOTAL Bill : "+(int)sum);
           
            Thread.sleep(2500);
            boolean f16 = true;
                while(f16){
          
          Thread.sleep(2000);
          System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
          System.out.println();
          int r = (int)(Math.random()*10000);
          System.out.println("OTP Received On Your Phone : "+r);
          System.out.println();
          System.out.print("Enter Your OTP : ");
          int r1 = sc.nextInt();
          sc.nextLine();
              if(r1==r){
                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                System.out.println();
                System.out.println("---> Your Order is Confirmed. Thankyou");
                 String sql12 = "delete from my_cart";
                 Statement sat = c1.createStatement();
                 sat.executeUpdate(sql12);
                  sum = 0.0;
                   f16 = false;
              }
              else{
                  System.out.println();
                  System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                  System.out.println();      
                  System.out.println("Entered OTP Is Wrong!");
                  System.out.println();
                  System.out.println("Re-sending the OTP...");
              }
        }
                                f = false;
                                t = false;
                                User(c, c1);
                                break;
                            } else {
                                System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                                System.out.println();
                                System.out.println("Invalid UPI ID Entered !!");
                            }
                        } else {
                            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
                            System.out.println();
                            System.out.println("Enter UPI ID with @");
                        }
                    }
            break;
        }
        default:{
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            System.out.println();   
            System.out.println("Invalid choice (enter 1 or 2 or 3)");
            System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ _"); 
            f = true;
         }
       }
      }
    }
      else if(op.equalsIgnoreCase("No")){
        String sql12 = "delete from my_cart";
        Statement sat = c1.createStatement();
        sat.executeUpdate(sql12);
        t = false;
        User(c,c1);
      }
    }
   }   else{
        System.out.println();
        System.out.println("YOUR CART IS EMPTY");
        boolean t = true;
        while(t){
        System.out.println();
        System.out.print("Do you want to add something....?(Yes/No) : ");
        String op = sc.nextLine().toUpperCase();
        if(op.equalsIgnoreCase("Yes")){
              break;
        }
        else if(op.equalsIgnoreCase("No")){ 
        User(c, c1);
        }
      }
       }
   
     }
    }

class ShowCart{
    String name ;
    int quantity;
    double prices;
    double total_prices;

    public ShowCart(String name, int quantity, double prices, double total_prices) {
        this.name = name;
        this.quantity = quantity;
        this.prices = prices;
        this.total_prices = total_prices;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrices() {
        return prices;
    }

    public double getTotal_prices() {
        return total_prices;
    }
}