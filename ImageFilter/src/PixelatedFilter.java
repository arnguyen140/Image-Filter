public class PixelatedFilter extends ImageFilter {
	private int blocksize;
	
	public PixelatedFilter(int blocksize) {
		this.blocksize = blocksize;
	}
	
	public void Pixlateblock(PixImage image, int start, int start2) {
		
		int redSum = 0;
        int blueSum = 0;
        int greenSum = 0;
        int sum = 0;
        
		for (int i = start; i < blocksize + start && i < image.height; i++) {
            for (int j = start2; j < blocksize + start2 && j < image.width; j++)
            {
            	redSum += image.red[i][j];
            	blueSum += image.blue[i][j];
            	greenSum += image.green[i][j];
            	sum++;
            }
        }
		
		for (int i = start; i < blocksize + start && i < image.height; i++) {
            for (int j = start2; j < blocksize + start2 && j < image.width; j++)
            {
            	image.red[i][j] = redSum / sum;
            	image.blue[i][j] = blueSum / sum;
            	image.green[i][j] = greenSum / sum;
            }
		}
	}
	
	public PixImage filterImage(PixImage image) {
	
        PixImage copy = new PixImage(image);
        
        for (int i = 0; i < copy.height; i += blocksize)
        {
            for (int j = 0; j < copy.width; j += blocksize) {
            	Pixlateblock(copy,i,j);
            }
        }
        return copy;
    }
}
