package y2022.m01d02;

import java.util.*;

public class 디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c1 = Integer.compare(o1[0], o2[0]);
                if(c1 ==0) return Integer.compare(o1[1], o2[1]);
                else return c1;
            }
        });
        Queue<Job> wait = new LinkedList<>();
        for (int [] j: jobs) wait.add(new Job(j[0], j[1]));
        PriorityQueue<Job> queue = new PriorityQueue<>();
       // queue.add(new Job(jobs[0][0], jobs[0][1]));
        int currentTime = 0;
        while (!wait.isEmpty() || !queue.isEmpty()){
            while (!wait.isEmpty() && currentTime >= wait.peek().startTime){
                queue.add(wait.poll());
            }

            if (!queue.isEmpty()){
                Job curJob = queue.poll();
                currentTime+= curJob.jobTime;
                answer += currentTime-curJob.startTime;
            } else currentTime++;



        }

        return answer/jobs.length;
    }

    static class Job implements Comparable<Job>{
        int startTime;
        int createTime;
        int jobTime;

        public Job(int startTime, int createTime, int jobTime) {
            this.startTime = startTime;
            this.createTime = createTime;
            this.jobTime = jobTime;
        }



        public Job(int startTime, int jobTime) {
            this.startTime = startTime;
            this.jobTime = jobTime;
        }

        @Override
        public int compareTo(Job o) {
//            int compare  =  Integer.compare(this.startTime, o.startTime);
            return Integer.compare(this.jobTime, o.jobTime);
        }
    }

    public static void main(String[] args) {
        
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
        
    }
}
