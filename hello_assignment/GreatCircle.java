public class GreatCircle {
    
    public static void main(String[] args) {
        double a1 = Double.parseDouble(args[0]);
        double b1 = Double.parseDouble(args[1]);
        double a2 = Double.parseDouble(args[2]);
        double b2 = Double.parseDouble(args[3]);

        double x1 = Math.toRadians(a1);
        double y1 = Math.toRadians(b1);
        double x2 = Math.toRadians(a2);
        double y2 = Math.toRadians(b2);

        double r = 6371.0;

        double distance = (2 * r) * Math.asin(Math.sqrt(Math.sin((x2 - x1) / 2.0) * Math.sin((x2 - x1) / 2.0) + Math.cos(x1) * Math.cos(x2) * Math.sin((y2 - y1) / 2.0) * Math.sin((y2 - y1) / 2.0)));
        
        System.out.println(distance + " kilometers");
    }
}