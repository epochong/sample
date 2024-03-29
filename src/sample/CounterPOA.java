package sample;


/**
* CounterApp/CounterPOA.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��counter.idl
* 2019��5��14�� ���ڶ� ����11ʱ30��34�� CST
*/

public abstract class CounterPOA extends org.omg.PortableServer.Servant
 implements CounterOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_value", new java.lang.Integer (0));
    _methods.put ("inc", new java.lang.Integer (1));
    _methods.put ("dec", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CounterApp/Counter/_get_value
       {
         int $result = (int)0;
         $result = this.value ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // CounterApp/Counter/inc
       {
         this.inc ();
         out = $rh.createReply();
         break;
       }

       case 2:  // CounterApp/Counter/dec
       {
         this.dec ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CounterApp/Counter:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Counter _this() 
  {
    return CounterHelper.narrow(
    super._this_object());
  }

  public Counter _this(org.omg.CORBA.ORB orb) 
  {
    return CounterHelper.narrow(
    super._this_object(orb));
  }


} // class CounterPOA
