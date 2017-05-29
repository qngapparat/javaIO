import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

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
    public void groupByStrengthTest(){

        List<Player> myList7 = PlayerManager.readPlayers();
        Map<Integer, Integer> myMap7 = PlayerManager.groupByStrength7(myList7);

        List<Player> myList8 = PlayerManager.readPlayers();
        Map<Integer, Integer> myMap8 = PlayerManager.groupByStrength8(myList8);

        Assert.assertTrue(myMap7.equals(myMap8));

    }


}
