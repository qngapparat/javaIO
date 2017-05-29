/**
 * Created by qngapparat on 28.05.17.
 */
public class Player {

    private int id;
    private String firstName;
    private String lastName;
    private int strength;

    public Player(){

    }

    public Player (String firstName, String lastName){
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void changeStrength(int strength){
        this.strength = this.strength + strength;
    }

    public int getStrength(){
        return this.strength;
    }
}
