import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import edu.berlin.htw.ds.cg.helper.InteractiveItem;

public class Fork implements InteractiveItem{
	private static int height = 640, width = 800;
	
	// Gestaenge
	public Fork(float pitch, float yaw, float height, float width, Fork leftChild, Fork rightChild) {
		
	}
	
	// Kugel
	public Fork() {
		
	}
	
	public void run() {
		setup();
		
		while(!end()) {
			update();
			render();
			
			Display.update();
//			Display.sync(60);
		}
		
		finish();
	}
	
	public boolean end() {
		boolean end = Display.isCloseRequested();
		end |= Keyboard.isKeyDown(Keyboard.KEY_ESCAPE);
		return end;
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		}
		catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		GL11.glClearColor(0.3f, 0.3f, 0.3f, 0.0f);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(45.f, (float)width / (float)height, 0.1f, 3000.f);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Display.setTitle("Mobile");
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
		//clean the screen
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		//camera
		GLU.gluLookAt(0, 0, -3000, 0, 0, 0, 0 ,1 ,0);
	}

	@Override
	public void finish() {
		Display.destroy();
	}

}
