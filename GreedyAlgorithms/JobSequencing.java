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
        Collections.sort(jobList, (job1, job2) -> {
            int comparedValue = job2.profit - job1.profit;

            if(comparedValue == 0) {
                comparedValue = job2.deadline - job1.deadline;
            }

            return comparedValue;
        });

        //System.out.println(jobList);
    }

    private void solve(List<Job> jobList) {
        int n = jobList.size();
        int requiredTimeSlots = 0;

        for (int i = 0; i < n; i++) {
            requiredTimeSlots = Math.max(requiredTimeSlots, jobList.get(i).deadline);
        }

        boolean freeTimeSlots[] = new boolean[requiredTimeSlots];
        char jobSequence[] = new char[requiredTimeSlots];
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobList.get(i).deadline - 1; j >= 0; j--) {
                if (!freeTimeSlots[j]) {
                    freeTimeSlots[j] = true;
                    jobSequence[j] = jobList.get(i).jobId;
                    totalProfit += jobList.get(i).profit;
                    break;
                }
            }
        }

        System.out.println("Job Sequence: ");
        for (int i = 0; i < requiredTimeSlots; i++) {
            System.out.print(jobSequence[i] + " ");
        }
        System.out.println();
        System.out.println("Total Profit: " + totalProfit);
    }

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
        jobSequencing.solve(jobList);
    }
}
