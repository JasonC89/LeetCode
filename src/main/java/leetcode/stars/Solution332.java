package leetcode.stars;

import java.util.*;

/**
 * Created by Jason on 6/14/16.
 * Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of
 * departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who
 * departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the
 itinerary that has the smallest lexical order when read as a single
 string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical
 order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 But it is larger in lexical order.
 */
public class Solution332 {
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
