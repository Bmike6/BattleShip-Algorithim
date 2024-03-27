import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        String s = "....C.....\n....C.....\n....C.....\n....C.....\n....CBBBB.\n..DDDS....\n.....S....\n.....S....\nP.........\nP.........\nA1 A10 J10 J1 I1 E5 E4 E6 F6 G6 H6 F5 F4 F3";
        char[][] array = new char[10][10];
        Map<Character, boats> mappedValues = new HashMap<Character, boats>();
        String[] inputValues;
        mappedValues.put('C', new boats("carrier", 5));
        mappedValues.put('B', new boats("battleship", 4));
        mappedValues.put('D', new boats("destroyer", 3));
        mappedValues.put('S', new boats("submarine", 3));
        mappedValues.put('P', new boats("patrol boat", 2));
        
        Scanner scan = new Scanner(s);
        
        for (int i=0; i<10; i++)
        {
            array[i] = scan.nextLine().toCharArray();    
        }
        inputValues = scan.nextLine().split(" ");
        
        for (int i=0; i<inputValues.length; i++)
        {
            int y = (int)(inputValues[i].charAt(0))-65;
            int x = Integer.parseInt(inputValues[i].substring(1));
            
            if (mappedValues.containsKey(array[y][x-1]))
            {
                if (!morePieces(x-1, y, array[y][x-1], array))
                {
                    System.out.println(inputValues[i]+" destroyed my "+mappedValues.get(array[y][x-1]).name);
                }
                else
                {
                    System.out.println(inputValues[i]+" is a hit");
                }
                array[y][x-1] = 'X';
                
            }
            else
            {
                System.out.println(inputValues[i]+" missed");
            }
            
        }
    }
    static boolean morePieces(int x, int y, char lookingFor, char[][] array)
    {
        for (int i=0; i<array.length; i++)
        {
            for (int j=0; j<array[i].length; j++)
            {
                if (array[i][j]==lookingFor&&i!=y||array[i][j]==lookingFor&&j!=x)
                {
                    return true;   
                }
            }
            
        }
        return false;
    }
}

class boats
{
    String name;
    int health;
    
    public boats(String name, int health)
    {
        this.name = name;
        this.health = health;
    }
    
}
