/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Clock {
    private int hh;
    private int mm;
    private String hmString;

    // Creates a clock whose initial time is h hours and m minutes.
    // Throw an IllegalArgumentException if either integer argument is outside its prescribed bounds
    // (hours between 0 and 23, minutes between 0 and 59).

    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("unacceptable value for h and/or m.");
        }
        hh = h;
        mm = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    // The string argument is composed of two digits, followed by a colon, followed by two digits,
    // such as 09:45. Throw an IllegalArgumentException if either the string argument is not in this format
    // or if it does not correspond to a valid time between 00:00 and 23:59.
    public Clock(String s) {
        if (s.length() != 5) {
            throw new IllegalArgumentException("unacceptable value/format for string");
        }
        String[] arr = s.split("");
        if (!arr[2].equals(":")) {
            throw new IllegalArgumentException("unacceptable value/format for string");
        }
        if (Integer.parseInt(arr[0]) < 0 || Integer.parseInt(arr[1]) < 0 ||
                Integer.parseInt(arr[3]) < 0 || Integer.parseInt(arr[4]) < 0) {
            throw new IllegalArgumentException("unacceptable value/format for string");
        }
        String firstVal = arr[0] + arr[1];
        String secondVal = arr[3] + arr[4];
        if (Integer.parseInt(firstVal) > 23 || Integer.parseInt(secondVal) > 59) {
            throw new IllegalArgumentException("unacceptable value/format for string");
        }
        hmString = s;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (this.hmString != null) {
            return hmString;
        }

        if (hh == 0 && mm == 0) {
            return "00" + ":" + "00";
        }

        String hhStr, mmStr;
        if (hh <= 9) {
            hhStr = "0" + hh;
        }
        else {
            hhStr = String.valueOf(hh);
        }
        if (mm <= 9) {
            mmStr = "0" + mm;
        }
        else {
            mmStr = String.valueOf(mm);
        }
        return hhStr + ":" + mmStr;
    }

    // Is the time on this clock earlier than the time on that one?
    // Times are ordered from 00:00 (earliest) to 23:59 (latest).
    public boolean isEarlierThan(Clock that) {
        int totalMinInt = 0;
        int totalMinStr = 0;
        if (this.hmString == null && that.hmString == null) {
            totalMinInt = (this.hh * 60) + this.mm;
            totalMinStr = (that.hh * 60) + that.mm;
            return (totalMinInt < totalMinStr);
        }
        else if (this.hmString != null && that.hmString != null) {
            String newS = this.hmString;
            String[] arr = newS.split(":");
            int hours = Integer.parseInt(arr[0]);
            int mins = Integer.parseInt(arr[1]);
            totalMinStr = (hours * 60) + mins;
            String newSS = that.hmString;
            String[] arrSS = newSS.split(":");
            int hourSS = Integer.parseInt(arrSS[0]);
            int minSS = Integer.parseInt(arrSS[1]);
            totalMinInt = (hourSS * 60) + minSS;
            return (totalMinStr < totalMinInt);
        }
        else if (this.hmString == null) {
            totalMinInt = (this.hh * 60) + this.mm;
            String newS = that.hmString;
            String[] arr = newS.split(":");
            int hours = Integer.parseInt(arr[0]);
            int mins = Integer.parseInt(arr[1]);
            totalMinStr = (hours * 60) + mins;
            return (totalMinInt < totalMinStr);
        }
        else {
            String newS = this.hmString;
            String[] arr = newS.split(":");
            int hours = Integer.parseInt(arr[0]);
            int mins = Integer.parseInt(arr[1]);
            totalMinStr = (hours * 60) + mins;
            totalMinInt = (that.hh * 60) + that.mm;
            return (totalMinStr < totalMinInt);
        }
    }

    // Adds 1 minute to the time on this clock.
    // For example, one minute after 06:00 is 06:01; one minute after 23:59 is 00:00.
    public void tic() {
        if (this.hmString == null) {
            if (hh == 23 && mm == 59) {
                hh = 0;
                mm = 0;
            }
            else if (mm == 59) {
                mm = 0;
                hh++;
            }
            else {
                mm++;
            }
        }
        else {
            String newS = hmString;
            String[] arr = newS.split(":");
            if (Integer.parseInt(arr[0]) == 23 && Integer.parseInt(arr[1]) == 59) {
                arr[0] = "00";
                arr[1] = "00";
                newS = String.join(":", arr);
                hmString = newS;
            }
            else if (Integer.parseInt(arr[1]) == 59) {
                int up = Integer.parseInt(arr[0]);
                up++;
                arr[0] = String.valueOf(up);
                arr[1] = "00";
                newS = String.join(":", arr);
                hmString = newS;
            }
            else {
                int up = Integer.parseInt(arr[1]);
                up++;
                if (up <= 9) {
                    arr[1] = "0" + up;
                }
                else {
                    arr[1] = String.valueOf(up);
                }

                newS = String.join(":", arr);
                hmString = newS;
            }
        }
    }

    // Adds Δ minutes to the time on this clock.
    // For example, 60 minutes after 12:34 is 13:34.
    // Throw an IllegalArgumentException if Δ is negative.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("value of delta cannot be negative");
        }
        if (this.hmString == null) {
            int strDelta = delta;
            int mm60 = mm;
            while (strDelta >= 60) {
                hh++;
                if (hh == 24) {
                    hh = 0;
                }
                strDelta -= 60;
            }
            mm60 += strDelta;
            // StdOut.println("mm60 " + mm60);
            if (mm60 > 59) {
                hh++;
                if (hh == 23) {
                    hh = 0;
                }
                mm60 -= 60;
                // StdOut.println("mm60 if " + mm60);
                mm = mm60;
            }
            else {
                mm = mm60;
                // StdOut.println("mm60 = mm = " + mm);
            }
        }
        else {
            String newS = hmString;
            String[] arr = newS.split(":");
            int strDelta = delta;
            int mm60 = Integer.parseInt(arr[1]);
            // StdOut.println("mm60start " + mm60);
            while (strDelta >= 60) {
                int arrHH = Integer.parseInt(arr[0]);
                arrHH++;
                if (arrHH == 24) {
                    arrHH = 0;
                }
                arr[0] = String.valueOf(arrHH);
                strDelta -= 60;
            }
            mm60 += strDelta;
            // StdOut.println("mm60 + strDelta " + mm60);
            if (mm60 > 59) {
                int arrHH = Integer.parseInt(arr[0]);
                arrHH++;
                if (arrHH == 24) {
                    arrHH = 0;
                }
                arr[0] = String.valueOf(arrHH);
                mm60 -= 60;
                // StdOut.println("mm60 loop " + mm60);
            }
            else {
                arr[1] = String.valueOf(mm60);
            }
            if (mm60 <= 9) {
                arr[1] = "0" + String.valueOf(mm60);
            }
            else {
                arr[1] = String.valueOf(mm60);
            }
            // StdOut.println("mm60 = mm = " + arr[1]);
            newS = String.join(":", arr);
            hmString = newS;

        }
    }

    // Test client.
    public static void main(String[] args) {
        if (args.length == 3) {
            int h = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            int delta = Integer.parseInt(args[2]);
            if (h < 0 || h > 23 || m < 0 || m > 59 || delta < 0) {
                throw new IllegalArgumentException("unacceptable value for h, m, and/or delta");
            }
            Clock numClock = new Clock(h, m);
            StdOut.println(numClock);
            numClock.tic();
            StdOut.println(numClock);
            numClock.toc(delta);
            StdOut.println(numClock);

            Clock thatClock = new Clock(h, m);
            thatClock.tic();
            StdOut.println(numClock.isEarlierThan(thatClock));
        }
        else if (args.length == 2) {
            String str = args[0];
            int delta = Integer.parseInt(args[1]);
            if (delta < 0) {
                throw new IllegalArgumentException("unacceptable value for delta");
            }
            if (str.length() != 5) {
                throw new IllegalArgumentException("unacceptable value/format for string");
            }
            String[] arr = str.split("");
            if (!arr[2].equals(":")) {
                throw new IllegalArgumentException("unacceptable value/format for string");
            }
            if (Integer.parseInt(arr[0]) < 0 || Integer.parseInt(arr[1]) < 0 ||
                    Integer.parseInt(arr[3]) < 0 || Integer.parseInt(arr[4]) < 0) {
                throw new IllegalArgumentException("unacceptable value/format for string");
            }
            String firstVal = arr[0] + arr[1];
            String secondVal = arr[3] + arr[4];
            if (Integer.parseInt(firstVal) > 23 || Integer.parseInt(secondVal) > 59) {
                throw new IllegalArgumentException("unacceptable value/format for string");
            }

            Clock strClock = new Clock(str);
            StdOut.println(strClock);
            strClock.tic();
            StdOut.println(strClock);
            strClock.toc(delta);
            StdOut.println(strClock);

            Clock thatClock = new Clock(str);
            thatClock.tic();
            StdOut.println(strClock.isEarlierThan(thatClock));
        }
    }
}
