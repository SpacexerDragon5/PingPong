import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite implements Commons {

    private int dx = 0;
    public int movingAxis; // 0 for x-axis and 1 for y-axis
    private int colour;

    public Paddle (int axis, float initX, float initY, int colour) {

        movingAxis = axis;
        setColor(colour);

        x = initX;
        y = initY;
    }
    
    public void setColor(int colour){
    	this.colour = colour;
    	makeSmall();
    }
    
    public void makeBig(){

    	String PaddleImagePath = "/res/Paddles/";
    	if (movingAxis == 0)
    		PaddleImagePath += ("HBpaddle" + Integer.toString(colour) + ".png");
    	else
    		PaddleImagePath += ("VBpaddle" + Integer.toString(colour) + ".png");

    	ImageIcon ii = new ImageIcon(getClass().getResource(PaddleImagePath));
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);    	
    }
    
    public void makeSmall(){

    	String PaddleImagePath = "/res/Paddles/";
    	if (movingAxis == 0)
    		PaddleImagePath += ("HSpaddle" + Integer.toString(colour) + ".png");
    	else
    		PaddleImagePath += ("VSpaddle" + Integer.toString(colour) + ".png");

    	ImageIcon ii = new ImageIcon(getClass().getResource(PaddleImagePath));
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);    	
    }

    public void move() {

    	if (movingAxis == 0){
    		x += dx;

	        if (x <= BORDER + SIZE + 2) {
	            x = BORDER + SIZE + 2;
	        } else if (x >= WIDTH - i_width - BORDER - SIZE - 2) {
	            x = WIDTH - i_width - BORDER - SIZE - 2;
	        }
    	} else {
    		y += dx;
    		
	        if (y <= BORDER + SIZE + 2) {
	            y = BORDER + SIZE + 2;
	        } else if (y >= HEIGHT - i_heigth - BORDER - SIZE - 2) {
	            y = HEIGHT - i_heigth - BORDER - SIZE - 2;
	        }
    	}
    }

    public void keyPressed(int key) {

        if (key == KeyEvent.VK_LEFT) {
            dx = -PADDLE_STEP;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = PADDLE_STEP;
        }
    }

    public void keyReleased(int key) {

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
   
    public int getPosition(){

    	if (movingAxis==0)
    		return (int) x;
    	else
    		return (int) y;
    }
    
    public void setPosition(int position){
    	
    	if (movingAxis==0)
    		setX(position);
    	else
    		setY(position);
    }
    
    public int getAxis() {
    	return movingAxis;
    }
    
    public Rectangle getVibeRectangle(){
    	return new Rectangle(Math.round(x) - AURA, Math.round(y) - AURA, i_width + 2*AURA, i_heigth + 2*AURA);
    }
}