package com.practice.company;

public class TestAll {

    public static void main(String[] args) {
//        Map<Color,String> map = new HashMap<>();
//        map.put(new Color("Red"),"Red");
//        map.put(new Color("Bue"),"Blue");
//        map.put(new Color("Green"),"Green");
//        System.out.println(map.size());
//        System.out.println(map.get(new Color("Red")));

//        Integer number = 10;
//        number++;
//        assert number == null && number>=0;
//        System.out.println(number);




//        Comparator<Integer> numb = (num1,num2) -> num2.compareTo(num1);
//        Integer arr[] = {1,4,3,2};
//        Arrays.sort(arr,numb);
//        for(Integer num:arr){
//            System.out.println(num);
//        }
        System.out.println(method());

//        Runnable runnable = new Thread();
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
    }

    public static Object method(){
        try {
            int i = 10/0;
            return i;
        }catch (ArithmeticException e){
            return " catch";
        } finally {
            return "finally";
        }
    }
}

class Test<T> {
    T value;
    public Test(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        Test<String> f = new Test<>("a string");
        Test<Integer> s = new Test<>(123);
        System.out.print(f.value);
        System.out.print(s.value);

    }
}

class Color {
    private String name;
    public Color(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
