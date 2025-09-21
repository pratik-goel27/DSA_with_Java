package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_I {
    static class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord, 1));
        Set<String> st = new HashSet<>();
        for(String word : wordList) {
            st.add(word);
        }
        st.remove(startWord);

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().level;
            q.poll();
            if(word.equals(targetWord)) return steps;

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedWordArr = word.toCharArray();
                    replacedWordArr[i] = ch;
                    String replacedWord = new String(replacedWordArr);

                    if(st.contains(replacedWord)) {
                        q.offer(new Pair(replacedWord, steps + 1));
                        st.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";

        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }
}
