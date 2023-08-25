import java.util.*;
public class nqueens {

    public static  void saveBoard(char board[][],List<List<String>> allBoards)
    {
        String row="";
        List<String> newBoard=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            row="";
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]=='Q')
                    row+="Q";
                else
                    row+=".";
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public static boolean isSafe(int row,int col,char board[][])
    {
        for(int j=0;j<board.length;j++)//horizontal
            if(board[row][j]=='Q')
                return false;
         for(int i=0;i<board.length;i++)//vertical
            if(board[i][col]=='Q')
                return false;
        int r=row;
        for(int c=col;r>=0&&c>=0;r--,c--)//leftupperdiagonal
            if(board[r][c]=='Q')
                return false;
        r=row;
        for(int c=col;r<board.length&&c<board.length;r++,c++)//rigtlowerdiagonal
            if(board[r][c]=='Q')
                return false;
        r=row;
        for(int c=col;r<board.length&&c>=0;r++,c--)//leftlowerdiagonal
            if(board[r][c]=='Q')
                return false;
        r=row;
        for(int c=col;c<board.length&&r>=0;r--,c++)//rightupperdiagonal
            if(board[r][c]=='Q')
                return false;
        return true;

    }
    public static void helper(char board[][],List<List<String>> allBoards,int col)
    {
        if(col==board.length)
        {
            saveBoard(board,allBoards);
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(isSafe(row,col,board))
            {
                board[row][col]='Q';
                helper(board, allBoards, col+1);
                board[row][col]='.';
            }
        }

    }
    public static void main(String[] args) {
        int n=4;
        List<List<String>> allBoards=new ArrayList<>();
        char board[][]=new char[n][n];
        helper(board, allBoards, 0);
        for (List<String> list : allBoards) {
            for(String s:list)
                 System.out.println(s);
        }
    }
}
