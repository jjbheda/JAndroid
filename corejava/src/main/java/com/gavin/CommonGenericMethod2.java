package com.gavin;

public class CommonGenericMethod2 {
    static class Animal {
        @Override
        public String toString() {
            return "I am just a Animal";
        }
    }

    static class Dog extends Animal {
        @Override
        public String toString() {
            return "I am a Dog";
        }
    }

    static class Plant {
        @Override
        public String toString() {
            return "I am a plant";
        }
    }

    static class GenericModel<T> {
        public void getName_1(T t) {  //注意类声明中的<T> 仅影响 这个类的普通方法
            System.out.println(t);
        }

        //<E> <T> 都是泛型声明，跟类声明的<T> 可以理解为完全独立，仅仅是名称重复
        public <E> void getName_2(E t) {
            System.out.println(t);
        }

        //<E> <T> 都是泛型声明，跟类声明的<T> 可以理解为完全独立，仅仅是名称重复
        public <T> void getName_3(T t) {
            System.out.println(t);
        }

        public static void main(String[] args) {
            Dog dog = new Dog();
            Plant plant = new Plant();

            GenericModel<Animal> genericModel = new GenericModel<>();
            genericModel.getName_1(dog);
//            genericModel.getName_1(plant);   普通方法，无法直接用别的类型

            genericModel.getName_2(dog);
            genericModel.getName_2(plant);  //泛型方法<E> 声明

            genericModel.getName_3(dog);    //泛型方法<T> 声明 与类声明的<T> 仅仅是名称重复
            genericModel.getName_3(plant);

//            GenericModel<Object> genericMode2 = new GenericModel<>();
//            genericMode2.getName_1(dog);
//            genericMode2.getName_1(plant);
//            genericMode2.getName_2(dog);
//            genericMode2.getName_2(plant);
//            genericMode2.getName_3(dog);
//            genericMode2.getName_3(plant);

        }

    }




}
