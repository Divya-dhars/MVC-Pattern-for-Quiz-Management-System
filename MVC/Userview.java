import java.util.*;
import java.sql.*;
class Userview {
    private Connection conn=null;
    Scanner in=new Scanner(System.in);
    public Userview(){
        if(conn==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizmanagementsystem", "root", "GuruDev20**");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public int input(){
        int i=in.nextInt();
        in.nextLine();
        return i;
    }
    public int qno(){
        int no=in.nextInt();
        in.nextLine();
        return no;
    }
    public String answer(){
        String ans=in.nextLine();
        return ans;
    }
    public void display() throws Exception {
        try{
            Statement s=conn.createStatement();
            String query="SELECT * FROM answers";
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}