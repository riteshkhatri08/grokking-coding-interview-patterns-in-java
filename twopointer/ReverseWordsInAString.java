package twopointer;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String sentence = "The input string may contain leading ";
        var result = reverseWords(sentence);

        System.out.println("ANSWER = " + result);

    }

    public static String reverseWords(String input) {
        char[] charray = input.toCharArray();
        char[] result = new char[charray.length + 2];

        int right = 0;
        // REACH FIRST LETTER IN STRING , SKIP LEFT LEADING SPACES
        while (right < charray.length && charray[right] == ' ') {
            right++;
        }

        int wordstart = right;
        int writeword = result.length - 1;
        int temp = 0;

        while (right < charray.length) {
            // TRAVERS non whitespace characters
            if (charray[right] != ' ') {
                right++;
                // make place in result array
                writeword--;
            } else {
                // FOUND SPACE character
                // Make space for another ' ' after the word in result array
                // writeword--;
                temp = writeword;
                while (wordstart < right) {
                    // Write letters
                    result[temp++] = charray[wordstart++];
                }
                // add whitespace after word
                result[temp] = ' ';
                writeword--;
                print(result);
                // Now skip all white spaces
                while (right < charray.length && charray[right] == ' ') {
                    right++;
                }
                wordstart = right;
            }

        }
        // ADD LAST WORD
        if (charray[right - 1] != ' ') {
            temp = writeword;
            while (wordstart < right) {
                // Write letters
                result[temp++] = charray[wordstart++];
            }
            // add whitespace after word
            result[temp] = ' ';
        }
        result[result.length - 1] = 0;
        return new String(result);
    }

    public static void print(char[] arr) {
        System.out.print("[");
        for (char c : arr) {
            if ((c + "").equals("\u0000")) {
                c = '&';
            }
            System.out.print(c + "*");
        }
        System.out.println("]");
    }

}
