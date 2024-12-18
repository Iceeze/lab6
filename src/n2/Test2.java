package n2;

@Validate(value={Test1.class, Test2.class})
@Two(first="Test", second=2)
public class Test2 {
    @ToString()
    private String first;
    @ToString("NO")
    private int second;
}
