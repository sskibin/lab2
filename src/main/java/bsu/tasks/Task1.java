package bsu.tasks;

import org.apache.log4j.Logger;

public class Task1 extends Task {
    private static final Logger log = Logger.getLogger(Task1.class);
    private double x, y, z;

    @Override
    protected int getTaskNumber() {

        return 1;
    }

    @Override
    protected void welcomeMessage() {
        log.info("Вычисление выражения задания 1");
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        log.info("Ввод исходных значений");
        System.out.print("Введите значение X: ");
        x = getIn().nextDouble();
        System.out.print("Введите значение Y: ");
        y = getIn().nextDouble();
    }

    @Override
    protected void executeTask() {
        //Решение задачи
        log.debug("Решение задания 1");
        z = expression(x, y);
    }

    @Override
    protected void writeResults() {
        System.out.println("Результат вычислений: " + z);
        filewriter();
        log.error("Запись результатов в файл");
    }

    @Override
    protected String getResultString() {
        String result = "Задание №1. Ответ:  " + z;
        return result;
    }

    //Метод для решения Задания №1
    private double expression(double x, double y) {
        double Z = Math.pow(2, -x) - Math.cos(x) + Math.sin(2 * x * y);
        return Z;
    }
}
