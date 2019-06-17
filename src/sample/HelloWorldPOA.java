package sample;


/**
* sample/HelloWorldPOA.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��HelloWorld.idl
* 2019��5��14�� ���ڶ� ����10ʱ41��04�� CST
*/

public abstract class HelloWorldPOA extends org.omg.PortableServer.Servant
 implements sample.HelloWorldOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sayHello", new Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sample/HelloWorld/sayHello
       {
         String $result = null;
         $result = this.sayHello ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sample/HelloWorld:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public HelloWorld _this() 
  {
    return HelloWorldHelper.narrow(
    super._this_object());
  }

  public HelloWorld _this(org.omg.CORBA.ORB orb) 
  {
    return HelloWorldHelper.narrow(
    super._this_object(orb));
  }


} // class HelloWorldPOA
