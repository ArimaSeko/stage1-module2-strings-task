package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimiters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> answer = new ArrayList<>();
        String delim="";
        String[] Delimiters = (String[]) delimiters.toArray();
        for(int i=0;i<Delimiters.length;i++){
            delim = delim + Delimiters[i];
        }
        StringTokenizer st1 = new StringTokenizer(source, delim);
        while (st1.hasMoreTokens())answer.add(st1.nextToken());
        return answer;
    }
}
