package bsu.tasks;

import org.apache.log4j.Logger;

public class Task4 extends Task {
    private static final Logger log = Logger.getLogger(Task1.class);
    double x, y, x1, y1, x2, y2, x3, y3;
    byte flag;

    @Override
    protected int getTaskNumber() {
        return 4;
    }

    @Override
    protected void welcomeMessage() {
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        System.out.println("Введите координаты точки А: ");
        System.out.print("X - координата =  ");
        x = getIn().nextDouble();
        System.out.print("Y - координата =  ");
        y = getIn().nextDouble();
        System.out.println("Введите координаты точек вершин: ");
        System.out.print("X1 = ");
        x1 = getIn().nextDouble();
        System.out.print("Y1 = ");
        y1 = getIn().nextDouble();
        System.out.print("X2 = ");
        x2 = getIn().nextDouble();
        System.out.print("Y2 = ");
        y2 = getIn().nextDouble();
        System.out.print("X3 = ");
        x3 = getIn().nextDouble();
        System.out.print("Y3 = ");
        y3 = getIn().nextDouble();
    }

    @Override
    protected void executeTask() {
        flag = peaks(x, y, x1, y1, x2, y2, x3, y3);
    }

    @Override
    protected void writeResults() {
        System.out.println(getResultString());
        filewriter();
    }

    @Override
    protected String getResultString() {
        String answer = null;
        if (flag == 1)
            answer = "Задание №4. Ответ: Точка (" + x + "; " + y + ")" + " принадлежит треугольнику с заданными вершинами.";
        else if (flag == 0)
            answer = "Задание №4. Ответ: Точка (" + x + "; " + y + ")" + " НЕ принадлежит треугольнику с заданными вершинами.";
        return answer;
    }


    // Метод удвоенной площади треугольника по координатам
    public double triangle_area(double x1, double y1, double x2, double y2, double x3, double y3) {
        double S2 = (x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2);
        return S2;
    }

    public byte peaks(double x, double y, double x1, double y1, double x2, double y2, double x3, double y3) {
        //определяем площади 3х малых треугольников
        double f1 = triangle_area(x, y, x1, y1, x2, y2);
        double f2 = triangle_area(x, y, x2, y2, x3, y3);
        double f3 = triangle_area(x, y, x3, y3, x1, y1);
        //если произведения площадей попарно больше 0, то точка внутри
        if (((f1 * f2) >= 0) && ((f2 * f3) >= 0))
            flag = 1;
        else
            flag = 0;
        return flag;
    }
}
