package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
Task Completion
1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.
7. You have to find the tasks that s1 and s2 have to complete.
Sample Input
15 6
2 5 6 7 9 4
Sample Output
1 8 11 13 15
3 10 12 14
*/
public class TaskCompletion {
    public static void completeTask(int n, int [] nums){
        HashSet<Integer> completed = new HashSet<Integer>();
        for(int val:nums){
            completed.add(val);
        }
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        boolean flag = true;
        for(int i=1;i<=n;i++){
            if(!completed.contains(i)){
                if(flag){
                    one.add(i);
                }
                else{
                    two.add(i);
                }
                flag = !flag;
            }
        }
        System.out.println(one);
        System.out.println(two);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] nums = new int[m];
        for(int i=0;i<m;i++){
            nums[i] = sc.nextInt();
        }
        completeTask(n, nums);
    }
}
