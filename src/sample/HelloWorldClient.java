package sample;

import sample.*;
import org.omg.CosNaming.*; 
import org.omg.CORBA.*;

public class HelloWorldClient { 
public static void main(String args[]) { 
try{
ORB orb = ORB.init(args, null);
org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); 
NamingContext ncRef = NamingContextHelper.narrow(objRef); 
NameComponent nc = new NameComponent("Hello",""); 
NameComponent path[] = {nc}; 
HelloWorld helloWorld = HelloWorldHelper.narrow(ncRef.resolve(path)); 
String hello = helloWorld.sayHello(); 
System.out.println(hello); 
} catch (Exception e) {
System.out.println("ERROR : " + e) ;
e.printStackTrace(System.out); 
}
}
}