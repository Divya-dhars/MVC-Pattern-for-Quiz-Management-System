import java.sql.*;
class Adminmodel {
    private Connection conn=null;
    public Adminmodel(){
        if(conn==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizmanagementsystem", "root", "GuruDev20**");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public void insert(int qno,String question,String answer) throws Exception{
        try{
            Statement s=conn.createStatement();
            String query="INSERT INTO questions(qno, question, answer)VALUES('"+qno+"','"+question+"','"+answer+"')";
            int inserted=s.executeUpdate(query);
            if(inserted==1){
                System.out.println("Sucessfully inserted");
            }
            else{
                System.out.println("Failed to insert");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void delete(int qno)throws Exception{
        try{
            Statement s=conn.createStatement();
            String query="DELETE FROM questions WHERE id="+qno;
            int deleted=s.executeUpdate(query);
            if(deleted==1){
                System.out.println("deleted");
            }
            else{
                System.out.println("Not deleted");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateId(int no,int newqno)throws Exception{
        try{
            Statement s=conn.createStatement();
            String query="UPDATE questions SET id="+newqno+" WHERE id="+no;
            int updated = s.executeUpdate(query);
            if(updated==1){
                System.out.println("Updated jobId");
            }
            else{
                System.out.println("Failed to update jobId");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateQuestion(String question,String newQuestion)throws Exception{
        try{
            Statement s=conn.createStatement();
            String query="UPDATE questions SET id="+newQuestion+" WHERE id="+question;
            int updated = s.executeUpdate(query);
            if(updated==1){
                System.out.println("Updated jobId");
            }
            else{
                System.out.println("Failed to update jobId");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateAnswer(String answer,String newAnswer)throws Exception{
        try{
            Statement s=conn.createStatement();
            String query="UPDATE questions SET id="+newAnswer+" WHERE id="+answer;
            int updated = s.executeUpdate(query);
            if(updated==1){
                System.out.println("Updated jobId");
            }
            else{
                System.out.println("Failed to update jobId");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}