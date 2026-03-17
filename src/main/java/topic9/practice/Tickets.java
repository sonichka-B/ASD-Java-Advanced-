package topic9.practice;

public class Tickets {
    private String base;

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


}
