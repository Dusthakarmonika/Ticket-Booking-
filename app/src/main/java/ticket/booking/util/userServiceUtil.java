package ticket.booking.util;

import org.mindrot.jbcrypt.BCrypt;

public class userServiceUtil {

    public static String hashPassword(String planePassword)
    {
        return BCrypt.hashpw(planePassword,BCrypt.gensalt());
    }
    public static boolean checkPassword(String planePassword, String hashedPassword){
        return BCrypt.checkpw(planePassword, hashedPassword);
    }
}
