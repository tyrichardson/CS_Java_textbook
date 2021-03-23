/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String barName;
    private final int barValue;
    private final String barCategory;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) {
            throw new IllegalArgumentException(
                    "name and category cannot be null; value cannot be negative.");
        }
        barName = name;
        barValue = value;
        barCategory = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.barName;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.barValue;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.barCategory;
    }

    // Compare two bars by value; if < returns neg int, == returns 0, > returns pos int
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("argument 'that' cannot be null");
        }
        return Integer.compare(this.barValue, that.barValue);
    }

    // Sample client
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        // create the bar chart
        String title = "The 10 most populous cities";
        String xAxis = "Population (thousands)";
        String source = "Source: United Nations";
        BarChart chart = new BarChart(title, xAxis, source);
        chart.setCaption("2018");

        // add the bars to the bar chart
        for (int i = bars.length - 1; i >= 0; i--) {
            chart.add(bars[i].barName, bars[i].barValue, bars[i].barCategory);
        }

        // draw the bar chart
        chart.draw();
    }
}
