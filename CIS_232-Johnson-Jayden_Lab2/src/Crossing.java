import java.util.Objects;

//You take a road and a railroad add them together, you get a crossing!
//works as both a railroad and a road.
public class Crossing extends Road{

    Vehicle vehicle = new Vehicle();
    String vehicleType = vehicle.vehicleType;

    public Crossing(String tileName, int xValue, int yValue, String imageName, String allowedVehicles) {
        super("Crossing", xValue, yValue, "crossing.png", allowedVehicles);
    }

    public boolean canDrive(String vehicleType) {
        if(vehicleType == "car" || vehicleType == "train"){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public char redLight() {
        return randomConnection();
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
