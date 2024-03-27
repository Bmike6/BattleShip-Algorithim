import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        String s = "";
        Scanner scan = new Scanner(s);
        String[] data = scan.nextLine().split(" ");
        char[][] array = new char[Integer.parseInt(data[1])][Integer.parseInt(data[0])];
        int x=-1, y=-1;
        
        for (int i=0; i<array.length; i++)
        {
            char[] line = scan.nextLine().toCharArray();
            for (int j=0; j<line.length; j++)
            {
                if (line[j]=='@'&&x!=-1)
                {
                    x = j;
                    y = i;
                    array[i][j] = '.';
                    continue;
                }
                array[i][j] = line[j];
            }
            
        }
        mazeSolver(array, x, y);
    }
    
    static void mazeSolver(char[][] array, int x, int y)
    {
        if (x==array[0].length||y==array.length||x<0||y<0||array[y][x]=='#'||array[y][x])
        {
            return;    
        }
        else if (array[y][x]=='@')
        {
            return;
        }
        array
        
        
        
    }
}
