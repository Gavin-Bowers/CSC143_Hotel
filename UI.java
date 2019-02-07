import java.util.Scanner;
import java.util.ArrayList;
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
    private static void UILoop()
    {
        //input.nextLine();
        loop: while(true)
        {
            System.out.println("\nPress enter to continue.");
            input.nextLine();
            
            System.out.println("\nWhat would you like to do? (type the option you want)\n");
            System.out.println("Create account");
            System.out.println("View account");
            System.out.println("View all accounts");
            System.out.println("Check in");
            System.out.println("Check in automatically");
            System.out.println("Check out");
            System.out.println("View room");
            System.out.println("Find rooms");
            System.out.println("Exit");
            String option = input.nextLine().toLowerCase();
            switch(option){
                case "create account": 
                    createGuestAccount(); 
                    break;
                case "view account" : 
                    viewGuest(); 
                    break;
                case "view all accounts" : 
                    viewAllGuests(); 
                    break;
                case "check in" : 
                    manualCheckIn(); 
                    break;
                case "check in automatically" : 
                    autoCheckIn(); 
                    break;
                case "check out" : 
                    checkOut(); 
                    break;
                case "view room" : 
                    viewRoom(); 
                    break;
                case "find rooms" : 
                    findRooms(); 
                    break;
                case "exit" : 
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
    private static void setUp()
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
        hotel = new Hotel(floors, singles, doubles, queen, doubleQueen, suite, milDiscount, govDiscount, memberDiscount, floorPriceIncrease);
        
        //test scanner fix:
        input.nextLine();
        
        UILoop();
    }
    
    /**
     * creates a guest account after asking a series of questions about it
     *
     * @param  
     * @return   
     */
    private static void createGuestAccount()
    {
        String name;
        int id;
        boolean isMember;
        boolean isMil;
        boolean isGov;
        int preferredFloor = 0;
        String option;
        //CHECK ENUM NAME
        RoomSize preferredRoomSize = RoomSize.NULL;
        
        System.out.println("What is the guest's name?");
        name = input.nextLine();
        
        System.out.println("What is the guest's ID number?");
        do{
            do{
                while(!input.hasNextInt()){
                    System.out.println("you must enter an integer");
                    input.next();
                }
                id = input.nextInt();
                if(id < 0){
                    System.out.println("The ID cannot be negative.");
                } else if (hotel.isIdUsed(id)){
                    System.out.println("That ID is already in use");
                }
            } while(id < 0);
        } while (hotel.isIdUsed(id));
        
        System.out.println("Is the guest a member? (yes or no)");
        input.nextLine();
        do{
            option = input.nextLine().toLowerCase();
            if(!option.equals("yes") && !option.equals("no")){
                System.out.println("You must answer with yes or no");
            }
        } while(!option.equals("yes") && !option.equals("no"));
        switch(option){
            case "yes":
                isMember = true;
                break;
            case "no":
                isMember = false;
                break;
            default:
                isMember = false;  //Will never happen, but is necessary to compile
                break;
        }
        
        System.out.println("Is the guest in the military? (yes or no)");
        do{
            option = input.nextLine().toLowerCase();
            if(!option.equals("yes") && !option.equals("no")){
                System.out.println("You must answer with yes or no");
            }
        } while(!option.equals("yes") && !option.equals("no"));
        switch(option){
            case "yes":
                isMil = true;
                break;
            case "no":
                isMil = false;
                break;
            default:
                isMil = false;  //Will never happen, but is necessary to compile
                break;
        }
        
        System.out.println("Does the guest work for the government (yes or no)");
        do{
            option = input.nextLine().toLowerCase();
            if(!option.equals("yes") && !option.equals("no")){
                System.out.println("You must answer with yes or no");
            }
        } while(!option.equals("yes") && !option.equals("no"));
        switch(option){
            case "yes":
                isGov = true;
                break;
            case "no":
                isGov = false;
                break;
            default:
                isGov = false;  //Will never happen, but is necessary to compile
                break;
        }
        
        System.out.println("What is the guest's preferred floor (Floors start at 0 like in Europe)");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            preferredFloor = input.nextInt();
            int floors = hotel.getFloors();
            if(preferredFloor < 0 || preferredFloor > floors - 1){
                System.out.println("That is not a valid floor");
            }
        } while(preferredFloor < 0 || preferredFloor > hotel.getFloors() - 1);
        
        input.nextLine();
        do{
            System.out.println("\nWhat is the guest's preferred room size?\n");
            System.out.println("Single");
            System.out.println("Double");
            System.out.println("Queen Single");
            System.out.println("Queen Double");
            System.out.println("Suite");
            option = input.nextLine().toLowerCase();
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
        } while(preferredRoomSize == RoomSize.NULL);
        
        hotel.createGuest(name, id, isMil, isGov, isMember, preferredRoomSize, preferredFloor);
        System.out.println("Guest account successfuly created.");
    }
    
    /**
     * prints guest information after asking for identifying information
     *
     * @param  
     * @return    
     */
    private static void viewGuest()
    {
        int id;
        Guest guest;
        
        System.out.println("What is the guest's ID number? (enter -1 to cancel)");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            if(id == -1){
                input.nextLine();
                return;
            }
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is no guest with that ID");
            }
        } while(guest == null);
        
        //test scanner stuff
        input.nextLine();
        
        System.out.println("The guest with that ID is:");
        System.out.println(guest);
    }
    
    /**
     * prints out information for each guest account
     *  
     */
    private static void viewAllGuests() 
    {
        String res = hotel.viewAllGuests();
        System.out.println(res);
    }
    
    /**
     * prints room information after asking for floor and room number
     *
     * @param  
     * @return    
     */
    private static void viewRoom()
    {
        int floor;
        int num;
        
        //asks for the floor
        System.out.println("Which floor is the room on? (Floors start at 0 like in Europe)");
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
        System.out.println("What is the room's number? (they start at 0)");
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
        
         
        input.nextLine();
        
        System.out.println("The room at that location is:");
        System.out.println(hotel.getRoom(floor, num));
    }
    
    /**
     * prints room information for one or more rooms after asking for floor and or size 
     *
     * @param  
     * @return    
     */
    private static void findRooms()
    {
        RoomSize roomSize = RoomSize.NULL;
        int floor = 0;
        ArrayList<Room> rooms = new ArrayList<Room>();
        
        //asks for the floor
        System.out.println("Which floor? (Floors start at 0 like in Europe)");
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
        
        //asks for the room size
        input.nextLine();
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
        } while(roomSize == RoomSize.NULL);
    
        rooms = hotel.findRooms(floor, roomSize);
        if(rooms.isEmpty()){
            System.out.println("No rooms meet your specifications.");
        } else {
            System.out.println("These are the rooms that met your requirements:");
            for(Room room : rooms){
                System.out.println();
                System.out.println(room);
            }
        }
    }
    
    /**
     * Checks a guest into a room after asking for guest and room info
     *
     * @param  
     * @return    
     */
    private static void manualCheckIn()
    {
        int id;
        int num;
        int floor;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number? (enter -1 to cancel)");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            if(id == -1){
                input.nextLine();
                return;
            }
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There's no guest with that ID");
            } else if(guest.getRoom() != null){
                System.out.println("That guest is already in a room");
            }
        } while(guest == null || guest.getRoom() != null);
        
        do{
            //asks for the floor
            System.out.println("What floor is the room on? (Floors start at 0 like in Europe)");
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
            System.out.println("What is the room's number? (they start at 0) (enter -1 to cancel)");
            do{
                while(!input.hasNextInt()){
                    System.out.println("you must enter an integer");
                    input.next();
                }
                num = input.nextInt();
                if(num == -1){
                    input.nextLine();
                    return;
                }
                if(num < 0 || num > hotel.getRoomsPerFloor() - 1){
                    System.out.println("That room does not exist. Enter again.");
                }
            } while(num < 0 || num > hotel.getRoomsPerFloor() - 1);
            room = hotel.getRoom(floor, num);
            if(room.getIsChecked()){
                System.out.println("That room is occupied. Try another one");
            }
        } while(room.getIsChecked());
        
        input.nextLine();
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
    private static void autoCheckIn()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number? (enter -1 to cancel)");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            if(id == -1){
                input.nextLine();
                return;
            }
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is no guest with that ID");
            } else if(guest.getRoom() != null){
                System.out.println("That guest is already in a room");
            }
        } while(guest == null || guest.getRoom() != null);
        
        room = hotel.findRoom(guest);
        if(room == null){
            System.out.println("There are no rooms available.");
        } else {
            room.checkIn(guest);
            System.out.println("The guest has been checked in to the following room:");
            System.out.println(room);
            System.out.println("that room costs " + hotel.getPrice(room, guest) + " Dollars.");
        }
        
        input.nextLine();
    }
    
    /**
     * checks a guest out of their room after asking for guest info
     *
     * @param  
     * @return    
     */
    private static void checkOut()
    {
        //MAYBE IMPLEMENT ID LENGTH REQUIREMENT
        int id;
        int num;
        int floor;
        Guest guest;
        Room room;
        
        System.out.println("What is the guest's ID number? (enter -1 to cancel)");
        do{
            while(!input.hasNextInt()){
                System.out.println("you must enter an integer");
                input.next();
            }
            id = input.nextInt();
            if(id == -1){
                input.nextLine();
                return;
            }
            guest = hotel.getGuest(id);
            if(guest == null){
                System.out.println("There is no guest with that ID");
            }
        } while(guest == null);
        
        room = guest.getRoom();
        if(room == null){
            System.out.println("That guest is not currently staying in the hotel.");
        } else {
            System.out.println("The guest has been checked out");
            room.checkOut();
        }
         
        input.nextLine();
    }
    
}