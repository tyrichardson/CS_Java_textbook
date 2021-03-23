/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    // Use substring(), equals(), and length()
    public static int maxRepeats(String dna) {
        int counter = 0;
        int max = 0;
        int i = 0;

        while (i < dna.length()) {
            if (i + 3 > dna.length()) break;
            if (dna.substring(i, i + 3).equals("CAG")) {
                counter++;
                i += 3;
            }
            else {
                if (counter > max) {
                    max = counter;
                }
                counter = 0;
                i++;
            }
        }
        if (counter > max) {
            max = counter;
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    // Use replace(), \n, and \t
    public static String removeWhitespace(String s) {
        String s1 = s.replace(" ", "");
        String s2 = s1.replace("\n", "");
        String s3 = s2.replace("\t", "");
        return s3;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) return "not human";
        else if (maxRepeats < 36) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else return "Huntington's";
    }

    public static void main(String[] args) {
        In input = new In(args[0]);
        String seq = input.readAll();
        seq = removeWhitespace(seq);
        int max = maxRepeats(seq);
        if (max < 10) StdOut.println("max repeats = " + max + "\n" + diagnose(max));
        else if (max < 36) StdOut.println("max repeats = " + max + "\n" + diagnose(max));
        else if (max < 40) StdOut.println("max repeats = " + max + "\n" + diagnose(max));
        else if (max < 181) StdOut.println("max repeats = " + max + "\n" + diagnose(max));
        else StdOut.println("max repeats = " + max + "\n" + diagnose(max));
    }
}
