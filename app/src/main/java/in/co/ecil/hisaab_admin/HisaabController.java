package in.co.ecil.hisaab_admin;

import java.util.EnumMap;

/**
 * Created by Rishav
 * on 18/7/17.
 */

public class HisaabController
{
    private static HisaabController instance;
    public static final int MAX_ROOMMATE_COUNT = 4;
    private static Roommate[] roommates;

    public static Roommate[] getRoommates()
    {
        return roommates;
    }

    private static Roommate currentRoommate;
    private EnumMap<IndexOf,Integer> roommateIndex;

    public HisaabController()
    {
        roommates = new Roommate[MAX_ROOMMATE_COUNT];
        roommateIndex = new EnumMap<>(IndexOf.class) ;
        
        int i = 0;
        for (IndexOf index: IndexOf.values())
            roommateIndex.put(index,i++);
        

        roommates[roommateIndex.get(IndexOf.Naveen)] = new Roommate("Naveen",0.0f,"");
        roommates[roommateIndex.get(IndexOf.Sandeep)] = new Roommate("Sandeep",0.0f,"");
        roommates[roommateIndex.get(IndexOf.Saurabh)] = new Roommate("Saurabh",0.0f,"");
        roommates[roommateIndex.get(IndexOf.Rishav)] = new Roommate("Rishav",0.0f,"");

        currentRoommate = null;
    }

    public Roommate getRoommateAtIndex (IndexOf index)
    {
        return roommates[roommateIndex.get(index)];
    }

    public void setCurrentroommate (Roommate roommate)
    {
        currentRoommate = roommate;
    }
    public void setCurrentroommateByIndex (IndexOf index)
    {
        currentRoommate = roommates[roommateIndex.get(index)];
    }

    public Roommate getCurrentRoommate ()
    {
        return currentRoommate;
    }

    public static HisaabController instance ()
    {
        if (instance == null)
            instance = new HisaabController();
        return instance;
    }


}
