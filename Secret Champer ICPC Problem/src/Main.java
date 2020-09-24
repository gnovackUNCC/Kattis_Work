import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //System.out.println("Input Number of Translations then Number of Words");
        int numTranslate = scan.nextInt();
        int numWordPair = scan.nextInt();

        String[][] wordPairs = new String[numWordPair][2];

        Map<String, List<String>> dictionary = new HashMap<>();

        ArrayList<String> answers = new ArrayList<>();

        //System.out.println("Input Decoder");
        for(int i = 0; i < numTranslate; i++){
            String key = scan.next();
            String value = scan.next();
            try{
                dictionary.get(key).add(value);
            }catch (Exception e){
                dictionary.put(key, new ArrayList<>());
                dictionary.get(key).add(value);
            }
        }
        for(String[] a : wordPairs){
            boolean isMatch = true;
            //System.out.println("Input words to Compare");
            for(int i = 0; i < a.length; i++)
                a[i] = scan.next();

            String str1 = a[0];
            String str2 = a[1];

            if(str1.length() != str2.length())
                isMatch = false;
            else{
                for(int i = 0; i < str1.length(); i++){
                    String char1 = str1.substring(i, i + 1);
                    String char2 = str2.substring(i, i + 1);
                    try {
                        if (!(char1.equals(char2) || recurCheck(dictionary, dictionary.get(char1), char2)/*dictionary.get(char1).contains(char2)*/)) {
                            isMatch = false;
                            break;
                        }
                    } catch (Exception e) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if(isMatch)
                answers.add("yes");
            else
                answers.add("no");
        }

        for (String i : answers) {
            System.out.println(i);
        }
    }

    private static boolean recurCheck(Map<String, List<String>> dic, List<String> currentList, String targetChar){
        if(currentList == null)
            return false;
        if(currentList.contains(targetChar))
            return true;
        return recurCheck(dic, dic.get(currentList.get(0)), targetChar) || recurCheck(dic, dic.get(currentList.get(1)), targetChar);
    }
}
