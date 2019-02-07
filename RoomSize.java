 


/**
 * Enumeration class ROOMSIZE - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum RoomSize
{
    SINGLE(100),DOUBLE(140),QSINGLE(180),QDOUBLE(240),SUITE(300), NULL(0); //Null is for input validation in the UI Class
    private int price;
    private RoomSize(int price ){
        this.price = price;
        
    }
    
    public int getPrice(){
        return this.price;
    }
    
}