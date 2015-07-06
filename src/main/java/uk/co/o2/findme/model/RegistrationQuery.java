package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.PreRegPerson;

import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;


/**
 * Created by ee on 11/05/15.
 */
public class RegistrationQuery {

    // JDBC driver name and database URL TODO: needs to be secured and exported
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = DatabaseConfiguration.db_url;

    // Database credentials

    static final String USER = DatabaseConfiguration.db_username;
    static final String PASS = DatabaseConfiguration.db_pass;
    private int personID;
    private int teamID;

    public void registerUser(PreRegPerson preRegPerson) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "INSERT INTO persons (idPerson, firstName, lastName, emailAddress, photo, phoneNumber, personSalt, personHashPassword, jobTitle, currentProject, currentTeam, location, details, status) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, preRegPerson.getPersonId());
            pstmt.setString(2, preRegPerson.getFirstName());
            pstmt.setString(3, preRegPerson.getLastName());
            pstmt.setString(4, preRegPerson.getEmail());
            pstmt.setString(5, preRegPerson.getPhoto());
            pstmt.setString(6, preRegPerson.getPhoneNumber());
            pstmt.setString(7, preRegPerson.getSalt());
            pstmt.setString(8, preRegPerson.getPassword());
            pstmt.setString(9, preRegPerson.getJobTitle());
            pstmt.setString(10, preRegPerson.getCurrentProject());
            pstmt.setString(11, preRegPerson.getTeamName());
            pstmt.setString(12, preRegPerson.getLocation());
            pstmt.setString(13, preRegPerson.getDetails());
            pstmt.setString(14, preRegPerson.getStatus());

            pstmt.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(pstmt != null)
                    pstmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public void setupGameData(String personID) {

        Connection conn = null;
        PreparedStatement pstmt3 = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list

            String sql3 = "INSERT INTO gameData (idPerson, lastGameEntry) " +
                    "VALUES(?, ?)";

            pstmt3 = conn.prepareStatement(sql3);
            pstmt3.setString(1, personID);
            pstmt3.setDate(2, getCurrentDateMinusDay());

            pstmt3.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt3.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(pstmt3 != null)
                    pstmt3.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public int getPersonID(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int id = 0;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT idPerson FROM persons " +
                    "WHERE emailAddress = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("idPerson");
            }

            //STEP 5: Clean-up environment
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(pstmt != null)
                    pstmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return id;
    }

    public void getTeamID(String teamName) {
        Connection conn = null;
        PreparedStatement pstmt2 = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql2 = "SELECT idTeams FROM teams " +
                    "WHERE teamName = ?";

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, teamName);

            ResultSet rs2 = pstmt2.executeQuery();

            while(rs2.next())
            {
                teamID = rs2.getInt("idTeams");
            }

            //STEP 5: Clean-up environment
            rs2.close();
            pstmt2.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (pstmt2 != null)
                    pstmt2.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end
    }

    private static java.sql.Date getCurrentDateMinusDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date dateMinusOne = cal.getTime();
        java.sql.Date sqlDate = new java.sql.Date(dateMinusOne.getTime());
        return sqlDate;
    }
}