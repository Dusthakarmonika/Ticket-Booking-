package ticket.booking.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entites.user;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class userBooking {

    private user user;

    private List<user> UserList;

    private ObjectMapper ObjectMapper = new ObjectMapper();

    private static final String USERS_PATH = "../localDB/users.json";

    public userBooking(user user1)throws IOException {
        this.user = user1;
        File users = new File(USERS_PATH);
        UserList = ObjectMapper.readValue(user.toString(),new TypeReference<List<user>>() {});
    }
}
