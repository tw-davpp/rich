package tw.terrain;

public abstract class HouseReconstruction {
    abstract public void reconstruction();

    abstract public void prompt();

    abstract public boolean matchCondition();

    public void execute() {
        prompt();
        if (matchCondition()) {
            reconstruction();
        }
    }
}
