package com.zab.designpattern.principle.isp;

/**
 * 接口隔离原则（Interface Segregation Principle, ISP）
 * 客户端不应该依赖它不需要的接口
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:28
 */
public class IspTest {
    /**
     * 不符合接口隔离原则的案例
     */
    interface Animal {
        void eat();

        void fly();

        void swim();
    }

    class Dog implements Animal {
        @Override
        public void eat() {
            System.out.println("Dog is eating.");
        }

        @Override
        public void fly() {
            throw new UnsupportedOperationException("Dogs can't fly!");
        }

        @Override
        public void swim() {
            System.out.println("Dog is swimming.");
        }
    }

    class Fish implements Animal {

        @Override
        public void eat() {
            System.out.println("Fish is eating.");
        }

        @Override
        public void fly() {
            throw new UnsupportedOperationException("Fish can't fly!");
        }

        @Override
        public void swim() {
            System.out.println("Fish is swimming.");
        }
    }


    /**
     * 符合接口隔离原则的案例
     */
    interface Eater {
        void eat();
    }

    interface Flyer {
        void fly();
    }

    interface Swimmer {
        void swim();
    }

    class IspDog implements Eater, Swimmer {
        @Override
        public void eat() {
            System.out.println("Dog is eating.");
        }

        @Override
        public void swim() {
            System.out.println("Dog is swimming.");
        }
    }

    class IspFish implements Eater, Swimmer {
        @Override
        public void eat() {
            System.out.println("Fish is eating.");
        }

        @Override
        public void swim() {
            System.out.println("Fish is swimming.");
        }
    }

    class IspBird implements Eater, Flyer {
        @Override
        public void eat() {
            System.out.println("Bird is eating.");
        }

        @Override
        public void fly() {
            System.out.println("Bird is flying.");
        }
    }
}
