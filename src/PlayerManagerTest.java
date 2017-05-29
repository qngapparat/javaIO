import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

//TODO test groupByStrength 7 and 8. What should be used as control group to the output of the functions to test? Yet another functions reading the file?

/**
 * Created by qngapparat on 28.05.17.
 */
public class PlayerManagerTest {


    @Test
    public void increaseStrength7Test(){

        List<Player> myList = PlayerManager.readPlayers();
        myList = PlayerManager.increaseStrength7(myList);

        //check if strength is between 2 and 4 in all cases
        for(Player player: myList){
            Assert.assertTrue(player.getStrength() >= 2 && player.getStrength() <= 4);
        }
    }

    @Test
    public void increaseStrength8Test(){

        List<Player> myList = PlayerManager.readPlayers();
        myList = PlayerManager.increaseStrength8(myList);

        //check if strength is between 2 and 4 in all cases
        for(Player player: myList){
            Assert.assertTrue(player.getStrength() >= 2 && player.getStrength() <= 4);
        }
    }

    @Test
    public void groupByStrength7Test(){

        List<Player> myList = PlayerManager.readPlayers();
        Map<Integer, Integer> myMap = PlayerManager.groupByStrength7(myList);


    }

    @Test
    public void groupByStrength8Test(){

        List<Player> myList = PlayerManager.readPlayers();
        Map<Integer, Integer> myMap = PlayerManager.groupByStrength8(myList);

    }
}
