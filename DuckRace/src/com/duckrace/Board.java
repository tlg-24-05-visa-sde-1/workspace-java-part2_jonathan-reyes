package com.duckrace;

import java.io.*;
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

public class Board implements Serializable{
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String STUDENT_ID_FILE_PATH = "conf/student-ids.csv";
    /*
    * Read from binary file data/board.dat or create new Board(if file not there)
    * NOTE: new board object only created the "very first time" the app is run .
    */
    public static Board getInstance() {
        Board board = null;

        if(Files.exists(Path.of(DATA_FILE_PATH))) {//file exists, read in the file
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{ // create a new board
            board = new Board();
        }


        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    //prevent instantiation from outside , if we don't do this then there is one constructor that is freely given by java
    // and that will be public.
    private Board(){
    }



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
        save();
    }

    /*
     *  Writes 'this' Board object to binary file data/board.dat
     *  In more detail, we are using Java's built-in Object Serialization facility
     *  to write the state of this object to the file
     */

    private void save() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))){
            out.writeObject(this);      //write "me" ( the board object) to the file( as bytes)
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


    /*    This shows the data to the human user
                we need to show the right side of the map, ideally in an attractive way*/
    public void show(){
       if(racerMap.isEmpty()){
           System.out.println("There are currently no results to show");

       }
       else{
           Collection<DuckRacer> racers = racerMap.values();
           System.out.println("id      name        wins        rewards");
           System.out.println("--      ----        ----        -------");
           for(DuckRacer racer : racerMap.values()){
               System.out.printf("%s       %s      %s      %s\n", racer.getId(),racer.getName(), racer.getWins(), racer.getRewards());
               //System.out.println(racer);
           }
       }

    }



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
            List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));
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