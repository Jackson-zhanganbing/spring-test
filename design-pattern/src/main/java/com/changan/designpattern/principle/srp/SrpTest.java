package com.changan.designpattern.principle.srp;

/**
 * 单一职责原则（Single Responsibility Principle, SRP）
 * 每个类应该只有一个引起变化的原因
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:02
 */
public class SrpTest {

    /**
     * 不符合单一职责原则的设计，当然这种到处都是，职责划分大一点，这种设计也没问题
     */
    class Report {
        public void generateReport() {
            // 生成报告的逻辑
        }

        public void saveToFile(String filename) {
            // 将报告保存到文件的逻辑
        }

        public void print() {
            // 打印报告的逻辑
        }
    }


    /**
     * 符合单一职责原则的设计
     */
    class SrpReport {
        public void generateReport() {
            // 生成报告的逻辑
        }
    }

    class ReportSaver {
        public void saveToFile(Report report, String filename) {
            // 将报告保存到文件的逻辑
        }
    }

    class ReportPrinter {
        public void print(Report report) {
            // 打印报告的逻辑
        }
    }
}
