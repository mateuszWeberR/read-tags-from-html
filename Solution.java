package com.codegym.task.task19.task1918;

/* 
Introducing tags
/home/mati/temporary/file4.txt
args[0] "span"

<span>girl</span>
<span xml:lang="en" lang="en"<span>girl</span><span>Leela Turanga</span></span>
<span xml:lang="en" lang="en"><b><span>Leela Turanga</span></b></span>
<span>picza<span>Leela Turanga</span></span>
<span>Super</span>
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String parameter = args[0];
        String openTag = "<" + parameter;  // <span
        String closeTag = "</" + parameter;  // </span

        String line = "";
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                // Read one line and replace original tags on new ONE character sign
                String newLine = reader1.readLine();
                line += newLine;
            }
        }

        String omega = "Ω";
        String omegaReplace = line.replaceAll(closeTag, omega);
        char[] lineToChar = omegaReplace.toCharArray();
        char[] omegaArray = omega.toCharArray();
        char omegaChar = omegaArray[0];

        int counterOfTagsPerLine = 0;
        for (char c : lineToChar) {
            if (c == omegaChar)
                counterOfTagsPerLine++;
        }

        // create two list for write each tag open and close index
        ArrayList<Integer> indexesOfOpen = new ArrayList<>();
        ArrayList<Integer> indexesOfClose = new ArrayList<>();


        // now do it
        int newIndex = 0;
        int newIndextLast = 0;
        for (int i = 0; i < counterOfTagsPerLine; i++) {
            int index = line.indexOf(openTag, newIndex);
            int indexLast = line.indexOf(closeTag, newIndextLast);
            indexesOfOpen.add(index);
            indexesOfClose.add(indexLast);
            newIndex = index + 1;
            newIndextLast = indexLast + 1;
        }

        // Create list for every index values
        List<Integer> totalList = new ArrayList<>();
        totalList.addAll(indexesOfOpen);
        totalList.addAll(indexesOfClose);
        Collections.sort(totalList);

        int counter = 0;
        boolean open = true;
        for (int i = 1; i < totalList.size(); i++) {
            // checking that number is in open or close list
            for (int o : indexesOfOpen) {
                if (totalList.get(i) == o) {
                    open = true;
                }
            }
            for (int c : indexesOfClose) {
                if (totalList.get(i) == c) {
                    open = false;
                }
            }
            // Now main algorithm
            if (open) {
                counter++;
            } else {
                if (counter == 0) {
                    System.out.println(line.substring(totalList.get(0), totalList.get(i) + closeTag.length() + 1));
                    totalList.remove(i);
                    totalList.remove(0);
                    i = 0;
                } else {
                    counter--;
                }
            }
        }


    }
}

