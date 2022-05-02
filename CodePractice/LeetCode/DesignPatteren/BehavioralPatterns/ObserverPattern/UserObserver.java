package LeetCode.DesignPatteren.BehavioralPatterns.ObserverPattern;

class UserObserver implements Observer {
	  private String location;
	  
	  @Override
	  public void update(String location) {
	    this.location = location;
	    showLocation();
	  }

	  public void showLocation() {
	    System.out.println("Notification at User - Current Location: " + location);
	  }
	}