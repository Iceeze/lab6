package n1;

import n2.Default;

public class B extends A {
    @Default(value=String.class)
    private String text = "B";
}
