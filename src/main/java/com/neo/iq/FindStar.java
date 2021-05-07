package com.neo.iq;

import com.sun.tools.javac.util.Assert;

public class FindStar {

    /**
     * 一个明星 n个人  明星不认识其他人,其他人认识明星, 求在O(n)的复杂度中找出明星
     *
     * @param args
     */
    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person(0,false);
        persons[1] = new Person(1,false);
        persons[2] = new Person(2,true);
        persons[3] = new Person(3,false);
        persons[4] = new Person(4,false);
        Solution solution = new Solution();
        Person compare = solution.find(persons);

        if(compare != null){
            System.out.println(compare.index);
            System.out.println(compare.isStar);
        }


    }


    public static class Solution {

        public Person find(Person[] persons) {

            for (int i = 0; i < persons.length - 1; i++) {
                Person compare = compare(persons[i], persons[i + 1]);
                if (compare != null) {
                    return compare;
                }
            }
            return null;
        }

        public Person compare(Person p1, Person p2) {
            if (s(p1, p2)) {
                return p2;
            }
            if (s(p2, p1)) {
                return p1;
            }
            return null;
        }

        public boolean s(Person A, Person B) {
            if (B.isStar && !A.isStar) {
                return true;
            }
            return false;
        }

    }

    public static class Person {

        public Person(int index, boolean isStar) {
            this.index = index;
            this.isStar = isStar;
        }

        public int index;
        public boolean isStar;


    }
}
