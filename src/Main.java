//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 *@author Chad Thornton Scott
 *CIS 2353
 *Summer 2025
 *
 *Pseudocode for proj4 - Triage Simulator
 *-------------------------------------------
 *0. Learned to include pseudocode on every build so I don't make mistakes as I did on proj2 & proj3
 *
 *1. Create a TriageSimulator class
 *    1. maintain 3  regular queues, with 3 priorities
 *     1. priority1Queue AL, HA, ST
 *     2. priority2Queue BL, SF, IW, KS, OT
 *     3. priority3Queue HN
 *    2. ensure to implement these methods:
 *       1. add(string lineFromFile) and doesn't return anything
 *        1.parse line into firstName, lastName, triageCode
 *        2. Determine priority level from triageCode
 *       2. remove() which returns the name of the next patient to be seen, and removes him/her/they from the appropriate queue
 *       3. isEmpty() which returns a boolean, indicating that all three queues are empty
 *
 *2. Define class Main (with main method)
 *    1. Create instance of TriageSimulator
 *    2. Open the file with the list, one per line <--- calls a single .txt, the priority chart is coded, not from list.
 *    3. For each line in the file, - call add(line)
 *    4. While simulator is not empty, - call remove() and print the returned patient name
 *
 *3. End program
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TriageSimulator sim = new TriageSimulator();

        try (Scanner sc = new Scanner(new File("PowerRangers.txt"))) {
            while (sc.hasNextLine()) sim.add(sc.nextLine());

        }

        while (!sim.isEmpty()) {
            System.out.println(sim.remove());
        }
    }
}