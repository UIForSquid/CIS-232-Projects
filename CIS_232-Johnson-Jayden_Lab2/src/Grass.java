//nothing can drive on a grass tile
/**
 *    YOU SHALL NOT PASS!!
 *   @ o                •̪●  <--Balrog
 *  /|\|              --|||--
 *  /\ |              //   \\
 * ▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌
 */
public class Grass extends Land{


    public Grass(String tileName, int xValue, int yValue, String imageName, String allowedVehicles) {
        super("Grass", xValue, yValue, "grass.png", allowedVehicles);
    }

    public boolean canDrive(Vehicle vehicleType) {
        return false;
    }

    public char redLight() {
        return 'A';
    }

    public String getTileName(){
        return tileName;
    }
    public int getXValue(){
        return xValue;
    }
    public int getYValue(){
        return yValue;
    }
    public String getImageName(){
        return imageName;
    }
    public String getAllowedVehicles(){
        return allowedVehicles;
    }
    public char[] getConnections(){
        return connections;
    }

    public void setTileName(String tileName) {
        this.tileName = this.tileName;
    }
    public void setXValue(int xValue){
        this.xValue = xValue;
    }
    public void setYValue(int yValue) {
        this.yValue = yValue;
    }
    public void setImageName(String imageName){
        this.imageName = imageName;
    }
    public void setAllowedVehicles(String allowedVehicles){
        this.allowedVehicles = allowedVehicles;
    }
}
