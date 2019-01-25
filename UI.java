import java.util.Scanner;
/**
 * Handles all interactions with the user.
 *
 * @author Connor Bowers
 * @version 1 / 23 / 19
 */
public class UI
{
    private static Hotel hotel;
    private static Scanner input;
    /**
     * Run this to start the progam, instantiates variables and calls setUp
     *
     * @param  args for convention
     * @return    
     */
    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        setUp();
    }
    
    /**
     * serves as the basis for the UI. Loops indefinitely
     *
     * @param  
     * @return    
     */
    public static void UILoop()
    {
        input.nextLine();
        loop: while(true)
        {
            System.out.println("\nWhat would you like to do? (type the option you want)\n");
            System.out.println("Create guest account");
            System.out.println("View guest account");
            System.out.println("Check in guest manually");
            System.out.println("Check in guest automatically");
            System.out.println("Check out guest");
            System.out.println("View room");
            System.out.println("Find rooms");
            System.out.println("Exit the program");
            String option = input.nextLine().toLowerCase();
            switch(option){
                case "create guest account": 
                    createGuestAccount(); 
                    break;
                case "view guest account" : 
                    viewGuest(); 
                    break;
                case "check in guest manually" : 
                    manualCheckIn(); 
                    break;
                case "check in guest automatically" : 
                    autoCheckIn(); 
                    break;
                case "check out guest" : 
                    checkOut(); 
                    break;
                case "view room" : 
                    viewRoom(); 
                    break;
                case "find rooms" : 
                    findRooms(); 
                    break;
                case "exit the program" : 
                    break loop;
                default : 
                    System.out.println("You made a mistake, try again."); 
                    break;
            }
            
        }
    }

    /**
     * sets up the hotel
     *
     * @param  
     * @return    
     */
    public static void setUp()
    {
        String name;
        int floors;
        int singles;
        int queen;
        int doubles;
        int doubleQueen;
        int suite;
        int milDiscount;
        int govDiscount;
        int memberDiscount;
        double floorPriceIncrease;
        
        System.out.println("What would you like the hotel to be called?");
        name = input.nextLine();
        
        System.out.println("How many floors is the hotel");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            floors = input.nextInt();
            if(floors <= 0){
                System.out.println("There must be more that 0 floors, enter again.");
            }
        } while(floors <= 0);
        
        System.out.println("How many single rooms should there be on each floor?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            singles = input.nextInt();
            if(singles < 0){
                System.out.println("There cannot be a negative number of rooms, enter again.");
            }
        } while(singles < 0);
        
        System.out.println("How many double rooms should there be on each floor?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            doubles = input.nextInt();
            if(doubles < 0){
                System.out.println("There cannot be a negative number of rooms, enter again.");
            }
        } while(doubles <0);
        
        System.out.println("How many queen singles rooms should there be on each floor?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            queen = input.nextInt();
            if(queen < 0){
                System.out.println("There cannot be a negative number of rooms, enter again.");
            }
        } while(queen < 0);
        
        System.out.println("How many queen double rooms should there be on each floor?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            doubleQueen = input.nextInt();
            if(doubleQueen < 0){
                System.out.println("There cannot be a negative number of rooms, enter again.");
            }
        } while(doubleQueen < 0);
        
        System.out.println("How many suites should there be on each floor?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            suite = input.nextInt();
            if(suite < 0){
                System.out.println("There cannot be a negative number of rooms, enter again.");
            }
        } while(suite < 0);
        
        System.out.println("What percent discount should military customers get?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            milDiscount = input.nextInt();
            if(milDiscount < 0){
                System.out.println("The discount cannot be negative");
            }
            if(milDiscount > 100){
                System.out.println("The discount cannot be greater than 100");
            }
        } while(milDiscount < 0 || milDiscount > 100);
        
        System.out.println("What percent discount should government customers get?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            govDiscount = input.nextInt();
            if(govDiscount < 0){
                System.out.println("The discount cannot be negative");
            }
            if(govDiscount > 100){
                System.out.println("The discount cannot be greater than 100");
            }
        } while(govDiscount < 0 || govDiscount > 100);
        
        System.out.println("What percent discount should members get?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            memberDiscount = input.nextInt();
            if(memberDiscount < 0){
                System.out.println("The discount cannot be negative");
            }
            if(memberDiscount > 100){
                System.out.println("The discount cannot be greater than 100");
            }
        } while(memberDiscount < 0 || memberDiscount > 100);
        
        System.out.println("How much should higher floors cost (per floor above the ground floor) ?");
        do{
            while(!input.hasNextDouble()){
                System.out.println("you must enter a number");
                input.next();
            }
            floorPriceIncrease = input.nextDouble();
            if(floorPriceIncrease < 0){
                System.out.println("Higher floors should be more expensive, not less.");
            }
        } while(floorPriceIncrease < 0);
        
        System.out.println("Your hotel has been created.");
        //hotel = new Hotel(floors, singles, doubles, queen, doubleQueen, suite, milDiscount, govDiscount, memberDiscount, floorPriceIncrease);
        UILoop();
    }
    
    /**
     * creates a guest account after asking a series of questions about it
     *
     * @param  
     * @return   
     */
    public static void createGuestAccount()
    {
        String name;
        int id;
        boolean isMember;
        boolean isMil;
        boolean isGov;
        int preferredFloor;
        //CHECK ENUM NAME
        RoomSize preferredRoomSize;
        
        System.out.println("What is the guest's name?");
        name = input.nextLine();
        
        //MAYBE ADD INT LENGTH CONSTRAINT OR VERIFY UNIQUENESS
        System.out.println("What is the guest's ID number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            if(id < 0){
                System.out.println("The ID cannot be negative.");
            }
        } while(id < 0);
        
        System.out.println("Is the guest a member?");
        while(!input.hasNextBoolean()){
                System.out.println("you must enter a boolean");
                input.next();
            }
        isMember = input.nextBoolean();
        
        System.out.println("Is the guest in the military?");
        while(!input.hasNextBoolean()){
                System.out.println("you must enter a boolean");
                input.next();
            }
        isMil = input.nextBoolean();
        
        System.out.println("Does the guest work for the government");
        while(!input.hasNextBoolean()){
                System.out.println("you must enter a boolean");
                input.next();
            }
        isGov = input.nextBoolean();
        
        System.out.println("What is the guest's preferred floor");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            preferredFloor = input.nextInt();
            if(preferredFloor < 0 || preferredFloor > hotel.getFloors() - 1){
                System.out.println("That is not a valid floor");
            }
        } while(preferredFloor < 0 || preferredFloor > hotel.getFloors() - 1);
        
        //CHECK ENUM CORRECTNESS
        do{
            System.out.println("\nWhat is the guest's preferred room size?\n");
            System.out.println("Single");
            System.out.println("Double");
            System.out.println("Queen Single");
            System.out.println("Queen Double");
            System.out.println("Suite");
            String option = input.nextLine().toLowerCase();
            switch(option){
                case "single": 
                    preferredRoomSize = RoomSize.SINGLE; 
                    break;
                case "double" : 
                    preferredRoomSize = RoomSize.DOUBLE; 
                    break;
                case "queen single" : 
                    preferredRoomSize = RoomSize.QSINGLE; 
                    break;
                case "queen double" : 
                    preferredRoomSize = RoomSize.QDOUBLE; 
                    break;
                case "suite" : 
                    preferredRoomSize = RoomSize.SUITE; 
                    break;
                default :
                    System.out.println("Please enter a valid room size.");
                    break;
            }
        } while(preferredRoomSize == null);
        
        //CONFIRM PARAMETERS WITH GAVIN
        hotel.createGuest(id, name, isMil, isGov, isMember, preferredRoomSize, preferredFloor);
        System.out.println("Guest account successfuly created.");
    }
    
    /**
     * prints guest information after asking for identifying information
     *
     * @param  
     * @return    
     */
    public static void viewGuest()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        Guest guest;
        
        System.out.println("What is the guest's ID number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is not guest with that ID");
            }
        } while(guest == null);
        
        System.out.println("The guest with that ID is:");
        System.out.println(guest);
    }
    
    /**
     * prints room information after asking for floor and room number
     *
     * @param  
     * @return    
     */
    public static void viewRoom()
    {
        int floor;
        int num;
        
        //asks for the floor
        System.out.println("What floor is the room on?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            floor = input.nextInt();
            if(floor < 0 || floor > hotel.getFloors() - 1){
                System.out.println("That floor does not exist. Enter again.");
            }
        } while(floor < 0 || floor > hotel.getFloors() - 1);
        
        //asks for the number
        System.out.println("What is the room's number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            num = input.nextInt();
            if(num < 0 || num > hotel.getRoomsPerFloor() - 1){
                System.out.println("That room does not exist. Enter again.");
            }
        } while(num < 0 || num > hotel.getRoomsPerFloor() - 1);
        
        System.out.println("The room at that location is:");
        System.out.println(hotel.getRoom(floor, num));
    }
    
    /**
     * prints room information for one or more rooms after asking for floor and or size 
     *
     * @param  
     * @return    
     */
    public static void findRooms()
    {
        RoomSize roomSize;
        int floor;
        boolean hasFloorPreference;
        boolean hasSizePreference;
        ArrayList<Room> rooms;
        
        System.out.println("Do you have a preference for the floor?");
        while(!input.hasNextBoolean()){
                System.out.println("you must enter a boolean");
                input.next();
            }
        hasFloorPreference = input.nextBoolean();
        
        if(hasFloorPreference){
            //asks for the floor
            System.out.println("Which floor?");
            do{
                while(!input.hasNextInt()){
                    System.out.println("you must enter an integer");
                    input.next();
                }
                floor = input.nextInt();
                if(floor < 0 || floor > hotel.getFloors() - 1){
                    System.out.println("That floor does not exist. Enter again.");
                }
            } while(floor < 0 || floor > hotel.getFloors() - 1);
        }
        
        System.out.println("Do you have a preference for the room size?");
        while(!input.hasNextBoolean()){
                System.out.println("you must enter a boolean");
                input.next();
            }
        hasSizePreference = input.nextBoolean();
        
        if(hasSizePreference){
            //asks for the room size
            do{
                System.out.println("\nWhat is the size of the room?\n");
                System.out.println("Single");
                System.out.println("Double");
                System.out.println("Queen Single");
                System.out.println("Queen Double");
                System.out.println("Suite");
                String option = input.nextLine().toLowerCase();
                switch(option){
                    case "single": 
                        roomSize = RoomSize.SINGLE; 
                        break;
                    case "double" : 
                        roomSize = RoomSize.DOUBLE; 
                        break;
                    case "queen single" : 
                        roomSize = RoomSize.QSINGLE; 
                        break;
                    case "queen double" : 
                        roomSize = RoomSize.QDOUBLE; 
                        break;
                    case "suite" : 
                        roomSize = RoomSize.SUITE; 
                        break;
                    default :
                        System.out.println("Please enter a valid room size.");
                        break;
                }
            } while(roomSize == null);
        }
        
        rooms = hotel.findRooms(floor, roomSize);
        if(rooms.isEmpty()){
            System.out.println("No rooms meet your specifications.");
        } else {
            System.out.println("These are the rooms that met your requirements:");
            for(Room room : rooms){
                System.out.println();
                System.out.print(room);
            }
        }
        
    }
    
    /**
     * Checks a guest into a room after asking for guest and room info
     *
     * @param  
     * @return    
     */
    public static void manualCheckIn()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        int num;
        int floor;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is not guest with that ID");
            }
        } while(guest == null);
        
        do{
            //asks for the floor
            System.out.println("What floor is the room on?");
            do{
                while(!input.hasNextInt()){
                    System.out.println("you must enter an integer");
                    input.next();
                }
                floor = input.nextInt();
                if(floor < 0 || floor > hotel.getFloors() - 1){
                    System.out.println("That floor does not exist. Enter again.");
                }
            } while(floor < 0 || floor > hotel.getFloors() - 1);
            
            //asks for the room number
            System.out.println("What is the room's number?");
            do{
                while(!input.hasNextInt()){
                    System.out.println("you must enter an integer");
                    input.next();
                }
                num = input.nextInt();
                if(num < 0 || num > hotel.getRoomsPerFloor() - 1){
                    System.out.println("That room does not exist. Enter again.");
                }
            } while(num < 0 || num > hotel.getRoomsPerFloor() - 1);
            room = hotel.getRoom(floor, num);
            if(room.isChecked()){
                System.out.println("That room is occupied. Try another one");
            }
        } while(room.isChecked());
        
        System.out.println("The guest has been checked in");
        room.checkIn(guest);
        System.out.println("that room costs " + hotel.getPrice(room, guest) + " Dollars.");
    }
    
    /**
     * Checks a guest into the best suited room
     *
     * @param  
     * @return    
     */
    public static void autoCheckIn()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is not guest with that ID");
            }
        } while(guest == null);
        
        room = hotel.findRoom(guest);
        if(room == null){
            System.out.println("There are no rooms available.");
        } else {
            room.checkIn(guest);
            System.out.println("The guest has been checked in to the following room:");
            System.out.println(room);
            System.out.println("that room costs " + hotel.getPrice(room, guest) + " Dollars.");
        }
    }
    
    /**
     * checks a guest out of their room after asking for guest info
     *
     * @param  
     * @return    
     */
    public static void checkOut()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        int num;
        int floor;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number?");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is not guest with that ID");
            }
        } while(guest == null);
        
        room = guest.getRoom();
        if(room == null){
            System.out.println("That guest is not currently staying in the hotel.");
        } else {
            System.out.println("The guest has been checked out");
            room.checkOut(guest);
        }
    }
    
}
