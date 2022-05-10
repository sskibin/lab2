package bsu.tasks;

public class Task5 extends Task {

    byte number;
    String answer;

    @Override
    protected int getTaskNumber() {
        return 5;
    }

    @Override
    protected void welcomeMessage() {
        System.out.println("Выполнение задания " + getTaskNumber() + ":");
    }

    @Override
    protected void readParameters() {
        System.out.print("Введите номер класса от 1 до 11: ");
        number = getIn().nextByte();
    }

    @Override
    protected void executeTask() {
        switch (number) {
            case 1:
                answer = "Привет, первоклассник!";
                break;
            case 2:
                answer = "Привет, второклассник!";
                break;
            case 3:
                answer = "Привет, третьеклассник!";
                break;
            case 4:
                answer = "Привет, четвероклассник!";
                break;
            case 5:
                answer = "Привет, пятиклассник!";
                break;
            case 6:
                answer = "Привет, шестиклассник!";
                break;
            case 7:
                answer = "Привет, семиклассник!";
                break;
            case 8:
                answer = "Привет, восьмиклассник!";
                break;
            case 9:
                answer = "Привет, девятиклассник!";
                break;
            case 10:
                answer = "Привет, десятиклассник!";
                break;
            case 11:
                answer = "Привет, одиннадцатиклассник!";
                break;
            default:
                System.out.println("Неверно введен номер класса!");
        }
    }

    @Override
    protected void writeResults() {
        System.out.println(getResultString());
        filewriter();
    }

    @Override
    protected String getResultString() {
        return "Задание №5. Ответ: " + answer;
    }


}
