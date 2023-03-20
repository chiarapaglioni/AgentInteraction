import java.util.List;
import java.util.Random;

public class SmartWolf implements Wolf {

    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {

        int[] mymove = new int[2];
        // int[][] moves = {{1, -1}, {0, 0}, {0, 0}, {-1, 1}};

        // Check if there are any wolves in sight (If there are no wolves, do a random move)
        if(!wolvesSight.isEmpty()){

            // Move in the direction of the closest wolf
            for(int i = 0; i < wolvesSight.size(); i++) {
                System.out.print("Wolf " + i + " ");
                print_moves(wolvesSight.get(i));
                System.out.println();
                mymove[0] = get_opposite_direction(wolvesSight.get(i)[0]);
                mymove[1] = get_opposite_direction(wolvesSight.get(i)[1]);
            }

            // Check if there are any preys in sight
            // If there is a prey move towards it in the x-axis (only update one of the axis to mov towards the preys!)
            if(!preysSight.isEmpty()) {

                // Move in the direction of the closest wolf
                for (int i = 0; i < preysSight.size(); i++) {
                    System.out.print("Prey " + i + " ");
                    print_moves(preysSight.get(i));
                    System.out.println();
                    //mymove[0] = get_direction(preysSight.get(i)[0]);
                    mymove[1] = get_opposite_direction(preysSight.get(i)[1]);
                }
            }


        // TODO: If the wolves are too close just do random move because they will overlap
        // Otherwise, follow the wolves (go either left (-1) or right (1) based on the direction of the wolf to follow)
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

    // Get the direction of the wolf in sight
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

    // UNUSED!!!
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}