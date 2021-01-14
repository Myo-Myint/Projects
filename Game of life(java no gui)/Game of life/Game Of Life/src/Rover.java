import java.util.Scanner;

public class Rover {
    int gridX;
    int gridY;
    int posX;
    int posY;
    char posD;
    String command;
    Scanner scan = new Scanner(System.in);

    public void grid() {
        System.out.printf("\nEnter the Grid Layout : ");
        int gridX = scan.nextInt();
        int gridY = scan.nextInt();
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public void initPosition(){
        System.out.printf("Enter the rover initial position : ");
        int posX = scan.nextInt();
        int posY = scan.nextInt();
        char posD = scan.next().charAt(0);
        this.posX = posX;
        this.posY = posY;
        this.posD = posD;
    }

    public void setCommand() {
        System.out.printf("Enter the commands for rover : ");
        String command = scan.next();
        this.command = command;
    }

    public void finalPosition(){
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R' || command.charAt(i) == 'L') {
                if (command.charAt(i) == 'R') {
                    switch (posD) {
                        case 'E':
                            posD = 'S';
                            break;
                        case 'W':
                            posD = 'N';
                            break;
                        case 'N':
                            posD = 'E';
                            break;
                        case 'S':
                            posD = 'W';
                            break;
                        default:
                            break;
                    }
                }else if (command.charAt(i) == 'L') {
                    switch (posD) {
                        case 'E':
                            posD = 'N';
                            break;
                        case 'W':
                            posD = 'S';
                            break;
                        case 'N':
                            posD = 'W';
                            break;
                        case 'S':
                            posD = 'E';
                            break;
                        default:
                            break;
                    }
                }
            }else if (command.charAt(i) == 'M'){
                switch (posD) {
                    case 'E':
                        ++posX;
                        break;
                    case 'W':
                        --posX;
                        break;
                    case 'N':
                        ++posY;
                        break;
                    case 'S':
                        --posY;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void print() {
        System.out.printf("Final Position of Rover : %d %d %s\n", posX,posY,posD);
    }
}
