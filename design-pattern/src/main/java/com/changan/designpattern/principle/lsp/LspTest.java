package com.changan.designpattern.principle.lsp;

/**
 * 里氏替换原则（Liskov Substitution Principle, LSP）
 * 所有引用基类的地方都必须能透明地使用其子类的对象
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:19
 */
public class LspTest {

    /**
     * 不符合里氏替换的原则
     */
    class Bird {
        public void fly() {
            System.out.println("I can fly!");
        }
    }

    class Sparrow extends Bird {
    }

    class Penguin extends Bird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Penguins can't fly!");
        }
    }

    public class Main {
        public void main(String[] args) {
            Bird myBird = new Sparrow();
            myBird.fly(); // 这是正常的

            myBird = new Penguin();
            myBird.fly(); // 这里会抛出异常，不符合LSP
        }
    }

    /**
     * 符合里氏替换的原则
     */
    interface LspBird {
        void makeSound();
    }

    interface LspFlyingBird extends LspBird {
        void fly();
    }

    class LspSparrow implements LspFlyingBird {
        public void makeSound() {
            System.out.println("Chirp!");
        }

        public void fly() {
            System.out.println("I can fly!");
        }
    }

    class LspPenguin implements LspBird {
        public void makeSound() {
            System.out.println("Honk!");
        }
    }

    public class LspMain {
        public void main(String[] args) {
            LspFlyingBird sparrow = new LspSparrow();
            sparrow.fly(); // 正常

            LspBird penguin = new LspPenguin();
            penguin.makeSound(); // 正常，不会引发飞行错误
        }
    }
}
