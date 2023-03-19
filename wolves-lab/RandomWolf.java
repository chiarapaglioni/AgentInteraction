import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomWolf implements Wolf {

	@Override
	public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
		Random r = new Random();
		int[] mymove = new int[2];
		mymove[0] = r.nextInt(3)-1;
		mymove[1] = r.nextInt(3)-1;
		// System.out.println(wolvesSight.get(0) + " " + wolvesSight.get(1).toString() + " " + wolvesSight.get(2).toString());
		// System.out.println(wolvesSight.get(0).getClass());
		// System.out.println(wolvesSight.get(0).getClass() + " " + wolvesSight.get(1).getClass() + " " + wolvesSight.get(2).getClass());
		System.out.println(Arrays.toString(wolvesSight.toArray()));
		return mymove;
	}
	
	public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
		Random r = new Random();
		return r.nextInt(4) + 1;
	}
}