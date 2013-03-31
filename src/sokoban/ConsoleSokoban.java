package sokoban1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConsoleSokoban implements KeyListener {
	
	public static void main(String []args){
		
		String level1 = "########|#  #.  #|# $#   #|#  # @##|#  # $##|#    .##|########";
		String level2 = "########|#@ #.  #|# $#   #|#  #  ##|#  # $##|#    .##|########";
		
		Sokoban test = new Sokoban(level2);
		
		while(true){
			
		}
		
//		test.print_map(test.map);
//		test.update_player_location(1, 2);
//		test.print_map(test.map);
//		test.update_player_location(0, 2);
	}

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		if(k.getKeyCode() == k.VK_UP){
			System.out.println("up");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
