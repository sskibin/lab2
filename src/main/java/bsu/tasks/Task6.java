package bsu.tasks;

public class Task6 extends Task {

    int n;
    String result;

    @Override
    protected int getTaskNumber() {
        return 6;
    }

    @Override
    protected void welcomeMessage() {
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        System.out.print("Введите число: ");
        n = getIn().nextInt();
    }

    @Override
    protected void executeTask() {
        result = denominaters(n);
    }

    @Override
    protected void writeResults() {
        System.out.println(getResultString());
        filewriter();
    }

    @Override
    protected String getResultString() {
        return "Задание №" + getTaskNumber() + ". Делители числа " + n + ": " + result;
    }


    protected String denominaters(int n) {
        String res = "";
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                res += i + " ";
        }
        return res;
    }
}

