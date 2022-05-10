package bsu.tasks;

public class Task7 extends Task {

    int n;
    double x, result;

    @Override
    protected int getTaskNumber() {
        return 7;
    }

    @Override
    protected void welcomeMessage() {
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        System.out.print("Введите количество членов ряда (n): ");
        n = getIn().nextInt();
        System.out.print("Введите действительное число (x): ");
        x = getIn().nextDouble();
    }

    @Override
    protected void executeTask() {
        result = series(n, x);
    }

    @Override
    protected void writeResults() {
        System.out.println(getResultString());
        filewriter();
    }

    @Override
    protected String getResultString() {
        return "Задание №" + getTaskNumber() + ". Ответ: сумма " + n + " членов ряда S равна: " + result;
    }

    protected double series(int n, double x) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            S += Math.cos(2 * i * x) / i;
        }
        return S;
    }
}
