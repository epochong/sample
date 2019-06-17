package sample;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.CORBA.portable.*;
import org.omg.PortableServer.*;

class HelloWorldServant extends HelloWorldPOA {
@Override
public String sayHello(){
return "\nHello World!\n";
}
}

public class HelloWorldServer{
public static void main(String args[]){
try{

ORB orb = ORB.init(args, null);

org.omg.CORBA.Object poaobj = orb.resolve_initial_references ("RootPOA");
POA rootPOA = POAHelper.narrow(poaobj);
POAManager manager = rootPOA.the_POAManager();

HelloWorldServant objRef = new HelloWorldServant();
HelloWorld obj = objRef._this(orb);

NamingContext ncRef = NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
NameComponent nc = new NameComponent("Hello", ""); 
NameComponent path[] = {nc}; 
ncRef.rebind(path, obj);

manager.activate();

System.out.println("HelloWorld is running!");
orb.run();
}catch (Exception e) { 
System.err.println("ERROR: " + e); 
e.printStackTrace(System.out); 
}
}
}