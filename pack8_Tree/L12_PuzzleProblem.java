package pack8_Tree;

import pack8_Tree.code2.Puzzle8_651320;
import pack8_Tree.code2.Puzzle8State;

public class L12_PuzzleProblem {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        Puzzle8_651320 game = new Puzzle8_651320(
                new int[] { 9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2 });
        game.displayBoard();
    }
}
