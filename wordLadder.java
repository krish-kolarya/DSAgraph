import java.util.*;
class Word{
    String str;
    int level;
    Word(String str,int level){
        this.str = str;
        this.level = level;
    }
}
class wordLadder{
    public static void main(String[] args){
        /*Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the start word: ");
        String begin = sc.nextLine();
        System.out.println("Enter the end word: ");
        String end = sc.nextLine();
        System.out.println("Enter the number of words in the list: ");
        int num = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        System.out.println("Enter the words in the word list: ");
        for(int i = 0; i < num; i++){
            String temp = sc.nextLine();
            wordList.add(temp);
        }*/
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int steps = ladderLength(begin,end,wordList);
        System.out.println("Steps: " + steps);
    }
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> mySet = new HashSet<>(wordList);
        mySet.remove(beginWord);
        Queue<Word> Q = new LinkedList<>();
        Q.add(new Word(beginWord,1));

        while(!Q.isEmpty()){
            Word w = Q.poll();
            if(w.str.equals(endWord) == true){
                return w.level;
            }
            char[] charArr = w.str.toCharArray();
            for(int i = 0; i < charArr.length; i++){
                char originalChar = charArr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    charArr[i] = ch;
                    String newString = new String(charArr);
                    if(mySet.contains(newString)){
                        mySet.remove(newString);
                        Q.add(new Word(newString,w.level + 1));
                    }
                }
                charArr[i] = originalChar;
            }
        }

        return 0;
    }
}