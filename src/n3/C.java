package n3;

import n1.B;
import n2.ToString;

public class C extends B {
    @ToString("YES")
    private String s = "test";

    @ToString("NO")
    private int testInt = 199;

    private String s1 = "hello";
}
