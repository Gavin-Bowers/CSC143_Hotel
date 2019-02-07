/**
 * A guest account for someone staying at the hotel
 * 
 * @author Sonam Yangtso and Kunga Knochesang
 * @version 1/19/19
 */
public class Guest 
{
    private String name;
    private int id;
    private boolean isMember;
    private boolean isMilitary;
    private boolean isGovernment;
    private RoomSize preferredSize;
    private int preferredFloor;
    private Room room;
   
    /**
     * Constructor for objects of class guest
     */
    public Guest(String name, int id, boolean military,boolean government, boolean member, RoomSize preferedRoom, int preferedfloor)
    {
        this.name = name;
        this.id = id;
        isMember= member;
        isMilitary = military;
        isGovernment = government;
        preferredSize = preferedRoom;
        this.preferredFloor = preferedfloor;
        room = null;
    }
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public boolean getIsMember(){
        return isMember;
    }
    
    public boolean getIsMilitary(){
        return isMilitary;
    }
    
    public boolean getIsGovernment(){
      return isGovernment;  
    }
    
    public RoomSize getPrefferredSize(){
        return preferredSize;
    }
    
    public int getPreferredFloor(){
        return preferredFloor;
    }
    
    public Room getRoom(){
        return room;
    }
    
    public void checkIn(Room r){ //Only called by room
        room = r;
    }
    
    public void checkOut(){ //Only called by room
        room = null;
    }
     
    public String toString (){
        String Guest_data = "\nGuest data:";
        Guest_data += "\n\n1) Guest's name: "+ getName();
        Guest_data += "\n2) Guest's id: "+ getId();
        Guest_data += "\n3) Guest's member status: ";
        if(getIsMember()){
            Guest_data += "yes";
        } else{ 
            Guest_data += "no";
        }
        Guest_data += "\n4) Guest's military status: ";
        if( getIsMilitary()){
            Guest_data += " yes";
        } else{ 
            Guest_data += "no";
        }
        Guest_data += "\n5) Guest's government official status: ";
        if( getIsGovernment()){
            Guest_data += " yes";
        } else{ 
            Guest_data += "no";
        }
        Guest_data += "\n6) Guest's preferred Room Size: "+ getPrefferredSize();
        Guest_data += "\n7) Guest's preferred Room floor: "+ getPreferredFloor();
        if (room != null) {
            Guest_data += "\n8) Guest's checked status: Checked in";
        } else {
            Guest_data += "\n8) Guest's checked status: Checked out";
        }
        return Guest_data;
    }
}
    
    
    



