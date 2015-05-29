package uk.co.o2.findme.model;

public class DatabaseConfiguration {

    // TODO: Secure mysql database passwords

    public static String db_username = System.getProperty("db_username", "findme");
    public static String db_pass = System.getProperty("db_pass", "");

    public static String db_username2 = System.getProperty("db_username2", "findmeLogin");
    public static String db_pass2 = System.getProperty("db_pass2", "");

}
