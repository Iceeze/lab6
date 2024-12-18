package n1;

import n2.ToString;
import java.lang.reflect.Field;

public abstract class Entity {
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class<?> clazz = this.getClass(); // Получаем класс текущего объекта (наследника)
        int classNameLength = clazz.getSimpleName().length();
        result.append(clazz.getSimpleName()).append("{"); // Добавляем имя класса и открывающую фигурную скобку

        // Получаем и добавляем все поля текущего класса и всех суперклассов
        while (clazz != null) {
            boolean classFlag = true;
            if (clazz.isAnnotationPresent(ToString.class)) {
                ToString annotationClass = clazz.getAnnotation(ToString.class);
                classFlag = annotationClass.value().equals("YES");
            }
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                boolean fieldFlag = classFlag;

                if (field.isAnnotationPresent(ToString.class)) {
                    ToString ann = field.getAnnotation(ToString.class);
                    fieldFlag = ann.value().equals("YES");
                }
                if (fieldFlag) {
                    field.setAccessible(true);  // Получаем доступ к полю
                    try {
                        Object value = field.get(this);  // Получаем значение поля
                        result.append(field.getName()).append("=").append(value).append("; ");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            clazz = clazz.getSuperclass();  // Переходим к суперклассу
        }

        // Удаляем последнее "; " и добавляем закрывающую фигурную скобку
        if (result.length() - classNameLength > 1) result.setLength(result.length() - 2);
        result.append("}");

        return result.toString();
    }
}
