package com.example.word_counter.utils;

public class TextCounter {
    public static int CountChar(String phrase){
        phrase = phrase.replaceAll("[, ;]", "");
        return phrase.length();
    }
}
