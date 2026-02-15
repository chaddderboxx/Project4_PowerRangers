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

import java.util.*;

public class TriageSimulator {
    private final Deque<String> p1 = new ArrayDeque<>();
    private final Deque<String> p2 = new ArrayDeque<>();
    private final Deque<String> p3 = new ArrayDeque<>();

    public void add(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 3) return; // or throw

        String fullName = parts[0] + " " + parts[1];
        String code = parts[2].toUpperCase();

        int priority = (code.equals("AL") || code.equals("HA") || code.equals("ST")) ? 1
                : (code.equals("HN")) ? 3
                : (code.equals("BL") || code.equals("SF") || code.equals("IW") || code.equals("KS") || code.equals("OT")) ? 2
                : 2;

        if (priority == 1) p1.addLast(fullName);
        else if (priority == 2) p2.addLast(fullName);
        else p3.addLast(fullName);
    }

    public String remove() {
        if (!p1.isEmpty())  return p1.removeFirst();
        if (!p2.isEmpty())  return p2.removeFirst();
        if (!p3.isEmpty())  return p3.removeFirst();
        return null; // or throw
    }

    public boolean isEmpty() {
        return p1.isEmpty() && p2.isEmpty() && p3.isEmpty();
    }
}
