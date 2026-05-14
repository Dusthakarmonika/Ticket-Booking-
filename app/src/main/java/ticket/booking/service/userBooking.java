package ticket.booking.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entites.Train;
import ticket.booking.entites.user;
import ticket.booking.util.userServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class userBooking {

    private user user;

    private List<user> UserList;

    private ObjectMapper ObjectMapper = new ObjectMapper();

    private static final String USERS_PATH = "app/src/main/java/ticket/booking/localDB/users.json";

    public userBooking(user user1)throws IOException {
        this.user = user1;
       loadUser();
    }
    public userBooking() throws IOException {
        loadUser();
    }
    public List<user> loadUser() throws IOException{
        File users = new File(USERS_PATH);
        UserList = ObjectMapper.readValue(user.toString(),new TypeReference<List<user>>() {});
    }
    public boolean loginUser(){
        Optional<user> foundUser = UserList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && userServiceUtil.checkPassword(user.getPassword(),user1.getHashPassword();
        }).findFirst();
            return foundUser.isPresent();
    }
    public boolean signUp(user user1) throws IOException {
        try{
            UserList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch(IOException ex){
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException{
        File userFile = new File(USERS_PATH);
        ObjectMapper.writeValue(userFile, UserList);
    }

    public void fetchBooking(){
        Optional<user> userFetched = UserList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && userServiceUtil.checkPassword(user.getPassword(),user1.getHashPassword());
        }).findFirst();
        if(userFetched.isPresent()){
            userFetched.get().printTickets();
        }
    }
    public boolean cancelBooking(String ticketID){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticket id to cancel");
        ticketID = scanner.next();
        if(ticketID == null || ticketID.isEmpty()){
            return Boolean.FALSE;
        }
        public List<Train> getTrain(String source, String destination){

        }
    }


}
