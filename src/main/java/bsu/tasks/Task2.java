package bsu.tasks;

public class Task2 extends Task {

    private double a, b, alpha, s;

    @Override
    protected int getTaskNumber() {
        return 2;
    }

    @Override
    public void welcomeMessage() {
        //Найти площадь равнобедренной трапеции с основаниями а и b и углом а при большем основании а.
        System.out.println("Выполнение задания 2:");
    }

    @Override
    public void readParameters() {
        //Ввод исходных данных через консоль
        System.out.print("Введите большее основание a: ");
        a = getIn().nextDouble();
        System.out.print("Введите меньшее основание b: ");
        b = getIn().nextDouble();
        System.out.print("Введите угол a (в градусах): ");
        alpha = getIn().nextDouble();
    }

    @Override
    public void executeTask() {
        //Решение задачи
        s = trapezoid_area(a, b, alpha);
    }

    @Override
    public void writeResults() {
        System.out.print("Площадь равнобокой трапеции: " + s);
        //Запись результата в файл
        filewriter();
    }

    @Override
    protected String getResultString() {
        return "Задание №" + getTaskNumber() + ". Ответ:  " + s;
    }

    private double trapezoid_area(double a, double b, double alpha) {
        double result = ((Math.pow(a, 2) - Math.pow(b, 2)) / 2) * Math.tan(Math.toRadians(alpha));
        return result;
    }
}
