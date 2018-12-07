import java.io.*; 
import java.util.*; 
public class Peg_Puzzle
{
	public static int moves[][] = new int[][]{
		{0,1,3},{3,1,0},
		{0,2,5},{5,2,0},
		{1,3,6},{6,3,1},
		{1,4,8},{8,4,1},
		{2,4,7},{7,4,2},
		{3,4,5},{5,4,3},
		{2,5,9},{9,5,2},
		{3,6,10},{10,6,3},
		{3,7,12},{12,7,3},
		{4,7,11},{11,7,4},
		{6,7,8},{8,7,6},
		{4,8,13},{13,8,4},
		{5,8,12},{12,8,5},
		{7,8,9},{9,8,7},
		{5,9,14},{14,9,5},
		{10,11,12},{12,11,10},
		{11,12,13},{13,12,11},
		{12,13,14},{14,13,12}
	};
	
	public static ArrayList<Integer> sol = new ArrayList<Integer>(); 
	
	public static int[] board = new int[15];
	
	public static ArrayList<Integer> solve(int[] board, int numoc)
	{
		int[] cboard = new int[15];
		for(int n=0;n<board.length;n++)
		{
			cboard[n]=board[n];
		}
		ArrayList<Integer> step = new ArrayList<Integer>();
		int ocu=0;
		for(int num:cboard)
		{
			if(num==1)
			{
			    ocu++;
			}
		}
		if(ocu==1)
		{	
			step.add(100);
			return step;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>(); 
		int k=0;
		for(int[] x:moves)
		{
			if(cboard[x[0]]==1 && cboard[x[1]] == 1 && cboard[x[2]] == 0)
			{
				cboard[x[0]] = 0;
				cboard[x[1]] = 0;
				cboard[x[2]] = 1;
				step.add(k);
				tmp = solve(cboard,(numoc-1));
				if(tmp.isEmpty())
				{	
					if(step.size()>=1){step.remove((step.size()-1));}
					cboard[x[0]] = 1;
					cboard[x[1]] = 1;
					cboard[x[2]] = 0;
				}
				else
				{
					if(tmp.size()>=1 && tmp.get(tmp.size()-1)==100){tmp.remove((tmp.size()-1));}
					for(int d=0;d<tmp.size();d++)
					{
						step.add(tmp.get(d));
					}
					tmp.clear();
					return step;
				}

			}
			k++;
		}
		step.clear();
		return step;
	}
	public static void re(int[] bar, ArrayList<Integer> st)
	{
		int f,o,t;
		display(bar);
		for(int num:st)
		{
			f = moves[num][0];
			o = moves[num][1];
			t = moves[num][2];
			bar[f] = 0;
			bar[o] = 0;
			bar[t] = 1;
			display(bar);

		}
	}
	public static void main(String[] args)
	{
			for(int l=0;l<Peg_Puzzle.board.length;l++)
			{
				Peg_Puzzle.board[l] = 1;
			}
		
			Peg_Puzzle.board[0] = 0;
			int[] cboard = new int[15];
			for(int n=0;n<Peg_Puzzle.board.length;n++)
			{
				cboard[n]=board[n];
			}
			Peg_Puzzle.sol = solve(cboard,14);
			re(Peg_Puzzle.board,Peg_Puzzle.sol);
		
	}
	public static void display(int[] boardd)
	{
		System.out.println("     "+boardd[0]);
		System.out.println("    "+boardd[1]+" "+boardd[2]);
		System.out.println("   "+boardd[3]+" "+boardd[4]+" "+boardd[5]);
		System.out.println("  "+boardd[6]+" "+boardd[7]+" "+boardd[8]+" "+boardd[9]);
		System.out.println(" "+boardd[10]+" "+boardd[11]+" "+boardd[12]+" "+boardd[13]+" "+boardd[14]);
	}
} 
