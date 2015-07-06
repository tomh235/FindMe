package uk.co.o2.findme.model;

public class DatabaseConfiguration {

    // TODO: Secure mysql database passwords

    public static String db_url = System.getProperty("db_url", "jdbc:mysql://ec2-54-171-90-242.eu-west-1.compute.amazonaws.com:3306/findme");

    public static String db_username = System.getProperty("db_username", "findme");
    public static String db_pass = System.getProperty("db_pass", "531c1474-d88a-4a73-bd36-e7e3cea8050a");

    public static String db_username2 = System.getProperty("db_username2", "findmeLogin");
    public static String db_pass2 = System.getProperty("db_pass2", "305fe048-7a9c-41c6-b3db-35a3712edee7");

}
