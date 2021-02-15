package com.dsaprograms.bitmanipulation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
Similar to LeetCode: 1125. Smallest Sufficient Team
1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is
     at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.

Sample Input
3
java nodejs reactjs
3
1
java
1
nodejs
2
nodejs
reactjs
Sample Output
[0, 2]

 */
public class MinimumNumberOfDevelopers {
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void getMinimumDevelopers(int [] people, int numberOfSkills, int currentPerson, ArrayList<Integer> indexes, int mask){
        if(currentPerson == people.length){
            if(mask==(1<<numberOfSkills)-1) {
                if (result.size() == 0 || indexes.size() < result.size()) {
                    result = new ArrayList<Integer>(indexes);
                }
            }
            return;
        }
        getMinimumDevelopers(people, numberOfSkills, currentPerson+1, indexes, mask); // No
        //Yes
        indexes.add(currentPerson);
        getMinimumDevelopers(people, numberOfSkills, currentPerson+1, indexes, (mask | people[currentPerson]));
        indexes.remove(indexes.size()-1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfSkills = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<numberOfSkills;i++){
            map.put(sc.next(),i);
        }
        int numberOfPeople = sc.nextInt();
        int [] people = new int[numberOfPeople];
        for(int i=0;i<numberOfPeople;i++){
            int personSkill = sc.nextInt();
            for(int j=0;j<personSkill;j++){
                String skill = sc.next();
                int index = map.get(skill);
                people[i] = people[i] | (1<<index);
            }
        }
        getMinimumDevelopers(people, numberOfSkills, 0, new ArrayList<Integer>(), 0);
        System.out.println(result);
    }
}
