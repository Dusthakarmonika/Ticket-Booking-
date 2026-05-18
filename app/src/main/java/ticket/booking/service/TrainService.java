package ticket.booking.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entites.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.spi.ToolProvider.findFirst;

public class TrainService {
    private Train train;
    private List<Train> trainList;
    private ObjectMapper objectMapper= new ObjectMapper();
    private static final String TRAIN_PATH = "app/src/main/java/ticket/booking/localDB/trains.json";

    public TrainService()throws IOException {
        File file = new File(TRAIN_PATH);
        objectMapper.readValue(train.toString(),new TypeReference<List<Train>>(){});
    }
    public List<Train> searchTrain(String source,String destination){
        return trainList.stream().filter(train -> validTrain(train,source,destination)).collect(Collectors.toList());

    }
    public void addTrain(Train newTrain){
        Optional<Train> existingTrain = trainList.stream()
                .filter(train -> train.getTrainID().equalsIgnoreCase(newTrain.getTrainID()))
                .findFirst();
        if(existingTrain.isPresent()){
            updateTrain(newTrain);
        }
        else{
            trainList.add(newTrain);
            saveTrainListToFile();
        }

    }
    public void updateTrain(Train updatedTrain){
        OptionalInt index = IntStream.range(0, trainList.size())
                .filter(i -> trainList.get(i).getTrainID().equalsIgnoreCase(updatedTrain.getTrainID()))
                            .findFirst();
        if(index.isPresent()){
                            trainList.set(index.getAsInt(),updatedTrain);
                        }
                        else{
                            addTrain(updatedTrain);
                        }
    }

    private void saveTrainListToFile() {
        try {
            objectMapper.writeValue(new File(TRAIN_PATH), trainList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private boolean validTrain(Train train, String source, String destination){
        List<String> stationOrder = train.getStations();
        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());
        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;

    }



}
