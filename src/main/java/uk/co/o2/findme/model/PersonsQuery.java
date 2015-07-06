package uk.co.o2.findme.model;

import uk.co.o2.findme.dao.*;

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by ee on 11/05/15.
 */
public class PersonsQuery {

    // JDBC driver name and database URL TODO: needs to be secured and exported
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = DatabaseConfiguration.db_url;

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
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            /*String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentProject, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE CONCAT(p.firstName, ' ', p.lastName) LIKE ?";*/

            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentTeam, p.currentProject, p.location, p.currentTeam, p.status FROM persons p " +
                    "WHERE CONCAT(p.firstName, ' ', p.lastName) LIKE ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nameSearch + "%");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                PersonDAO person =
                        new PersonDAO(
                                rs.getString("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.details"),
                                rs.getString("p.currentProject"),
                                rs.getString("p.location"),
                                rs.getString("p.currentTeam"),
                                rs.getString("p.status"));
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

    public List<PersonDAO> getAllPersons() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<PersonDAO> personList = new ArrayList<PersonDAO>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            /*String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentProject, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE CONCAT(p.firstName, ' ', p.lastName) LIKE ?";*/

            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentTeam, p.currentProject, p.location, p.currentTeam, p.status " +
                    "FROM persons p";

            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                PersonDAO person =
                        new PersonDAO(
                                rs.getString("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.details"),
                                rs.getString("p.currentProject"),
                                rs.getString("p.location"),
                                rs.getString("p.currentTeam"),
                                rs.getString("p.status"));
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

    public List<GameDataObject> getAllPersonsForGameLeaderBoard() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<GameDataObject> personList = new ArrayList<GameDataObject>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT gd.idPerson, p.firstName, p.lastName, p.jobTitle, gd.gameScore FROM gameData gd " +
                    "LEFT JOIN persons p ON gd.idPerson = p.idPerson " +
                    "ORDER BY gd.gameScore DESC";

            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                GameDataObject person =
                        new GameDataObject(
                                rs.getString("gd.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.jobTitle"),
                                rs.getInt("gd.gameScore"));
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

    public void addPersonToStickerBookFor(String currentUser, String targetUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<StickerBookDataObject> personList = new ArrayList<StickerBookDataObject>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "INSERT INTO personStickerBookConnection VALUES(?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, currentUser);
            pstmt.setString(2, targetUser);

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

    public int checkIfConnectionIsAlreadyPresent(String currentUser, String targetUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int numberOfRowsReturned = 0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT * FROM personStickerBookConnection WHERE idPerson=? AND idConnectedPerson=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, currentUser);
            pstmt.setString(2, targetUser);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                numberOfRowsReturned++;
            }

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
        return numberOfRowsReturned;
    }

    public List<StickerBookDataObject> getAllPersonsForSBLeaderBoard() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<StickerBookDataObject> personList = new ArrayList<StickerBookDataObject>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT gd.idPerson, p.firstName, p.lastName, p.jobTitle, gd.stickerbookScore FROM gameData gd " +
                    "LEFT JOIN persons p ON gd.idPerson = p.idPerson " +
                    "ORDER BY gd.stickerbookScore DESC";

            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                StickerBookDataObject person =
                        new StickerBookDataObject(
                                rs.getString("gd.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.jobTitle"),
                                rs.getInt("gd.stickerbookScore"));
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

    public PersonDAO searchByPersonIdOf(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PersonDAO person = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
/*            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentProject, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE p.idPerson = ?";*/

            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentTeam, p.currentProject, p.location, p.currentTeam, p.status FROM persons p " +
            "WHERE p.idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                person = new PersonDAO(
                                rs.getString("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"),
                                rs.getString("p.emailAddress"),
                                rs.getString("p.areaCode"),
                                rs.getString("p.phoneNumber"),
                                rs.getString("p.jobTitle"),
                                rs.getString("p.details"),
                                rs.getString("p.currentProject"),
                                rs.getString("p.location"),
                                rs.getString("p.currentTeam"),
                                rs.getString("p.status"));
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

    public String getPersonStringOfTheDay() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String details = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
/*            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo, p.emailAddress, p.areaCode, p.phoneNumber, p.jobTitle, p.details, p.currentProject, p.location, t.teamName, pt.status FROM persons p " +
            "LEFT JOIN personTeams pt ON p.idPerson = pt.Persons_idPerson " +
            "JOIN teams t ON pt.Teams_idTeams = t.idTeams " +
            "WHERE p.idPerson = ?";*/

            String sql = "SELECT p.details FROM persons p " +
            "WHERE p.isDailyPerson = true";

            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                details = rs.getString("p.details");
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
        return details;
    }

    public boolean isValidPersonId(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT idPerson FROM persons WHERE idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                result = true;
            }

            //STEP 5: Clean-up environment
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
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
                return false;
            }//end finally try
        }//end try
        return result;
    }

    public String getNumberOfStickersFor(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String numberOfStickers = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT COUNT(idPerson) FROM personStickerBookConnection WHERE idPerson = ?";
            //String sql2 = "SELECT lastGameEntry FROM leaderboards WHERE idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                numberOfStickers = rs.getString("COUNT(idPerson)");
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
        return numberOfStickers;
    }

    public boolean getIfUserHasPlayedForToday(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean hasPlayed = false;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT idPerson FROM competitionData WHERE idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                hasPlayed = true;
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
        return hasPlayed;
    }

    public String submitEntry(String personID, String entry) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "INSERT INTO competitionData VALUES (?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);
            pstmt.setString(2, entry);

            pstmt.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt.close();
            conn.close();
            return "success";
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return "fail";
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return "fail";
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
                return "fail";
            }//end finally try

        }//end try
    }

    public boolean updateGameData(String personID, String currentDate) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "UPDATE gameData " +
                    "SET  lastGameEntry=? " +
                    "WHERE idPerson=?";


            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, currentDate);
            pstmt.setString(2, personID);


            pstmt.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
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
                return false;
            }//end finally try
        }//end try
    }


    public boolean updateStickerBookData(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "UPDATE gameData " +
                    "SET stickerbookScore=stickerbookScore+1 " +
                    "WHERE idPerson=?";


            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);


            pstmt.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
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
                return false;
            }//end finally try
        }//end try
    }


    public boolean updateUser(String firstName, String lastName, String email, String phoneNumber, String picture, String jobTitle, String teamName, String project, String location, String details, String status, String personId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "UPDATE persons " +
                    "SET firstName=?, lastName=?, emailAddress=?, photo=?, phoneNumber=?, jobTitle=?, currentTeam=?, currentProject=?, location=?, details=?, status=? " +
                    "WHERE idPerson=?";


            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, picture);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, jobTitle);
            pstmt.setString(7, teamName);
            pstmt.setString(8, project);
            pstmt.setString(9, location);
            pstmt.setString(10, details);
            pstmt.setString(11, "Active");
            pstmt.setString(12, personId);

            pstmt.executeUpdate();

            //STEP 5: Clean-up environment
            pstmt.close();
            conn.close();
            return true;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
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
                return false;
            }//end finally try
        }//end try
    }

    public List<StickerBookPersonDAO> getAllSBPersonsFor(String personID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<StickerBookPersonDAO> personList = new ArrayList<StickerBookPersonDAO>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT p.idPerson, p.firstName, p.lastName, p.photo FROM persons p " +
            "LEFT JOIN personStickerBookConnection psbc ON p.idPerson = psbc.idConnectedPerson " +
            "WHERE psbc.idPerson = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                StickerBookPersonDAO person =
                        new StickerBookPersonDAO(
                                rs.getString("p.idPerson"),
                                rs.getString("p.firstName"),
                                rs.getString("p.lastName"),
                                rs.getString("p.photo"));
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


    public int emailMatchCheck(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int numberOfRowsReturned = 0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, DatabaseConfiguration.db_username2, DatabaseConfiguration.db_pass2);

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

    public String getPersonIdBy(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String personId = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, DatabaseConfiguration.db_username2, DatabaseConfiguration.db_pass2);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT idPerson FROM persons " +
            "WHERE emailAddress = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                personId = rs.getString("idPerson");
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
        return personId;
    }

    public String getCountOfPersonsTable() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String number = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, DatabaseConfiguration.db_username2, DatabaseConfiguration.db_pass2);

            //STEP 4: Execute a query and add results to list
            String sql = "SELECT COUNT(idPerson) FROM persons;";

            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                number = rs.getString("COUNT(idPerson)");
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
        return number;
    }

    public SaltAndHashDAO getPasswordAndSaltFor(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        SaltAndHashDAO saltAndHash = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, DatabaseConfiguration.db_username2, DatabaseConfiguration.db_pass2);

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
