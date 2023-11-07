public class GrayscaleGradient extends ImageFilter
{ 
    public PixImage filterImage(PixImage image)
    {
        PixImage copy = new PixImage(image);
        
        for (int i = 0; i < copy.height; i++)
        { 
            for (int j = 0; j < copy.width; j++)
            {
            	double percentage = (double) j / copy.width;
            	
            	int red = (int) (0.299 * copy.red[i][j]); 
            	int green = (int) (0.587 * copy.green[i][j]); 
            	int blue = (int) (0.114 * copy.blue[i][j]);
            	int grayscale = red + green + blue;
            	
            	copy.red[i][j] = (int) ((percentage) * grayscale + (1 - percentage) * copy.red[i][j]);
            	copy.green[i][j] = (int) ((percentage) * grayscale + (1 - percentage) * copy.green[i][j]);
            	copy.blue[i][j] = (int) ((percentage) * grayscale + (1 - percentage) * copy.blue[i][j]);
            }
        }
        return copy;
    }
}