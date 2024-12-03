package com.changan.designpattern.principle.dip;

/**
 * 依赖倒置原则（Dependency Inversion Principle, DIP）
 * 高层模块不应该依赖于低层模块，二者都应该依赖于抽象
 *
 * @author anbing.zhang
 * @date 2024/11/7 20:38
 */
public class DipTest {
    /**
     * 不符合依赖倒置的案例
     */
    // 低层模块
    class FileManager {
        public void save(String data) {
            // 保存数据到文件
            System.out.println("Data saved to file: " + data);
        }
    }

    // 高层模块
    class DataProcessor {
        // 直接依赖低层模块
        private FileManager fileManager = new FileManager();

        public void processData(String data) {
            // 处理数据
            fileManager.save(data);
        }
    }

    /**
     * 符合依赖倒置的案例
     */
    interface DataSaver {
        void save(String data);
    }

    class DipFileManager implements DataSaver {
        @Override
        public void save(String data) {
            // 保存数据到文件
            System.out.println("Data saved to file: " + data);
        }
    }

    class DipDatabaseManager implements DataSaver {
        @Override
        public void save(String data) {
            // 保存数据到数据库
            System.out.println("Data saved to database: " + data);
        }
    }

    class DipDataProcessor {
        //依赖抽象，不依赖实现
        private DataSaver dataSaver;

        public DipDataProcessor(DataSaver dataSaver) {
            this.dataSaver = dataSaver;
        }

        public void processData(String data) {
            // 处理数据
            dataSaver.save(data); // 使用抽象方法
        }
    }

    public class Main {
        public void main(String[] args) {
            DataSaver fileManager = new DipFileManager();
            DipDataProcessor processor1 = new DipDataProcessor(fileManager);
            processor1.processData("Sample Data 1");

            DataSaver databaseManager = new DipDatabaseManager();
            DipDataProcessor processor2 = new DipDataProcessor(databaseManager);
            processor2.processData("Sample Data 2");
        }
    }
}
