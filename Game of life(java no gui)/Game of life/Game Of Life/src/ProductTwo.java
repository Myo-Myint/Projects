
public class ProductTwo {

	int rows;
	int cols;
	int [][] board;//int [][] board = new int[5][5];
	//int [][] board = {
	// 	{............}
	// 	{..............}
	// 	{.........}
	// }
	
	public ProductTwo(int rows,int cols) {
		this.rows = rows;
		this.cols = cols ;
		this.board = new int[rows][cols];
	}
	
	public void printBoard() {
		System.out.println("_________________");
		System.out.println();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (this.board[r][c]==0) {
					System.out.print(". ");
				} else if(this.board[r][c]==1) {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println("_________________");
	}
	
	public void setAlive(int r,int c) {
		this.board[r][c]= 1;
	}
	
	public void setDead(int r,int c) {
		this.board[r][c]= 0;
	}
	
	
	public int countAliveNeighbours(int r,int c) {
		int count = 0 ;
		
		count += getState (r-1,c-1);
		count += getState (r-1,c);
		count += getState (r-1,c+1);
		
		count += getState (r,c-1);
		count += getState (r,c+1);
		
		count += getState (r+1,c-1);
		count += getState (r+1,c);
		count += getState (r+1,c+1);
		
		return count;
	}
	
	public int getState (int r, int c) {
		if (c<0 || c >= cols) {
			return 0;
		}
		if (r<0 || r >= rows) {
			return 0;
		}
		return this.board[r][c];
	}
	
	public void step() {
		int [][] newBoard = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int aliveNeighbours = countAliveNeighbours(r,c);
				
				if (getState(r, c) == 1) {
					if(aliveNeighbours<2) {
						newBoard[r][c]=0;
					}else if (aliveNeighbours ==2 || aliveNeighbours == 3) {
						newBoard[r][c] = 1 ;
					}else if( aliveNeighbours >3  ) {
						newBoard[r][c] = 0;
					}
				} else {
					if(aliveNeighbours == 3) {
						newBoard[r][c] = 1 ;
					}
				}
			}
		}	
		this.board = newBoard;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductTwo product = new ProductTwo(5,5);
		
		product.setAlive(2, 2);
		product.setAlive(3, 2);
		product.setAlive(2, 4);
		product.setAlive(1, 4);
		product.setAlive(4, 2);
		product.setAlive(0, 1);
		product.setAlive(1, 3);
		
		product.printBoard();
		
		product.step();
		
        product.printBoard();
		
		product.step();
		
        product.printBoard();
		
		product.step();
	}

}
