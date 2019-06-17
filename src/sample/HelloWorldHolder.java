package sample;

/**
* sample/HelloWorldHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HelloWorld.idl
* 2019��5��14�� ���ڶ� ����10ʱ41��04�� CST
*/

public final class HelloWorldHolder implements org.omg.CORBA.portable.Streamable
{
  public sample.HelloWorld value = null;

  public HelloWorldHolder ()
  {
  }

  public HelloWorldHolder (sample.HelloWorld initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sample.HelloWorldHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sample.HelloWorldHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sample.HelloWorldHelper.type ();
  }

}
