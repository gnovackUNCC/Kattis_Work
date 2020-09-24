import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] backRowPrices = new int[n];
        int[] backRowSize = new int[n];
        int[] frontRowPrices = new int[n];
        int[] frontRowSize = new int[n];
        int[][] rows = {backRowPrices, backRowSize, frontRowPrices, frontRowSize};

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < n; j++){
                rows[i][j] = scan.nextInt();
            }
        }
        List<Tile> backTiles = new ArrayList<>(n);
        List<Tile> frontTiles = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            backTiles.set(i, new Tile(backRowPrices[i], backRowSize[i]));
        }
        for(int i = 0; i < n; i++){
            frontTiles.set(i, new Tile(frontRowPrices[i], frontRowSize[i]));
        }
    }
}
