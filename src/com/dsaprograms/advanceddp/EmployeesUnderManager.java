package com.dsaprograms.advanceddp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
Sample Input
6
A C
B C
C F
D E
E F
F F
Sample Output
A 0
B 0
C 2
D 0
E 1
F 5
 */
public class EmployeesUnderManager {
    public static int getSize(HashMap<Character,HashSet<Character>> tree, char manager, HashMap<Character, Integer> result){
        if(!tree.containsKey(manager)){
            result.put(manager,0);
            return 1;
        }
        int size = 0;
        for(Character child:tree.get(manager)){
            int childSize = getSize(tree, child, result);
            size += childSize;
        }

        result.put(manager,size);
        return size + 1;
    }

    public static void findCount(HashMap<Character, Character> map){
        HashMap<Character, HashSet<Character>> tree = new HashMap<>();
        char ceo = '\0';
        for(Character employee:map.keySet()){
            char manager = map.get(employee);
            if(employee.equals(manager)){ // F F
                ceo = employee;
            }else{
                if(tree.containsKey(manager)){
                    HashSet<Character> employees = tree.get(manager);
                    employees.add(employee);
                    // tree.put(manager,employees);
                }
                else{
                    HashSet<Character> employees = new HashSet<>();
                    employees.add(employee);
                    tree.put(manager,employees);
                }
            }
        }

        HashMap<Character, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);
        for(Character employee: result.keySet()){
            System.out.println(employee+" "+result.get(employee));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.next().charAt(0), sc.next().charAt(0));
        }
        findCount(map);
    }
}
