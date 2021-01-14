public class RoverController {
    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.grid();
        rover.initPosition();
        rover.setCommand();
        rover.finalPosition();
        rover.print();

        System.out.println("-------------------------------");

        rover.grid();
        rover.initPosition();
        rover.setCommand();
        rover.finalPosition();
        rover.print();
    }
}
