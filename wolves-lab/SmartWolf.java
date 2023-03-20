import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SmartWolf implements Wolf {

    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {

        int[] mymove = new int[2];
        int[] wolfDirection = new int[wolvesSight.size()];
        int[] preyDirection = new int[preysSight.size()];
        int[][] moves = {{1, -1}, {0, 0}, {0, 0}, {-1, 1}};

        // Check if there are any wolves in sight (If there are no wolves, do a random move)
        if(!wolvesSight.isEmpty()){

            // Move in the direction of the closest wolf
            for(int i = 0; i < wolvesSight.size(); i++) {
                //wolfDirection[i] = get_direction(wolvesSight.get(i));
                System.out.print("Wolf " + i + " ");
                print_moves(wolvesSight.get(i));
                System.out.println();
                mymove[0] = get_direction(wolvesSight.get(i)[0]);
                mymove[1] = get_direction(wolvesSight.get(i)[1]);
            }

            // Check if there are any preys in sight (If there are no wolves, do a random move)
            if (!preysSight.isEmpty()){

                for(int i = 0; i < preysSight.size(); i++) {
                    //preyDirection[i] = get_direction(preysSight.get(i));
                    System.out.print("Prey " + i + " ");
                    print_moves(preysSight.get(i));
                    System.out.println();
                    mymove[0] = get_direction(preysSight.get(i)[0]);
                    mymove[1] = get_direction(preysSight.get(i)[1]);
                }

            } else {
                mymove = randomMove();
            }
        } else {
            mymove = randomMove();
        }
        // If the wolves are too close just do random move because they will overlap
        // Otherwise, follow the wolves (go either left (-1) or right (1) based on the direction of the wolf to follow)
        return mymove;
    }


    // Returns a random move for the wolf
    public int[] randomMove() {
        Random r = new Random();
        int[] mymove = new int[2];
        mymove[0] = r.nextInt(3)-1;
        mymove[1] = r.nextInt(3)-1;
        return mymove;
    }

    // Get the direction of the wolf in sight
    // move[0] --> UP = -1, DOWN = 1 --> X-axis
    // move[1] --> LEFT = -1, RIGHT = 1 --> Y-axis
    public int get_direction(int position) {
        int dir = 0;
        if (position < -1){
            dir = 1;
        } else if (position > 1){
            dir = -1;
        }
        return dir;
    }

    public void print_moves(int[] moves) {
        System.out.print("Moves: ");
        for (int i = 0; i < moves.length; i++) {
            System.out.print(moves[i] + " ");
        }
    }


    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        int intArray = 0;
        return intArray;
    }
}