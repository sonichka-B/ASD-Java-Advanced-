package topic15.practice;

public class SetupFlow {
    @Step(order = 1)
    public void initialize(){
        System.out.println("initialized data");
    }
    @Step(order = 2)
    private void setupConnection(){
        System.out.println("setup connection with server");
    }

    private void notWork(){
        System.out.println("must ignore that method");
    }

    @Step(order = 4)
    public void start(){
        System.out.println("start the flow");
    }
    @Step(order = 3)
    private void error(){
        throw new RuntimeException("you have a problem");
    }
}
