package sample;


/**
* sample/HelloWorldHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HelloWorld.idl
* 2019��5��14�� ���ڶ� ����10ʱ41��04�� CST
*/

abstract public class HelloWorldHelper
{
  private static String  _id = "IDL:sample/HelloWorld:1.0";

  public static void insert (org.omg.CORBA.Any a, sample.HelloWorld that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sample.HelloWorld extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sample.HelloWorldHelper.id (), "HelloWorld");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sample.HelloWorld read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloWorldStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sample.HelloWorld value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sample.HelloWorld narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sample.HelloWorld)
      return (sample.HelloWorld)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sample._HelloWorldStub stub = new sample._HelloWorldStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sample.HelloWorld unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sample.HelloWorld)
      return (sample.HelloWorld)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sample._HelloWorldStub stub = new sample._HelloWorldStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
