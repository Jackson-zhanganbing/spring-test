package com.changan.designpattern.principle.lod;

/**
 * 迪米特法则（Law of Demeter, LoD）
 * 指的是一个类/模块对其他的类/模块了解得越少越好
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:44
 */
public class LodTest {

    /**
     * 不符合迪米特法则
     */
    class Address {
        public String getZipCode() {
            return "12345";
        }
    }

    class Customer {
        private Address address = new Address();

        public Address getAddress() {
            return address;
        }
    }

    class Order {
        private Customer customer;

        public Order(Customer customer) {
            this.customer = customer;
        }

        public void processOrder() {
            // 不应该直接访问陌生对象，应该直接用customer的方法查询
            Address address = customer.getAddress();
            String zipCode = address.getZipCode();
            System.out.println("Processing order for zip code: " + zipCode);
        }
    }


    /**
     * 符合迪米特法则 的设计
     */
    class LodAddress {
        public String getZipCode() {
            return "12345";
        }
    }

    class LodCustomer {
        private Address address = new Address();

        // 提供对外接口
        public String getZipCode() {
            return address.getZipCode();
        }
    }

    class LodOrder {
        private LodCustomer lodCustomer;

        public LodOrder(LodCustomer customer) {
            this.lodCustomer = customer;
        }

        public void processOrder() {
            // 只与直接关联的对象交互
            String zipCode = lodCustomer.getZipCode();
            System.out.println("Processing order for zip code: " + zipCode);
        }
    }

    // 示例使用
    public class Main {
        public void main(String[] args) {
            LodCustomer customer = new LodCustomer();
            LodOrder order = new LodOrder(customer);
            order.processOrder();
        }
    }
}
