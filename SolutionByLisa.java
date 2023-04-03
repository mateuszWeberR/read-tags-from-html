package com.codegym.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
/home/mati/temporary/file3.txt
*/
public class SolutionByLisa {
    public static void main(String[] args) throws IOException {
        StringBuilder html = new StringBuilder();

        String search = args[0];
        String startTag = "<" + search;
        String endTag = "</" + search + ">";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new FileReader(reader.readLine()))) {
            while (in.ready()) html.append(in.readLine());
        } catch (IOException ignore) {}

// solution using patter-matcher
//        Matcher matcherStart = Pattern.compile(startTag).matcher(html);
//        Matcher matcherEnd = Pattern.compile(endTag).matcher(html);
//
//        while (matcherStart.find()) {
//            int startPos = matcherStart.start();
//
//            while (matcherEnd.find(startPos)) {
//                String part = html.substring(matcherStart.start(), matcherEnd.end());
//                if (part.split(startTag).length == (part + " ").split(endTag).length) {
//                    System.out.println(part);
//                    break;
//                }
//                startPos = matcherEnd.end();
//            }
//        }
        // solution using substring
        // Info about Leela <span xml:lang="en" lang="en"><b><span>Leela Turanga</span></b></span><span>Super</span><span>girl</span>
        for (int counter = 0; counter <= html.length() - endTag.length() ; counter++) {
            int tagStartIndex;
            int nestedOccurrences = 0;

            if (html.substring(counter, counter + startTag.length()).equals(startTag)) {
                tagStartIndex = counter;
                counter += startTag.length();
                for (int endCounter = counter; endCounter <= html.length() - endTag.length(); endCounter++) {
                    if (html.substring(endCounter, endCounter + startTag.length()).equals(startTag))
                        nestedOccurrences++;
                    if (html.substring(endCounter, endCounter + endTag.length()).equals(endTag)) {
                        if (nestedOccurrences > 0) {
                            nestedOccurrences--;
                        } else {
                            System.out.println(html.substring(tagStartIndex, endCounter + endTag.length()));
                            break;
                        }
                    }
                }
            }
        }
    }

}
