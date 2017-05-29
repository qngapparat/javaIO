import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//TODO add more java8 in groupbystrength8()

/**
 * Created by qngapparat on 28.05.17.
 */
public class PlayerManager {


    public static List<Player> readPlayers(){

        List<Player> playerList = new ArrayList<>();
        String line;

        try(    //create a file reader wrapped in bufferedread to enable readLine():
                InputStream fileIn = new FileInputStream("players.txt");

                BufferedReader buf = new BufferedReader(new InputStreamReader(fileIn, "UTF-8"))) {

            //read lines until null
            while((line = buf.readLine()) != null){


                //split string by its tabs to a string array
                String[] splitLine = line.split("\\t");

                //initialize Player with firstname and lastname strings
                Player listEntryPlayer = new Player(splitLine[1], splitLine[2]);

                //set id and strength ints
                listEntryPlayer.setId(Integer.parseInt(splitLine[0]));
                listEntryPlayer.setStrength(Integer.parseInt(splitLine[3]));

                //add player to list
                playerList.add(listEntryPlayer);
            }

            return playerList;

        }

        catch(FileNotFoundException e){
            System.out.println("File not found. Terminating\n");
            e.printStackTrace();
            System.exit(1);
        }

        //from int parsing
        catch (NumberFormatException e){
            System.out.println("Problem parsing String. Terminating\n");
            e.printStackTrace();
            System.exit(1);

        }

        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }


    public static List<Player> increaseStrength7(List<Player> playerList){

        try {
            for(Player player: playerList){
                player.changeStrength(1);
            }

            return playerList;
        }

        catch(NoSuchElementException e){
            e.printStackTrace();
            System.exit(1);
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static List<Player> increaseStrength8(List<Player> playerList){
        playerList.forEach(player -> player.changeStrength(1));
        return playerList;
    }

    //Can't think of a reason why Long would be useful here, so I'm using 2x integer
    public static Map<Integer, Integer> groupByStrength7(List<Player> playerList){

        Map<Integer, Integer> myMap = new HashMap<>();

        //used as iterable store of the frequency of strength values
        //set up and fill with 0
        int frequencyArray[] = new int[20];
        Arrays.fill(frequencyArray, 0);


        try {

            //walk thru array, value in array[index] represents how often strenght value "index" is found among out players.
            for(Player player: playerList){
                frequencyArray[player.getStrength()] += 1;
            }

        }

        catch(NoSuchElementException e){
            e.printStackTrace();
            System.exit(1);
        }

        catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < frequencyArray.length; i++){
            //put positive pairs into map
            if(frequencyArray[i] >= 1){
                myMap.put(i, frequencyArray[i]);
            }
        }

        return myMap;

    }

    public static Map<Integer, Integer> groupByStrength8(List<Player> playerList){


        Map<Integer, Integer> myMap = new HashMap<>();

        int frequencyArray[] = new int[20];
        Arrays.fill(frequencyArray, 0);


        try {

             playerList.forEach(player -> frequencyArray[player.getStrength()] += 1);

        }

        catch(NoSuchElementException e){
            e.printStackTrace();
            System.exit(1);
        }

        catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < frequencyArray.length; i++){
            //put positive pairs into map
            if(frequencyArray[i] >= 1){
                myMap.put(i, frequencyArray[i]);
            }
        }


        return myMap;
    }
}
