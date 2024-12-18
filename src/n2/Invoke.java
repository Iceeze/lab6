package n2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // Указывает, что наша Аннотация может быть использована во время выполнения
@Target(ElementType.METHOD) // Указывает, что целью нашей Аннотации является метод
public @interface Invoke {
}
