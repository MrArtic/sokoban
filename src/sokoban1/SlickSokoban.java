package sokoban1;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SlickSokoban extends BasicGame {
	
	Image wall 			= null;
	Image player		= null;
	Image box 			= null;
	Image box_on_target = null;
	Image target 		= null;
	
	int map_width = 0;
	int map_height = 0;

	public SlickSokoban() {
		super("Sokoban");
	}
	
	public void render_map(){
		wall.draw(400, 0);
		wall.draw(16, 0);
		wall.draw(16, 16);
		player.draw(200, 100);
		box.draw(200, 200);
		box_on_target.draw(200, 300);
		target.draw(200, 400);
		
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		wall = new Image("img/brick16x16.png");
		player = new Image("img/player16x16.png");
		box = new Image("img/redball16x16.png");
		box_on_target = new Image("img/greenball16x16.png");
		target = new Image("img/target16x16.png");
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		render_map();
	}
	
	public static void main(String[] args) throws SlickException{
 
		AppGameContainer app = new AppGameContainer( new SlickSokoban() );
 
		app.setDisplayMode(800, 600, false);
		app.start();
	}
	
	
	
}
