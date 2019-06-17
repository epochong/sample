package sample;


public class CounterImpl extends CounterPOA {
    private int count;   
    public CounterImpl(){   
        count = 0;   
    }   
    @Override
    public void inc(){
        count++;   
    }   
    @Override
    public void dec(){
        count --;
    }   
    @Override
    public int value(){
        return count;   
    }   
}