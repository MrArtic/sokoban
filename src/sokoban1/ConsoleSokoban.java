package sokoban1;

public class ConsoleSokoban  {
	
	public static void main(String []args){
		
		String level1 = "########|#  #.  #|# $#   #|#  # @##|#  # $##|#    .##|########";
		String level2 = "########|#@ #.  #|# $#   #|#  #  ##|#  # $##|#    .##|########";
		
		Sokoban test = new Sokoban(level2);
		

		
		test.print_map(test.getMap());
		test.update_player_location(1, 2);
		test.print_map(test.getMap());
		test.update_player_location(0, 2);
	}

}
