package com.telra.belarus.gym.utils;

/**
 * Created by Boris on 11.06.2017.
 */

public interface IUtils {

    String getToken(final String username,final String id);
    boolean isLoginInfoExist(Object obj);
    String hashPassword(String rawPassword);

    String parsJwts(String token);
    Boolean isPasswordCorrect(String newPassword, String hashedPassrod);

}
