package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();
    /*
    Updates the board(racerMap) by making a DuckRace win.
    - could fetch an existing DuckRacer from racerMap,
    - or might need to create a new DuckRacer, put it in the map. and then make it win.
    Either way needs to win
    */

    public void update(int id,Reward reward){
        DuckRacer racer = null;
        if(racerMap.containsKey(id)){ //fetch existing racer
            racer = racerMap.get(id);
        }
        else{                           //create new DuckRacer
            racer = new DuckRacer(id,studentIdMap.get(id));
            racerMap.put(id,racer);  //easy to forget this step
        }
        racer.win(reward);
    }
/*    This shows the data to the human user
            we need to show the right side of the map, ideally in an attractive way*/
    public void show(){
        Collection<DuckRacer> racers = racerMap.values();
        System.out.println("id      name        wins        rewards");
        System.out.println("--      ----        ----        -------");
        for(DuckRacer racer : racerMap.values()){
            System.out.printf("%s       %s      %s      %s\n", racer.getId(),racer.getName(), racer.getWins(), racer.getRewards());
            //System.out.println(racer);
        }
    }

    //TODO: make it pretty , as close to the real board the we show in class as possible


    //TESTING PURPOSES ONLY
    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }
    void dumpRacerMap(){
        System.out.println(racerMap);
    }

    /*Populates studentIdMap from file conf/student-ids.csv*/
    private Map<Integer, String> loadStudentIdMap() {
        //map would contain each line of the list after some steps (done in try-catch)
        Map<Integer, String> map = new HashMap<>();

        try {
            //Reading the file creating a list with strings. each slot will be a line in the file
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
            //For each line(String) , we need to split it into "tokens" based on the comma
            for (String line : lines) {
                String[] tokens = line.split(",");  //the array conceptually will look like : ["1", "Amir"]

                /*
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
                */
                //The three lines above can be compacted to :
                map.put(Integer.parseInt(tokens[0]),tokens[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}