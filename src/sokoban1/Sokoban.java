package sokoban1;

public class Sokoban {
	
	public static final char player 			= '@';
	public static final char wall				= '#';
	public static final char target				= '.';
	public static final char player_on_target	= '+';
	public static final char box				= '$';
	public static final char box_on_target		= '*';
	
	private Character[][] map;
	private Character[][] player_location;
	

	protected String string_map;
	
	public int bredde;
	public int hoyde;
	
	public int x_loc = 0;
	public int y_loc = 0;
	
	public Sokoban(String string_map){
		
		this.string_map = string_map;
		
//		map = string_to_map(string_map);
		this.setMap(string_to_map(string_map));
		player_location = new Character[hoyde][bredde]; //make an array for player location
		player_location = getPlayerLocation(); //adds player location to player_location map
	}
	
	//prints the map of characters to terminal
	public void print_map(Character[][] map){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <= map.length; j++) {
				System.out.print(map[i][j]);				
			}
			System.out.println();
		}
	}
	
	//Converts a map from string to char[][]
	public Character[][] string_to_map(String string_map){
		
		String[] rader = string_map.split("\\|");
		
		bredde =rader[0].length();
		hoyde = rader.length;
		
		map = new Character[hoyde][bredde];
		
		for (int i = 0; i < hoyde; i++) {
			for (int j = 0; j < bredde; j++) {
				map[i][j] = rader[i].charAt(j);
			}
		}
		return map;
	}
	
	public Character[][] getPlayerLocation(){
		
		x_loc = 0;
		y_loc = 0;
		
		for (int i = 0; i < hoyde; i++) {
			for (int j = 0; j < bredde; j++) {
				if(map[i][j] == player){
					x_loc = j;
					y_loc = i;
				}
			}
		}
		System.out.println("x:"+x_loc+"y:"+y_loc);
		player_location[y_loc][x_loc] = '@';
		return player_location;
		
	}
	
	public void update_player_location (int x, int y){
		
		if(is_valid_move(x, y)){
			map[y_loc][x_loc] = ' ';
			map[y][x] = player;
			getPlayerLocation();
		}
		
		
	}
	
	public  boolean is_valid_move(int x, int y){
		

		if(map[x][y] == wall){
			System.out.println("Not a valid move!");
			return false;


		}
		
		return true;
	}
	
	public Character[][] getMap() {
		return map;
	}

	public void setMap(Character[][] map) {
		this.map = map;
	}

	public Character[][] getPlayer_location() {
		return player_location;
	}

	public void setPlayer_location(Character[][] player_location) {
		this.player_location = player_location;
	}
	
	//main for testing
//	public static void main (String []args){
//		
//		String level1 = "########|#  #.  #|# $#   #|#  # @##|#  # $##|#    .##|########";
//		String level2 = "########|#@ #.  #|# $#   #|#  #  ##|#  # $##|#    .##|########";
//		
//		Sokoban test = new Sokoban(level2);
//		
//		test.print_map(test.map);
//		test.getPlayerLocation();
//		test.update_player_location(1, 2);
//		test.print_map(test.map);
//		test.getPlayerLocation();
//		
//	}
}

//public static Character[][] testmap = {
//{'#', '#', '#', '#', '#'},
//{'#', '@', ' ', ' ', '#'},
//{'#', ' ', ' ', ' ', '#'},
//{'#', ' ', ' ', ' ', '#'},
//{'#', '#', '#', '#', '#'},
//};
