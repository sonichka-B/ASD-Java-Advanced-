package topic9.practice;

public class Tickets {
    private String base;

    public Tickets(String base){
        this.base = base;
    }

    public String getBase() {
        return base;
    }

    public String buildTicketId(String base){
        String prefix = "ticket-";
        class IdBuilder{
            String build(){
                return prefix+base;
            }
        }
        IdBuilder idBuilder = new IdBuilder();
        return idBuilder.build();
    }

    public Runnable runOnce() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("run once");
            }
        };
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "base='" + base + '\'' +
                '}';
    }
}
