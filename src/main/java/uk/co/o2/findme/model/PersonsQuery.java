package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.PersonDAO;
import uk.co.o2.findme.dao.PersonLoginDAO;
import uk.co.o2.findme.dao.SaltAndHashDAO;
import uk.co.o2.findme.dao.StickerBookPersonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ee on 11/05/15.
 */
public class PersonsQuery {

    // JDBC driver name and database URL TODO: needs to be secured and exported
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/findme";

    // Database credentials

    static final String USER = DatabaseConfiguration.db_username;
    static final String PASS = DatabaseConfiguration.db_pass;

    public List<PersonDAO> searchByPersonNameOf(String nameSearch) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<PersonDAO> personList = new ArrayList<PersonDAO>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.skypeName, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE CONCAT(p.firstName, ' ', p.lastName) LIKE ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nameSearch + "%");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                PersonDAO person =
                        new PersonDAO(
                                rs.getInt("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.skypeName"),
                                rs.getString("p.location"),
                                rs.getString("t.teamName"),
                                rs.getString("pt.status"));
                personList.add(person);
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
        return personList;
    }



    public PersonDAO searchByPersonIdOf(int personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PersonDAO person = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.skypeName, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE p.idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                person = new PersonDAO(
                                rs.getInt("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.skypeName"),
                                rs.getString("p.location"),
                                rs.getString("t.teamName"),
                                rs.getString("pt.status"));
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
        return person;
    }



    public PersonDAO getAllDetailsFor(int personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PersonDAO person = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.skypeName, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE p.idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                person = new PersonDAO(
                                rs.getInt("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.skypeName"),
                                rs.getString("p.location"),
                                rs.getString("t.teamName"),
                                rs.getString("pt.status"));
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
        return person;
    }



    public StickerBookPersonDAO getAllSBPersonsFor(int personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        StickerBookPersonDAO person = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.avatar, p.photo FROM persons p " +
            "LEFT JOIN personStickerBookConnection psbc ON p.idPerson = psbc.idConnectedPerson " +
            "WHERE psbc.idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

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
        return person;
    }



    public int emailMatchCheck(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int numberOfRowsReturned = 0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT idPerson, emailAddress FROM persons " +
            "WHERE emailAddress = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                numberOfRowsReturned++;
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
        return numberOfRowsReturned;
    }



    public SaltAndHashDAO getPasswordAndSaltFor(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        SaltAndHashDAO saltAndHash = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT personSalt, personHashPassword FROM persons " +
            "WHERE emailAddress = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                saltAndHash = new SaltAndHashDAO(
                        rs.getString("personSalt"),
                        rs.getString("personHashPassword")
                );
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
        return saltAndHash;
    }
}
