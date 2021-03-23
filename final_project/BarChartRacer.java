/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        String caption = " ";
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1200, 800);
        StdDraw.enableDoubleBuffering();
        // create an array of n bars
        while (!in.isEmpty()) {
            chart.reset();
            int n = in.readInt();
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String line = in.readString();
                line += in.readLine();
                String[] lineIn = line.split(",");
                caption = lineIn[0];
                String name = lineIn[1];
                int value = Integer.parseInt(lineIn[3]);
                String category = lineIn[4];
                bars[i] = new Bar(name, value, category);
            }
            // sort in ascending order by weight
            Arrays.sort(bars);
            // create the bar chart
            chart.setCaption(caption);
            // add the bars to the bar chart
            int barNum = 1;
            if (n < k) {
                barNum = n;
            }
            else {
                barNum = (bars.length - 1) - (k - 1);
            }
            for (int j = bars.length - 1; j >= barNum; j--) {
                chart.add(bars[j].getName(), bars[j].getValue(), bars[j].getCategory());
            }
            // draw the bar chart

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
