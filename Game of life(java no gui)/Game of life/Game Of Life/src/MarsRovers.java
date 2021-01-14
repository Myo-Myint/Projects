import java.util.Scanner;

public class MarsRovers{
    
    int corX;
    int corY;
    int gridX;
    int gridY;
    String direction ;
    String command ;
    Scanner input = new Scanner(System.in);

    public void getGrid(){
        System.out.print("\nEnter the grid layout(x,y) : ");
        int gridX = input.nextInt();
        int gridY = input.nextInt();
        this.gridX = gridX;
        this.gridY = gridY;
    }
    public void beforePos(){
        System.out.print("Enter the  rover initial position : ");
        int corX = input.nextInt();
        int corY = input.nextInt();
        String direction = input.nextLine();
        this.corX = corX;
        this.corY = corY;
        this.direction = direction;
    }
    public void getCommand(){
        System.out.print("Enter the command for  rover : ");
        String command = input.nextLine();
        this.command = command;
    }
    public void afterPos(){
        for (int i = 0; i < command.length(); i++) {
          if (command.charAt(i)== 'L' || command.charAt(i) == 'R') {
                if (command.charAt(i) == 'L') {
                     switch (direction) {
                          case "N":
                              direction = "W";
                              break;
                          case "E":
                              direction = "N";
                              break;
                          case "S":
                              direction = "E";
                              break;    
                          case "W":
                              direction = "S";
                              break;    
                          default:
                              break;
                     }
            }else   if (command.charAt(i) == 'R') {
                     switch (direction) {
                          case "N":
                              direction = "E";
                              break;
                          case "E":
                               direction = "S";
                              break;
                          case "S":
                              direction = "W";
                              break;    
                          case "W":
                              direction = "N";
                              break;    
                          default:
                             break;
                     }
            }
         }else if(command.charAt(i) == 'M'){
                switch (direction) {
                    case "N":
                        ++corY;
                        break;
                    case "E":
                        ++corX;
                        break;
                    case "S":
                        --corY;
                        break;    
                    case "W":
                        --corX;
                        break;    
                    default:
                        break;
                }
         }
        }     
    }   
    public void showResult(){
        System.out.print("\nFinal Position of  rover : " + corX + " " +corY + direction );
    }


    public static void main(String[] args) {
        MarsRovers marsRovers = new MarsRovers();

        marsRovers.getGrid();
        marsRovers.beforePos();
        marsRovers.getCommand();
        marsRovers.afterPos();
        marsRovers.showResult();

        System.out.println("\n_____________________________________");

        marsRovers.getGrid();
        marsRovers.beforePos();
        marsRovers.getCommand();
        marsRovers.afterPos();
        marsRovers.showResult();
    }
}