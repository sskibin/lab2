package bsu.tasks;

public class Task8 extends Task {

    int M, N, k, result;

    @Override
    protected int getTaskNumber() {
        return 8;
    }

    @Override
    protected void welcomeMessage() {
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        System.out.print("Введите натуральное число M: ");
        M = getIn().nextInt();
        System.out.print("Введите натуральное число N: ");
        N = getIn().nextInt();
        System.out.print("Введите натуральное число k: ");
        k = getIn().nextInt();
    }

    @Override
    protected void executeTask() {
        result = count(M, N, k);
    }

    @Override
    protected void writeResults() {
        System.out.println(getResultString());
        filewriter();
    }

    @Override
    protected String getResultString() {
        return "Задание №" + getTaskNumber() + ". Ответ:  искомая сумма чисел равна " + result;
    }

    public int count(int M, int N, int k) {
        int sum = 0;
        for (int i = M + 1; i < N; i++) {
            if (i % k == 0)
                sum += i;
        }
        return sum;
    }
}
