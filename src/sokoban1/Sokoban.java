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
	
	private int bredde;
	private int hoyde;
	
	private int x_loc = 0;

	private int y_loc = 0;
	
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
	
	public void update_player_location (int x, int y){ // x, y is new coordinates
		
		if(is_valid_move(x, y) ){
			
			if(map[y][x] == box){//check if box is on coordinates
				
				//move box south
				if(y_loc+1 == y){
					if((y_loc+1 == y)&&!(is_valid_move(x, y+1)))return; //checks if moving box beyond wall
					map[y_loc][x_loc] = ' ';
					map[y+1][x] = box;
					map[y][x] = player;
					getPlayerLocation();
					return;
				}
				
				//move box north
				if(y_loc-1 == y){
					if((y_loc-1 == y)&&!(is_valid_move(x, y-1)))return;
					map[y_loc][x_loc] = ' ';
					map[y-1][x] = box;
					map[y][x] = player;
					getPlayerLocation();
					return;
				}
				
				//move box west
				if(x_loc-1 == x){
					if((x_loc-1 == x)&&!(is_valid_move(x-1, y)))return;
					map[y_loc][x_loc] = ' ';
					map[y][x-1] = box;
					map[y][x] = player;
					getPlayerLocation();
					return;
				}
				
				//move box east
				if(x_loc+1 == x){
					if((x_loc+1 == x)&&!(is_valid_move(x+1, y)))return;
					map[y_loc][x_loc] = ' ';
					map[y][x+1] = box;
					map[y][x] = player;
					getPlayerLocation();
					return;
				}
				
				
				
			}
			
			//regular move
			map[y_loc][x_loc] = ' ';
			map[y][x] = player;
			getPlayerLocation();
		}
		
		
	}
	
	public  boolean is_valid_move(int x, int y){
		

		if(map[y][x] == wall){
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

	public int getBredde() {
		return bredde;
	}

	public void setBredde(int bredde) {
		this.bredde = bredde;
	}

	public int getHoyde() {
		return hoyde;
	}

	public void setHoyde(int hoyde) {
		this.hoyde = hoyde;
	}

	public int getX_loc() {
		return x_loc;
	}

	public void setX_loc(int x_loc) {
		this.x_loc = x_loc;
	}

	public int getY_loc() {
		return y_loc;
	}

	public void setY_loc(int y_loc) {
		this.y_loc = y_loc;
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
