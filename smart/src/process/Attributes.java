package process;

public class Attributes {
    int index;
    public String attributeName;
    double weight;
	String attributeTag;
	
	public Attributes(String name,String tag){
	     this.attributeName=name;
	     this.attributeTag=tag;
	}
	
	public void setIndex(int newIndex){
		this.index=newIndex;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public void setWeight(double w){
		weight=w;
	}
	public double getWeight(){
		return weight;
	}
}
