class TimeMap {

    private Map<String, Map<Integer, List<String>>> store;

    public TimeMap() {
        store  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new HashMap<>());
        store.get(key).putIfAbsent(timestamp, new ArrayList<>());
        store.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)) {
            return "";
        }

        int seen = 0;
        for(int time : store.get(key).keySet()) {
            if(time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }

        if(seen == 0) return ""; // no match
        int endOfList = store.get(key).get(seen).size() - 1;
        return store.get(key).get(seen).get(endOfList);
    }
}
