package GreedyAlgorithms;

import java.util.*;

class Job {
    char jobId;
    int deadline;
    int profit;

    Job(char jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}

public class JobSequencing {
    private void sortDataOnBasisOfProfitArray(List<Job> jobList) {
        Collections.sort(jobList, (job1, job2) -> job2.profit - job1.profit);

        System.out.println(jobList);
    }

    /*
    private void solve(List<Job> jobList) {
        int n = deadline.length;
        int requiredTimeSlots = 0;

        for(int i = 0; i < n; i++) {
            requiredTimeSlots = Math.max(requiredTimeSlots, deadline[i]);
        }

        boolean freeTimeSlots[] = new boolean[requiredTimeSlots];
        int jobSequence[] = new int[requiredTimeSlots];
        int totalProfit = 0;

        for(int i = 0; i < n; i++) {
            for(int j = deadline[i] - 1; j >= 0; j--) {
                if(!freeTimeSlots[j]) {
                    freeTimeSlots[j] = true;
                    jobSequence[j] = i;
                    totalProfit += profit[i];
                    break;
                }
            }
        }

        System.out.println("Job Sequence: ");
        for(int i = 0; i < requiredTimeSlots; i++) {
            System.out.print(jobSequence[i] + " ");
        }
        System.out.println();
        System.out.println("Total Profit: " + totalProfit);
    }
     */

    public static void main(String[] args) {
        JobSequencing jobSequencing = new JobSequencing();

        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job('A', 2, 100));
        jobList.add(new Job('B', 1, 19));
        jobList.add(new Job('C', 2, 27));
        jobList.add(new Job('D', 1, 25));
        jobList.add(new Job('E', 3, 15));
        jobList.add(new Job('F', 4, 100));

        jobSequencing.sortDataOnBasisOfProfitArray(jobList);
        //jobSequencing.solve(jobList);
    }
}
