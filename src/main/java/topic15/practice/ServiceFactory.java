package topic15.practice;

public class ServiceFactory {
    public PaymentService create(String className){
        try{
            Class<?> clazz = Class.forName(className);
            Object service = clazz.getDeclaredConstructor().newInstance();
            if (service instanceof  PaymentService){
                return (PaymentService) service;
            }else{
                throw  new IllegalArgumentException(className);
            }
        }catch (ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }
}
