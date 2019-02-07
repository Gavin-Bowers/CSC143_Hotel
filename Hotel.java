
/**
 * A hotel that keeps record of its current and former guests, as well as rooms of various types
 *
 * @author Gavin Bowers
 * @author Kunga Ngochetsang
 * @version 1/16/19
 */

import java.util.ArrayList;

public class Hotel
{   
    private int militaryDiscount; //All discounts in percent off
    private int governmentDiscount;
    private int memberDiscount;
    private double floorPriceIncrease;
    private Room rooms[][]; //Array of all rooms with by [floor][roomNumber]
    private ArrayList<Guest> guests; //List of all guest accounts, including former guests

    /**
     * Constructor for objects of class Hotel
     */
    public Hotel(int floors, int singles, int doubles, int queenSingles, int queenDoubles, 
    int suites, int militaryDiscount, int governmentDiscount, int memberDiscount, double floorPriceIncrease)
    {
        this.floorPriceIncrease = floorPriceIncrease;
        guests = new ArrayList<Guest>();
        int roomsPerFloor = singles + doubles + queenSingles + queenDoubles + suites; //Each floor has the same number of each room size for simplicity's sake
        rooms = new Room[floors][roomsPerFloor];
        int j, k, l, m, n;
        for (int i = 0; i < floors; i++) //Sets up all of the rooms
        {
            for (j = 0; j < singles; j++)
            {
                rooms[i][j] = new Room(RoomSize.SINGLE, i, j);
            }
            for (k = j; k < doubles + j; k++)
            {
                rooms[i][k] = new Room(RoomSize.DOUBLE, i, k); 
            }
            for (l = k; l < queenSingles + k; l++)
            {
                rooms[i][l] = new Room(RoomSize.QSINGLE, i, l); 
            }
            for (m = l; m < queenDoubles + l; m++)
            {
                rooms[i][m] = new Room(RoomSize.QDOUBLE, i, m);
            }
            for (n = m; n < suites + m; n++)
            {
                rooms[i][n] = new Room(RoomSize.SUITE, i, n); 
            }
        }
    }

    /**
     * Uses floor number, room size, and discounts to calculate room price
     *
     * @param   guest   The guest
     * @param   room    The room the guest is staying in
     * @return  price   The price the guest pays in dollars per day
     */
    public double getPrice(Room room, Guest guest)
    {
        int price = room.getSize().getPrice(); //Gets baseline price
        if (guest.getIsMilitary()) {price -= price*(militaryDiscount/100);} //Applies dicounts
        if (guest.getIsGovernment()) {price -= price*(governmentDiscount/100);}
        if (guest.getIsMember()) {price -= price*(memberDiscount/100);}
        price += room.getFloor() * floorPriceIncrease;
        return price;
    }
    
    public int getFloors()
    {
        return rooms.length;
    }
    
    public int getRoomsPerFloor() //the same on every floor for simplicity
    {
        return rooms[0].length;
    }

    /**
     * Returns a specified room
     *
     * @param   floor   The floor the room is on
     * @param   roomNumber    The roomNumber of the room
     * @return  room    The specified room
     */
    public Room getRoom(int floor, int roomNumber)
    {
        return rooms[floor][roomNumber];
    }
    
    /**
     * Checks if any guest with the given id exists
     *
     * @return  isUsed    If the id is in use
     */
    public boolean isIdUsed(int id)
    {
        boolean isUsed = false;
        for (int i = 0; i < guests.size(); i++) 
        {
            if(guests.get(i).getId() == id)
            {
                isUsed = true;
            }
        }
        return isUsed;
    }
    
    /**
     * Returns a specified guest
     *
     * @param   guestId   The id number of the desired guest
     * @return  guest    The specified guest
     */
    public Guest getGuest(int guestId)
    {
        Guest guestMatch = null;
        for (int i = 0; i < guests.size(); i++) 
        {
            if(guests.get(i).getId() == guestId)
            {
                guestMatch = guests.get(i);
            }
        }

        if (guestMatch == null)
        {
            return null;
        } else {
            return guestMatch;
        }
    }
    
    public String viewAllGuests()
    {
        String res = "";
        for (Guest g : guests) 
        {
            res += g.toString();
        }
        return res;
    }
    
    /**
     * Returns the room closest to the guest's preferences
     *
     * @param   guest   the specified guest
     * @return  room    the best available room for that guest
     */
    public Room findRoom(Guest guest) //Does not work because of unknown null pointer exceptions
    {
        Room best_room_available = null;
        int differencefloor = rooms.length; // putting the difference equals to number of floors
        int differenceRoomSizePrice = rooms[0].length; // gives the 
        for(int floor = 0; floor < rooms.length; floor++){
            for(int room = 0;room < rooms[floor].length;room++){
                if(!rooms[floor][room].getIsChecked()) { // here it checks whether it is occupied or not
                    if(rooms[floor][room].getSize() == guest.getPrefferredSize()){ // checks whether they found the desired roomsize
                        if(differencefloor > Math.abs(guest.getPreferredFloor() - floor)){ //checks whether they found the desired floor
                            best_room_available = rooms[floor][room];
                            differencefloor = Math.abs(guest.getPreferredFloor() - floor);
                        }
                    }
                    else if(differenceRoomSizePrice>Math.abs(rooms[floor][room].getSize().getPrice()-guest.getPrefferredSize().getPrice())){ 
                        if(differencefloor > Math.abs(guest.getPreferredFloor() - floor)){ //checks
                            if(differencefloor > Math.abs(guest.getPreferredFloor() - floor)){ //checks whether they found the desired floor
                                best_room_available = rooms[floor][room];
                                differencefloor = Math.abs(guest.getPreferredFloor() - floor);
                                differenceRoomSizePrice=Math.abs(rooms[floor][room].getSize().getPrice()-guest.getPrefferredSize().getPrice());
                            }
                        }   
                    }
                }
            }
        }
        return best_room_available;
    }
    
    /**
     * Returns all rooms that meet the specifications
     *
     * @param   size    the desired size
     * @param   floor   the desired floor
     * @return  rooms    all rooms that meet those specifications
     */
    public ArrayList<Room> findRooms(int floor, RoomSize roomSize)
    {
        ArrayList<Room> results = new ArrayList<Room>();
        for (int i = 0; i < rooms[floor].length; i++)
        {
            Room temp = rooms[floor][i];
            RoomSize size = temp.getSize();
            if (size == roomSize)
            {
                results.add(temp);
            }
        }
        return results;
    }
    
    /**
     * Creates a guest and adds it to the registry
     */
    public void createGuest(String name, int id, boolean isMilitary, boolean isGovernment, 
    boolean isMember, RoomSize prefferedSize, int prefferedFloor)
    {
        guests.add(new Guest(name, id, isMilitary, isGovernment, isMember, prefferedSize, 
                prefferedFloor));
    }

    public String toString() {
        String data = "\nHotel data:";
        data += "\nFloors of hotel: " + rooms.length;
        return data;
    }

}
