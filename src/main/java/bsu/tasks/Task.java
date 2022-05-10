/*
 * class: Task
 *
 * openJDK version: 17
 *
 * author: Stanislav Skibin
 */
package bsu.tasks;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Task {

    private static final Logger log = Logger.getLogger(Task.class);

    private Scanner in;

    /**
     * Возвращает номер задачи
     *
     * @return
     */
    protected abstract int getTaskNumber();

    /**
     * Приветственное сообщение
     */
    protected abstract void welcomeMessage();

    /**
     * Исходные параметры
     */
    protected abstract void readParameters();

    /**
     * Выполнение задания
     */
    protected abstract void executeTask();

    /**
     * Запись ответа
     */
    protected abstract void writeResults();

    /**
     * Результаты
     */
    protected abstract String getResultString();

    /**
     * Общий шаблон
     */
    public void execute() {
        in = new Scanner(System.in);
        welcomeMessage();
        readParameters();
        executeTask();
        writeResults();
    }

    /**
     * Запись в файл
     */
    protected void filewriter() {
        try {
            File file = new File("Задание №" + getTaskNumber());
            if (!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.println(getResultString());
            pw.close();
        } catch (IOException e) {
            log.fatal("Ошибка чтения из файла", e);

        }
    }

    /**
     * Файловый ввод
     */
    //Метод чтения исходных данных (числовые значения) из файла
    protected int[] getData(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        try {
            int[] dataArray = new int[10];
            int i = 0;
            while (scan.hasNextInt()) {
                dataArray[i] = scan.nextInt();
                i++;
            }
            return dataArray;
        } finally {
            scan.close();
        }
    }

    /**
     * Консольный ввод
     */
    protected Scanner getIn() {
        return in;
    }
}
