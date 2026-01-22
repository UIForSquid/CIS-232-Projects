import java.util.Objects;

//Road for Cars, this is a tile that cars can drive on and nothing else.
public class Road extends Land{

    Vehicle vehicle = new Vehicle();
    String vehicleType = vehicle.vehicleType;

    public Road(String tileName, int xValue, int yValue, String imageName, String allowedVehicles) {
        super("Road", xValue, yValue, "road.png", allowedVehicles);
    }

    public boolean canDrive(String vehicleType) {
        if(vehicleType == "car"){
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
