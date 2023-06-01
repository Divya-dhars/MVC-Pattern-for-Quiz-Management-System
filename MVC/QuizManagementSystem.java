import java.util.*;
import java.sql.*;
class Career{
    private static Career ref = null;
    private Connection conn = null;
    private Career(){}
    public static Career getReference(){
        if(ref==null){
            ref=new Career();
        }
        return ref;
    }
    public Connection getConnection() throws Exception{
        if(conn==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizmanagementsystem", "root", "GuruDev20**");
        }
        return conn;
    }
}
public class QuizManagementSystem{
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(System.in);
        try{
            Career c=Career.getReference();
            Connection conn=c.getConnection();
            System.out.println("Connected to the database.");
            System.out.println("1.Login  || 2.Register");
            int choice=in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter email:");
                    String user_email=in.next();
                    System.out.println("Enter password:");
                    String user_password=in.next();
                    Statement st=conn.createStatement();
                    ResultSet rs1=st.executeQuery("SELECT * FROM login WHERE email = '" + user_email + "'");
                    if(!rs1.next()){
                        System.out.println("User is not registered");
                    }
                    else{
                        rs1=st.executeQuery("SELECT * FROM login WHERE email = '" + user_email + "' AND password = '" + user_password + "'");
                        if(rs1.next()){
                            String defaultUser=rs1.getString("defaultuser");
                            if(defaultUser.equals("admin")) {
                                Admin admin=new Admin();
                                admin.print();
                            }
                            else if(defaultUser.equals("user")){
                                User user=new User();
                                user.print();
                            }
                            else{
                                System.out.println("Invalid default user");
                            }
                        }
                        else{
                            System.out.println("Invalid email or password!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String username = in.next();
                    System.out.println("Enter email:");
                    String email = in.next();
                    System.out.println("Enter password:");
                    String password = in.next();
                    st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM login WHERE username = '" + username + "'");
                    if(rs.next()){
                        System.out.println("User already registered.");
                    }
                    else{
                        int rowsInserted=st.executeUpdate("INSERT INTO login (username,email,password,defaultuser) VALUES ('" + username + "','" + email + "','" + password + "','user')");
                        if(rowsInserted>0){
                            System.out.println("User registered successfully.");
                        }
                        else{
                            System.out.println("User registration failed.");
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter valid option");
                    break;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}