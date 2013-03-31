package sokoban1;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SlickSokoban extends BasicGame {
	
	Image wall 			= null;
	Image player		= null;
	Image box 			= null;
	Image box_on_target = null;
	Image target 		= null;
	Image cobble			= null;
	Image player_on_target = null;
	
	int map_width = 0;
	int map_height = 0;
	
	String level2 = "########|#@ #.  #|# $#   #|#  #  *#|#  # $##|#    .##|########";
	Sokoban game;

	public SlickSokoban() {
		super("Sokoban");
	}
	
	public void render_map(){
		
		map_width = game.getBredde()*16;
		map_height = game.getHoyde()*16;
		
		Character[][] char_map = game.getMap();
		
		int x = 200;
		int y = 200;
		
		for (int i = 0; i < game.getHoyde(); i++) {
			for (int j = 0; j < game.getBredde(); j++) {
				if(char_map[i][j]== '#'){
					wall.draw(x, y);
					x += 16;
				}
				
				if(char_map[i][j]== '@'){
					player.draw(x, y);
					x += 16;
				}
				if(char_map[i][j]== '+'){
					player_on_target.draw(x, y);
					x += 16;
				}
				
				if(char_map[i][j]== '*'){
					box_on_target.draw(x, y);
					x += 16;
				}
				
				if(char_map[i][j] == '$'){
					box.draw(x, y);
					x += 16;	
				}
				if(char_map[i][j] == ' '){
					cobble.draw(x, y);
					x += 16;	
				}
				if(char_map[i][j] == '.'){
					target.draw(x, y);
					x += 16;	
				}
			}
			x = 200;
			y+= 16;
		}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		game = new Sokoban(level2);
		
		wall = new Image("img/brick16x16.png");
		player = new Image("img/player16x16.png");
		player_on_target = new Image("img/player16x16.png"); 
		box = new Image("img/redball16x16.png");
		box_on_target = new Image("img/greenball16x16.png");
		target = new Image("img/target16x16.png");
		cobble = new Image("img/cobble16x16.png");
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		Input input = gc.getInput();
		
		if(input.isKeyPressed(input.KEY_W)){
			game.update_player_location(game.getX_loc(), game.getY_loc()-1);
		}
		
		if(input.isKeyPressed(input.KEY_A)){
			game.update_player_location(game.getX_loc()-1, game.getY_loc());
		}
		
		if(input.isKeyPressed(input.KEY_S)){
			game.update_player_location(game.getX_loc(), game.getY_loc()+1);
			
		}
		
		if(input.isKeyPressed(input.KEY_D)){
			game.update_player_location(game.getX_loc()+1, game.getY_loc());
		}
		
		
	
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
