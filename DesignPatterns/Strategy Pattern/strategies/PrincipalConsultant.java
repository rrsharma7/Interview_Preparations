package strategy_pattern.strategies;

public class PrincipalConsultant implements Role {
    @Override
    public String description() {
        return PrincipalConsultant.class.getSimpleName();
    }

    @Override
    public String responsibilities() {
        return "Talk to clients";
    }
}
