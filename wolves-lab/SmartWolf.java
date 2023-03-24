import java.util.List;
import java.util.Random;

public class SmartWolf implements Wolf {

    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {

        int[] mymove = new int[2];

        // Check if there are any wolves in sight (If there are no wolves, do a random move)
        if(!wolvesSight.isEmpty()){

            // Move in the direction of the closest wolf
            for (int[] wolf : wolvesSight) {
                mymove[0] = get_opposite_direction(wolf[0]);
                mymove[1] = get_opposite_direction(wolf[1]);
            }

            // Check if there are any preys in sight
            // If there is a prey move towards it in the X-axis
            if(!preysSight.isEmpty()) {

                // Move in the direction of the closest prey
                for (int[] prey : preysSight) {
                    mymove[1] = get_opposite_direction(prey[1]);
                }
            }

        } else {
            mymove = randomMove();
        }
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

    // Get the opposite direction of the agent in sight to move towards it
    // move[0] --> UP = -1, DOWN = 1 --> Y-axis
    // move[1] --> LEFT = -1, RIGHT = 1 --> X-axis
    public int get_opposite_direction(int position) {
        if (position < -1){
            return 1;
        } else {
            return -1;
        }
    }

    public void print_moves(int[] moves) {
        System.out.print("Moves: ");
        for (int move : moves) {
            System.out.print(move + " ");
        }
    }

    // UNUSED
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}