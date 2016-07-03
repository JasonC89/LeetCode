package leetcode.common.Fourth100;

import java.util.*;

/**
 * Created by hchang on 6/30/16.
 * Design Snake Game
 *
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class Solution353 {
    private int score = 0;
    private Deque<Integer> snake;
    private Set<Integer> set;
    private int width;
    private int height;
    private List<int[]> food;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public Solution353(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        set = new HashSet();
        this.width = width;
        this.height = height;
        this.food = new ArrayList<>();
        for (int[] f : food) {
            this.food.add(f);
        }
        set.add(0);
        snake.offerLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        //case 0: game already over: do nothing
        if (score == -1) {
            return -1;
        }

        // compute new head
        int rowHead = snake.peekFirst() / width;
        int colHead = snake.peekFirst() % width;
        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default :  colHead++;
        }
        int head = rowHead * width + colHead;
        set.remove(snake.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        snake.offerFirst(head);
        if (!this.food.isEmpty() && rowHead == food.get(0)[0] && colHead == food.get(0)[1]) {
            set.add(snake.peekLast());
            this.food.remove(0);
            return ++score;
        }
        snake.pollLast();
        return score;
    }
}
