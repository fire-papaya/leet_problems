package medium;

import java.util.ArrayDeque;

public class CountCollision {
    public int countCollisions(String directions) {
        // brute force: go through the string in the loop
        // every time the accident is found, increase counter, replace moving cars with S
        // repeat until new changes are done i.e. counter remains unchanged

        var stack = new ArrayDeque<Character>();
        var count = 0;

        if (directions.length() == 1) return 0;

        stack.push(directions.charAt(0));

        for (char direction : directions.toCharArray()) {
            count = checkInsert(stack, direction, count);
        }

        return count;
    }

    int checkInsert(ArrayDeque<Character> stack, Character direction, Integer count) {
        var collision = stack.isEmpty() ? 0 : isCollision(stack.peekLast(), direction);
        var newCount = count + collision;

        if (collision > 0) {
            stack.pollLast();
            newCount += checkInsert(stack, 'S', newCount);
        } else {
            stack.offerLast(direction);
        }

        return newCount;
    }

    int isCollision(Character left, Character right) {
        if (left == 'R') {
            if (right == 'L') {
                return 2;
            }
            else if (right == 'R') {
                return 0;
            }
            else if (right == 'S') {
                return 1;
            }
        }
        else if (left == 'S') {
            if (right == 'L') {
                return 1;
            }
            else return 0; // S-R and S-S no collision
        }

        return 0; // left L, can collide with anything
    }
}
