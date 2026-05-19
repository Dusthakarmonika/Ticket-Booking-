package ticket.booking.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entites.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TrainService {
    private Train train;
    private List<Train> trainList;
    private ObjectMapper objectMapper= new ObjectMapper();
    private static final String TRAIN_PATH = "app/src/main/java/ticket/booking/localDB/trains.json";

    public TrainService(Train train1)throws IOException {
        this.train = train1;
        File file = new File(TRAIN_PATH);
        objectMapper.readValue(train.toString(),new TypeReference<List<Train>>(){});
    }

}
