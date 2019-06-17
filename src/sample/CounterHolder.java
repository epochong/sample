package sample;

/**
* CounterApp/CounterHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��counter.idl
* 2019��5��14�� ���ڶ� ����11ʱ30��34�� CST
*/

public final class CounterHolder implements org.omg.CORBA.portable.Streamable
{
  public Counter value = null;

  public CounterHolder ()
  {
  }

  public CounterHolder (Counter initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CounterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CounterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CounterHelper.type ();
  }

}
