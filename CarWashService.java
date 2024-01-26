package pudov.vadim.homeWork3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarWashService {
    private final NotificationService notificationService;
    private List<Car> cars = new ArrayList<>(List.of(new Car("BMW", "X5", "Black", 777),
            new Car("Lexus", "RX", "White", 333),
            new Car("Subaru", "Impreza", "Blue", 123),
            new Car("Lada", "Vesta", "Red", 999)));

    @Autowired
    public CarWashService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Car addCarToQueue(String firm, String model, String color, int number) {
        Car car = new Car();
        car.setFirm(firm);
        car.setModel(model);
        car.setColor(color);
        car.setNumber(number);

        cars.add(car);
        notificationService.notifyAdding(car);

        return car;
    }

    public List<Car> deleteCarFromQueue(int number) {
        notificationService.notifyDeleting(number);

        cars = cars.stream().filter(car -> car.getNumber() != number).collect(Collectors.toList());
        cars.forEach(System.out::println);

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
