/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static Picture kernel(Picture picture, double[][] weights) {
        int width = picture.width();
        int height = picture.height();
        Picture newPicture = new Picture(width, height);
        int weightsWidth = weights[0].length;
        int weightsHeight = weights.length;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                for (int i = 0; i < weightsWidth; i++) {
                    for (int j = 0; j < weightsHeight; j++) {
                        int imageCol = (col - weightsWidth / 2 + i + width) % width;
                        int imageRow = (row - weightsHeight / 2 + j + height) % height;
                        int rgb = picture.getRGB(imageCol, imageRow);
                        int r = (rgb >> 16) & 0xff;
                        int g = (rgb >> 8) & 0xff;
                        int b = (rgb) & 0xff;
                        red += (int) Math.round(r * weights[i][j]);
                        green += (int) Math.round(g * weights[i][j]);
                        blue += (int) Math.round(b * weights[i][j]);

                    }
                }
                int newRed, newGreen, newBlue;
                newRed = Math.min(Math.max(red, 0), 255);
                newGreen = Math.min(Math.max(green, 0), 255);
                newBlue = Math.min(Math.max(blue, 0), 255);

                Color newColor = new Color(newRed, newGreen, newBlue);

                newPicture.set(col, row, newColor);
            }
        }
        return newPicture;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = {
                { 0.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0 },
                { 0.0, 0.0, 0.0 }
        };
        Picture identity = kernel(picture, weights);
        return identity;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { 1.0, 2.0, 1.0 },
                { 2.0, 4.0, 2.0 },
                { 1.0, 2.0, 1.0 }
        };
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[0].length; j++) {
                weights[i][j] *= (1.0 / 16.0);
            }
        Picture gaussian = kernel(picture, weights);
        return gaussian;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                { 0.0, -1.0, 0.0 },
                { -1.0, 5.0, -1.0 },
                { 0.0, -1.0, 0.0 }
        };
        Picture sharpen = kernel(picture, weights);
        return sharpen;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1.0, -1.0, -1.0 },
                { -1.0, 8.0, -1.0 },
                { -1.0, -1.0, -1.0 }
        };
        Picture laplacian = kernel(picture, weights);
        return laplacian;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                { -2.0, -1.0, 0.0 },
                { -1.0, 1.0, 1.0 },
                { 0.0, 1.0, 2.0 }
        };
        Picture emboss = kernel(picture, weights);
        return emboss;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    // TODO This does not add up to one, and returns a darker image
    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 },
                { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 }
        };
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights[0].length; j++) {
                weights[i][j] *= 1.0 / 9.0;
            }
        Picture motionBlur = kernel(picture, weights);
        return motionBlur;
    }

    // Test client
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture picI = identity(picture);
        picI.show();
        Picture picG = gaussian(picture);
        picG.show();
        Picture picS = sharpen(picture);
        picS.show();
        Picture picL = laplacian(picture);
        picL.show();
        Picture picE = emboss(picture);
        picE.show();
        Picture picMB = motionBlur(picture);
        picMB.show();
    }
}
