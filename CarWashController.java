package pudov.vadim.homeWork3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CarWashController {
    private final CarWashService carWashService;

    @Autowired
    public CarWashController(CarWashService carWashService) {this.carWashService = carWashService;}

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<Car> addCarToQueue(@RequestParam String firm, @RequestParam String model, @RequestParam String color, @RequestParam int number) {
        return new ResponseEntity<>(carWashService.addCarToQueue(firm, model, color, number), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ResponseEntity<StringBuilder> printCarList() {
        StringBuilder stringBuilder = new StringBuilder("В настоящий момент на мойке:");
        carWashService.getCars().forEach(car -> stringBuilder.append("\nМарка: ").append(car.getFirm())
                .append("; Модель: ").append(car.getModel()).append("; Цвет: ").append(car.getColor())
                .append("; Гос. номер: ").append(car.getNumber()));
        return new ResponseEntity<>(stringBuilder, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public ResponseEntity<List<Car>> deleteCar(@RequestParam int number) {
        return new ResponseEntity<>(carWashService.deleteCarFromQueue(number), HttpStatus.OK);
    }
}
