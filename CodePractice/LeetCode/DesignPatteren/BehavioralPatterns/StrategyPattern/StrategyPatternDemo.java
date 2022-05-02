package LeetCode.DesignPatteren.BehavioralPatterns.StrategyPattern;

interface Strategy {
	public String route();
}

class Bus implements Strategy {

	@Override
	public String route() {
		return "bus";
	}

}

class Car implements Strategy {

	@Override
	public String route() {
		return "car";
	}

}

class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public String routeStrategy() {
		return strategy.route();
	}

}

public class StrategyPatternDemo {
	public static void main(String[] str)
	{
		Context context=new Context(new Bus());
		String k=context.routeStrategy();
		System.out.println(k);
	}

}
