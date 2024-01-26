package pudov.vadim.homeWork3;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyAdding(Car car) {
        System.out.println("Автомобиль " + car.getFirm() + " " + car.getModel() + " заехал на мойку!");
    }
    public void notifyDeleting(int number) {
        System.out.println("Автомобиль с гос номером " + number + " уехал с мойки!");
    }
}
