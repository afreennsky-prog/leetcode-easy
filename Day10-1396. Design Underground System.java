import java.util.*;

class UndergroundSystem {
    // Map to store check-in info: id -> (stationName, time)
    private Map<Integer, Pair> checkInMap;
    
    // Map to store travel data: "startStation->endStation" -> (totalTime, tripCount)
    private Map<String, TravelData> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo = checkInMap.get(id);
        checkInMap.remove(id); // free up memory since trip is complete

        String startStation = checkInInfo.station;
        int startTime = checkInInfo.time;
        int travelTime = t - startTime;

        String routeKey = startStation + "->" + stationName;
        TravelData data = travelMap.getOrDefault(routeKey, new TravelData());
        data.totalTime += travelTime;
        data.count += 1;
        travelMap.put(routeKey, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        TravelData data = travelMap.get(routeKey);
        return (double) data.totalTime / data.count;
    }

    // Helper classes
    private static class Pair {
        String station;
        int time;
        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class TravelData {
        int totalTime;
        int count;
        TravelData() {
            this.totalTime = 0;
            this.count = 0;
        }
    }

    // Example usage
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // 12 minutes
        undergroundSystem.checkOut(27, "Waterloo", 20);  // 10 minutes
        undergroundSystem.checkOut(32, "Cambridge", 22); // 14 minutes
        
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
        
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);  // 14 minutes
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 12.0
    }
}
