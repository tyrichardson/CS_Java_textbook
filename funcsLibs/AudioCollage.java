/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amped = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amped[i] = a[i] * alpha;
        }
        return amped;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] reversed = new double[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = a[len - 1 - i];
        }
        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int len = a.length + b.length;
        double[] merged = new double[len];
        int i = 0;
        for (double el : a) {
            merged[i] = el;
            i++;
        }
        for (double el : b) {
            merged[i] = el;
            i++;
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int len = 0;
        if (a.length >= b.length) {
            len = a.length;
            double[] upped = new double[len];
            double[] mixed = new double[len];
            for (int i = 0; i < len; i++) {
                if (i > b.length - 1) {
                    upped[i] = 0;
                }
                else {
                    upped[i] = b[i];
                }
            }
            for (int i = 0; i < len; i++) {
                mixed[i] = a[i] + upped[i];
            }
            return mixed;
        }
        else {
            len = b.length;
            double[] upped = new double[len];
            double[] mixed = new double[len];
            for (int i = 0; i < len; i++) {
                if (i > a.length - 1) {
                    upped[i] = 0;
                }
                else {
                    upped[i] = a[i];
                }
            }
            for (int i = 0; i < len; i++) {
                mixed[i] = upped[i] + b[i];
            }
            return mixed;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] sped = new double[(int) (a.length / alpha)];
        for (int i = 0; i < sped.length; i++) {
            sped[i] = a[(int) (Math.floor(alpha * i))];
        }
        return sped;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] scratch = StdAudio.read("scratch.wav");
        double[] singer = StdAudio.read("singer.wav");

        double[] ampedUp = amplify(beatbox, 4);
        double[] loudSinger = amplify(singer, 2);
        double[] cowScratch = (mix(cow, scratch));
        double[] backwardsSinger = reverse(loudSinger);
        double[] meatyBeaty = merge(beatbox, ampedUp);
        double[] longBeaty = merge(meatyBeaty, meatyBeaty);
        double[] longerBeaty = merge(longBeaty, meatyBeaty);
        double[] backwardsBeaty = mix(backwardsSinger, longerBeaty);

        StdAudio.play(backwardsBeaty);
        StdAudio.play(mix(piano, cowScratch));
        StdAudio.play(changeSpeed(chimes, 3.0));
        StdAudio.play(cow);
    }
}
