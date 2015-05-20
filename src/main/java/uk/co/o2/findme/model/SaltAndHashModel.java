package uk.co.o2.findme.model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import uk.co.o2.findme.dao.SaltAndHashDAO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by ee on 19/05/15.
 */
public class SaltAndHashModel {

    private final static int ITERATION_NUMBER = 1000;

    public SaltAndHashDAO createUserHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // Uses a secure Random not a simple Random
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Salt generation 64 bits long
        byte[] bSalt = new byte[8];
        random.nextBytes(bSalt);
        // Digest computation
        byte[] bDigest = getHash(ITERATION_NUMBER,password,bSalt);
        SaltAndHashDAO saltAndHashObject = new SaltAndHashDAO(byteToBase64(bSalt), byteToBase64(bDigest));
        return saltAndHashObject;
    }

    public boolean generateHashAndValidate(SaltAndHashDAO saltAndHashDAO, String password) throws IOException, NoSuchAlgorithmException {
        byte[] bDigest = base64ToByte(saltAndHashDAO.getPasswordHash());
        byte[] bSalt = base64ToByte(saltAndHashDAO.getSalt());

        byte[] proposedDigest = getHash(ITERATION_NUMBER, password, bSalt);

        return Arrays.equals(proposedDigest, bDigest);
    }

    /**
     * From a password, a number of iterations and a salt,
     * returns the corresponding digest
     * @param iterationNb int The number of iterations of the algorithm
     * @param password String The password to encrypt
     * @param salt byte[] The salt
     * @return byte[] The digested password
     * @throws java.security.NoSuchAlgorithmException If the algorithm doesn't exist
     */
    public byte[] getHash(int iterationNb, String password, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(salt);
        byte[] input = digest.digest(password.getBytes("UTF-8"));
        for (int i = 0; i < iterationNb; i++) {
            digest.reset();
            input = digest.digest(input);
        }
        return input;
    }

    /**
     * From a base 64 representation, returns the corresponding byte[]
     * @param data String The base64 representation
     * @return byte[]
     * @throws java.io.IOException
     */
    public static byte[] base64ToByte(String data) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(data);
    }

    /**
     * From a byte[] returns a base 64 representation
     * @param data byte[]
     * @return String
     * @throws IOException
     */
    public static String byteToBase64(byte[] data){
        BASE64Encoder endecoder = new BASE64Encoder();
        return endecoder.encode(data);
    }


}
