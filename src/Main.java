import n1.A;
import n1.B;
import n2.*;
import n3.C;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вариант 10\n");
        System.out.println("Список заданий:");
        System.out.println("1. Рефлексия (1.1)");
        System.out.println("2. Анотации (2.1-2.6)");
        System.out.println("3. Обработка аннотаций (3.1)");
        System.out.print("\nВыберите номер задания: ");
        String choice = scanner.next();

        switch (choice) {
            // Задание 1.1
            case "1": {
                B b = new B();
                System.out.println(b);
            } break;

            // Задания 2.1-2.6
            case "2": {
                Class<?> a = A.class;
                System.out.println(a.getSimpleName() + " " + a.getAnnotation(Cache.class));

                Class<?> b = B.class;
                Field[] fields = b.getDeclaredFields();
                for (Field field : fields) { System.out.println(field.getName() + " " + field.getAnnotation(Default.class)); }

                Class<?> t1 = Test1.class;
                Method[] methods = t1.getDeclaredMethods();
                for (Method method : methods) { System.out.println(method.getName() + " " + method.getAnnotation(Invoke.class)); }

                Class<?> t2 = Test2.class;
                Field[] fields1 = t2.getDeclaredFields();
                for (Field field : fields1) { System.out.println(field.getName() + " " + field.getAnnotation(ToString.class)); }
                Two annT2 = t2.getAnnotation(Two.class);
                System.out.println(t2.getSimpleName() + " " + annT2);

            } break;

            // Задание 3.1
            case "3": {
                C c = new C();
                System.out.println(c);
            } break;

            default: System.out.println("Такого задания нет в списке.");
        }
    }
}