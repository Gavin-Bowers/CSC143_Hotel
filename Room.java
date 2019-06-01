 


/**
 * A room that has a room size and can be checked out to a guest
 *
 * @author Sonam Yangtso
 * @version 1/19/19
 */
public class Room
{
    private Guest guest;
    private int floor;
    private int roomNum;
    private RoomSize size;
    private boolean isChecked;
    
    public Room(RoomSize size, int floor, int num){
        this.guest = null;
        this.isChecked = false;
        roomNum = num;
        this.size = size;
        this.floor = floor;
    }
    
    public boolean getIsChecked(){
        return isChecked;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public RoomSize getSize(){
        return size;
    }
    
    public void checkIn(Guest g){
        isChecked = true;
        guest = g;
        g.checkIn(this);
    }
    
    public void checkOut(){
        isChecked = false;
        guest.checkOut();
        guest = null;
    }
    
    public Guest viewGuest(){
        return this.guest;
    }
    
    public String toString() { 
        String res = "";
        res += "\nFloor: " + floor;
        res += "\nRoom Number: " + roomNum;
        res += "\nRoomsize: " + size;
        if (isChecked) {
            res += "\nChecked out by: guest " + guest.getId();
        } else {
            res += "\nNot checked out\n";
        }
        return res;
    }
}
