public class CheckerboardFilter extends ImageFilter
{
    private int redAmount;
    private int greenAmount;
    //private int blueAmount;
    
    public CheckerboardFilter()
    {
        this.redAmount = 250;
        this.greenAmount = 250;
        //this.blueAmount = 250;
    }
    
    public PixImage filterImage(PixImage image)
    {
        PixImage copy = new PixImage(image);
        
        for (int i = 0; i < copy.height; i++)
        { 
            for (int j = 0; j < copy.width; j++)
            {
            	if ((i / 100 + j / 100) % 2 == 0) {
            		copy.red[i][j] = redAmount;
            	}
            	/*else if ((i / 10 + j / 10) % 3 == 0) {
            		copy.blue[i][j] = blueAmount;
            	}*/
            	else {
                	copy.green[i][j] = greenAmount;
                }
            }
        }
        return copy;
    }
}
