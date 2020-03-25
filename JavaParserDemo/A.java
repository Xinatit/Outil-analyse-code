package jar;

/**
 * Hello world!
 *
 */
public class A
{
    private B b;

    public A(B o)
    {
        b = o;
    }

    public void callDoX()
    {
        b.doX();
    }

    public int callDoY()
    {
        return b.getY() * 2;
    }


    public void Hello(int a)
    {
        int b = a +1;
    }

}
