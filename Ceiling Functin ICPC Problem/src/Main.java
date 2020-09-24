import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numTrees = scan.nextInt();
        int numPerTree = scan.nextInt();

        TreeNode[] trees = new TreeNode[numTrees];

        for(int i = 0; i < numTrees; i++){
            trees[i] = new TreeNode(scan.nextInt());
            for(int j = 0; j < numPerTree - 1; j++){
                trees[i].add(scan.nextInt());
            }
        }
        int uniqueTreeCount = trees.length;
        //boolean allMatch = true;
        for(int i = 0; i < numTrees; i++){
            //boolean matchAny = false;

            for(int j = i + 1; j < numTrees; j++){
                if(checkShape(trees[i], trees[j])) {
                    uniqueTreeCount--;
                    break;
                }
                /*else
                    allMatch = false;*/
            }
            //if(!matchAny) uniqueTreeCount--;
        }
        if(uniqueTreeCount == 0)
            uniqueTreeCount++;
        //if(allMatch) uniqueTreeCount++;
        System.out.println(uniqueTreeCount);
    }
    public static boolean checkShape(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null){
            if(t1 == null && t2 == null)
                return true;
            return false;
        }
        if(!t1.equals(t2))
            return false;

        return checkShape(t1.left, t2.left) && checkShape(t1.right, t2.right);
    }
}
