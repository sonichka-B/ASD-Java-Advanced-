package topic9.practice;

import java.util.Objects;

public class Car {
    private  final String model;

    public Car(String model){
        this.model =model;
    }
    public static class Engine{
        private double horsepower;

        public Engine(double horsepower){
            this.horsepower =horsepower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsepower=" + horsepower +
                    '}';
        }
    }

    public Engine spec(double horsepower){
        return new Engine(horsepower);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }
}
