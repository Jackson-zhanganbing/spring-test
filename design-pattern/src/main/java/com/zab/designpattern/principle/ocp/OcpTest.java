package com.zab.designpattern.principle.ocp;

/**
 * 开放封闭原则（Open/Closed Principle）
 * 对扩展开放，对修改关闭
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:02
 */
public class OcpTest {

    /**
     * 不符合开闭原则的设计
     */
    class AreaCalculator {
        public double calculateArea(Object shape) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                return Math.PI * circle.getRadius() * circle.getRadius();
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                return rectangle.getWidth() * rectangle.getHeight();
            }
            throw new IllegalArgumentException("Unknown shape");
        }
    }

    class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
    }


    /**
     * 符合开闭原则
     */
    interface Shape {
        double area();
    }

    class OcpCircle implements Shape {
        private double radius;

        public OcpCircle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    class OcpRectangle implements Shape {
        private double width;
        private double height;

        public OcpRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    class OcpAreaCalculator {
        public double calculateArea(Shape shape) {
            return shape.area(); // 只依赖于接口
        }
    }

    // 示例使用
    public class Main {
        public void main(String[] args) {
            AreaCalculator calculator = new AreaCalculator();
            Circle circle = new Circle(5);
            Rectangle rectangle = new Rectangle(4, 6);
            System.out.println("Circle area: " + calculator.calculateArea(circle));
            System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        }
    }
}
