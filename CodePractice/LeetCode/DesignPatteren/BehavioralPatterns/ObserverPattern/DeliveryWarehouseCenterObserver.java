package LeetCode.DesignPatteren.BehavioralPatterns.ObserverPattern;

public class DeliveryWarehouseCenterObserver implements Observer {
	  private String location;
	  
	  @Override
	  public void update(String location) {
	    this.location = location;
	    showLocation();
	  }

	  public void showLocation() {
	    System.out.println("Notification at Warehouse - Current Location: " + location);
	  }
	}
