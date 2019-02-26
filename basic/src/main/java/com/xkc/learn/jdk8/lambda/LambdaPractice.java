package com.xkc.learn.jdk8.lambda;

import java.util.Arrays;

public class LambdaPractice {
    private static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Persion{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @FunctionalInterface
    private interface Calculator {
        // 求和
        int calc(int a, int b);
    }

    private static int invokeCalc(int a, int b, Calculator calculator) {
        return calculator.calc(a, b);
    }


    public static void main(String[] args) {
        Person[] people = {new Person("柳岩", 38), new Person("迪丽热巴", 28), new Person("古力娜扎", 19)};

        // 使用lambda对数组根据指定属性排列
        Arrays.sort(people, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(people[0] + "\n" + people[1] + "\n" + people[2]);

        // 使用lambda重写有参数有返回值的方法
        int result = invokeCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        System.out.println(result);

        System.out.println(invokeCalc(100, 100, (m, n) -> m + n));
    }
}
