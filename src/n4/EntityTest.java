package n4;

import n1.Entity;
import n2.ToString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    // Тест №1: проверяем поведение без аннотаций (все поля должны попасть в строку)
    @Test
    public void testToStringWithoutAnnotations() {
        class NoAnnotations extends Entity {
            String field1 = "hello";
            int field2 = 10;
        }

        NoAnnotations obj = new NoAnnotations();
        String expected = "NoAnnotations{field1=hello; field2=10}";
        assertEquals(expected, obj.toString());
    }

    // Тест №2: проверяем поведение с @ToString(NO) на поле (поле не должно попасть в строку)
    @Test
    public void testToStringWithNoAnnotationOnField() {
        class WithNoAnnotationField extends Entity {
            @ToString("NO")
            String hiddenField = "secret";

            String visibleField = "visible";
        }

        WithNoAnnotationField obj = new WithNoAnnotationField();
        String expected = "WithNoAnnotationField{visibleField=visible}";
        assertEquals(expected, obj.toString());
    }

    // Тест №3: проверяем поведение с @ToString(YES) и @ToString(NO) на полях
    @Test
    public void testToStringWithYesAndNoAnnotationsOnFields() {
        class MixedAnnotations extends Entity {
            @ToString("NO")
            String hiddenField = "secret";

            @ToString("YES")
            String visibleField = "visible";
        }

        MixedAnnotations obj = new MixedAnnotations();
        String expected = "MixedAnnotations{visibleField=visible}";
        assertEquals(expected, obj.toString());
    }

    // Тест №4: проверяем поведение с @ToString(NO) на классе (поля класса не попадают в строку)
    @Test
    public void testToStringWithNoAnnotationOnClass() {
        @ToString("NO")
        class NoAnnotationsOnClass extends Entity {
            String field1 = "hello";
            int field2 = 10;
        }

        NoAnnotationsOnClass obj = new NoAnnotationsOnClass();
        String expected = "NoAnnotationsOnClass{}";  // Поля не должны попасть в строку
        assertEquals(expected, obj.toString());
    }

    // Тест №5: проверяем поведение с @ToString(NO) на классе и @ToString(YES) на поле (поле должно попасть в строку)
    @Test
    public void testToStringWithNoOnClassAndYesOnField() {
        @ToString("NO")
        class NoOnClassYesOnField extends Entity {
            @ToString("YES")
            String importantField = "important";
            String hiddenField = "hidden";  // По умолчанию не должно попадать в строку
        }

        NoOnClassYesOnField obj = new NoOnClassYesOnField();
        String expected = "NoOnClassYesOnField{importantField=important}";
        assertEquals(expected, obj.toString());
    }
}

