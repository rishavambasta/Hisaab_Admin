package in.co.ecil.hisaab_admin;

import java.util.EnumMap;

/**
 * Created by Rishav
 * on 18/7/17.
 */

/**********************
 * Manager/Controller
 **********************/

public final class HisaabController
{
    private static HisaabController instance;
    public static final int MAX_ROOMMATE_COUNT = 4;
    private  Roommate[] roommates;

    public Roommate[] getRoommates()
    {
        return roommates;
    }

    private Roommate currentRoommate;
    private EnumMap<IndexOf,Integer> roommateIndex;

    private HisaabController()
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

    public int getRoommateIndexAt(IndexOf roommate)
    {
        return roommateIndex.get(roommate);
    }

    public Roommate getCurrentRoommate ()
    {
        return currentRoommate;
    }

    public static HisaabController getInstance ()
    {
        if (instance == null)
            instance = new HisaabController();
        return instance;
    }


}
