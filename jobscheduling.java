import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jobscheduling {
    public static int getMaxDeadline(List<job> jobs) {
        int md = Integer.MIN_VALUE;
        for (job j : jobs) {
            if (j.getDeadline() > md)
                md = j.getDeadline();
        }
        return md;
    }

    public static void main(String[] args) {
        List<job> jobs = new ArrayList<>();
        jobs.add(new job('A', 2, 100));
        jobs.add(new job('B', 1, 19));
        jobs.add(new job('C', 2, 27));
        jobs.add(new job('D', 1, 25));
        jobs.add(new job('E', 3, 15));

        Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

        int maxdeadline = getMaxDeadline(jobs);
        boolean slot[] = new boolean[maxdeadline];
        char result[] = new char[maxdeadline];
        int res = 0;
        for (job j : jobs) {
            for (int i = j.getDeadline() - 1; i >= 0; i--) {
                if (slot[i] == false) {
                    slot[i] = true;
                    result[i] = j.getId();
                    res = res + j.getProfit();
                    break;
                }
            }
        }

        for (int i = 0; i < maxdeadline; i++) {
            if (slot[i]) {
                System.out.println(result[i]);
            }
        }
        System.out.println("max profit=" + res);
    }
}
