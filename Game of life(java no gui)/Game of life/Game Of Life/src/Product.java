
public class Product {

//width is col
//height is row	
	
	int width;
	int height;
	static int [][] board;
	
	//constructor
	public Product(int width,int height) {
		this.width = width;
		this.height = height;
		Product.board = new int[width][height];
		printBoard();
		
	}
	
	public void printBoard() {
		System.out.println("___________________");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (Product.board[x][y] == 0) {
					System.out.print("- ");
				} else {
					System.out.print("* ");    
				}
			}
			System.out.println();
		}
		System.out.println("____________________");
	}
	
	public static void setAliveCell(int x,int y) {
		Product.board[x][y]=1;
	
	}
	
	public static void setDeadCell(int x,int y) {
		board[x][y]=0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		new Product(10,10);
		setAliveCell(2,4);
		setAliveCell(4,4);
		setAliveCell(3,4);
		setAliveCell(7,9);
		
	}

}
