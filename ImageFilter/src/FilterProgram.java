
/**
 * Here we have a main method that loads an image, applies and filter to
 * it and then displays the modified image to the screen
 */
public class FilterProgram
{
    public static void main(String [] args)
    {
        //load the image
        PixImage ml = new PixImage("Bliss.jpg");
        
        ImageFilter pixelated = new PixelatedFilter(10);
        PixImage pixelatedBliss = pixelated.filterImage(ml);
        
        pixelatedBliss.showImage();
        
        ImageFilter Grayscale = new GrayscaleGradient();
        PixImage grayBliss = Grayscale.filterImage(ml);
        
        grayBliss.showImage();
        
        //pixelatedBliss.saveImage("pixelated.png");
    }
}
