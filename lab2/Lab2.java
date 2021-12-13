import java.util.Scanner;

public class Lab2 {


    public static Point3d readPoint3dFromUserInput() {
        //Задаем координаты точки. Возвращает координаты
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        return new Point3d(
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public static void main(String[] args) {
        Point3d coords1 = readPoint3dFromUserInput();
        Point3d coords2 = readPoint3dFromUserInput();
        Point3d coords3 = readPoint3dFromUserInput();
        if (coords1.equals(coords2) || coords2.equals(coords3) || coords1.equals(coords3)) {
            System.out.println("Одна из точек равна другой");
            return;
        }
        double square= get_square(coords1, coords2, coords3);
        System.out.printf("Полученная площадь: %.2f\n", square);
    }

    public static double get_square(Point3d coords1, Point3d coords2, Point3d coords3) {
        //Высчитывает площадь треугольника по координатам
        double side1, side2, side3, perimeter;
        side1 = coords1.distanceTo(coords2);
        side2 = coords1.distanceTo(coords3);
        side3 = coords2.distanceTo(coords3);
        perimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));
    }



}
