package base.algo;

import java.util.*;

/**
 * Created by hchang on 6/2/16.
 */
public class TopologySort {
    private Map<String, Queue<String>> map;
    private List<String> path;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap();
        path = new LinkedList();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue());
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        visit("JFK");
        return path;
    }

    private void visit(String airport) {
        while(map.containsKey(airport) && map.get(airport).size() > 0) {
            visit(map.get(airport).poll());
        }
        path.add(0, airport);
    }
}
