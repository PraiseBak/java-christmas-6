package christmas;


import christmas.controller.EventController;
import christmas.repostiroy.EventRepository;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    private static final EventController eventController = new EventController(new EventService(new EventRepository()));
    public static void main(String[] args) {
        inputDate();
        inputMenu();
    }

    private static void inputMenu() {
        while (true){
            try {
                String menu = InputView.inputMenu();
                eventController.initMenu(menu);
                return;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void inputDate() {
        while (true){
            try {
                String date = InputView.inputDate();
                eventController.initDate(date);
                return;
            }catch (IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
    }
}
