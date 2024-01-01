package com.epam.mjc;

import java.util.Collection;

import java.util.LinkedList;

import java.util.List;


public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        List<String> list = new LinkedList<>();

            StringBuilder sb = new StringBuilder();

            for (String delimiter : delimiters) {

                sb.append(delimiter);

            }

            String delimitersAllOne = sb.toString();

            String delimitersAllTwo = "[" + delimitersAllOne + "]";

            String[] out = source.split(delimitersAllTwo);

            for (int i = 0; i < out.length; i++) {

                String str = out[i];

                if (str.length() != 0) {

                    list.add(out[i]);

                }

            }

            return list;

    }
}
