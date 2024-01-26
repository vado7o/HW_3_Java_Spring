package pudov.vadim.homeWork3;

public class Car {
    private String firm;
    private String model;
    private String color;
    private int number;

    public Car() {}

    public Car(String firm, String model, String color, int number) {
        this.firm = firm;
        this.model = model;
        this.color = color;
        this.number = number;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "firm='" + firm + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", number=" + number +
                '}';
    }
}
