/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/

import  java.util.*;

public class AStarState
{
    private Map2D map;

    private HashMap<Location, Waypoint> open = new HashMap<>();;
    private HashMap<Location, Waypoint> close = new HashMap<>();;
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
        if (numOpenWaypoints() == 0)
            return null;
        Waypoint minWaypoint = null;
        float minCost = Float.MAX_VALUE;
        for (HashMap.Entry<Location, Waypoint> entry : open.entrySet()) {
            Location key = entry.getKey();
            Waypoint value = entry.getValue();
            if (value.getTotalCost() < minCost) {
                minWaypoint = value;
                minCost = value.getTotalCost();
            }
        }
        return minWaypoint;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Location location = newWP.getLocation();
        if (open.containsKey(location)) {
            Waypoint currWP = open.get(location);
            if (newWP.getPreviousCost() < currWP.getPreviousCost()) {
                open.put(location, newWP);
                return true;
            }
            return false;
        }
        open.put(location, newWP);
        return true;
    }


    public int numOpenWaypoints()
    {
        return open.size();
    }


    public void closeWaypoint(Location loc)
    {
        Waypoint waypoint = open.remove(loc);
        close.put(loc, waypoint);
    }

    public boolean isLocationClosed(Location loc)
    {
        return close.containsKey(loc);
    }
}
