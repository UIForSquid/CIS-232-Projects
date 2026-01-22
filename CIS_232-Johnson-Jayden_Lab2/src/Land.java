//The parent class of all tiles
public abstract class Land {

    public String tileName;
    public int xValue;
    public int yValue;
    public final char[] connections = {'N', 'S', 'E', 'W'};
    public char ranConnection;
    public int ranNum = (int)(Math.random()*4);
    public String imageName;
    public String allowedVehicles;

    public Land(String tileName, int xValue, int yValue, String imageName, String allowedVehicles) {

    }

    //used to determine if a vehicle can drive on a tile or not
    public boolean canDrive(String vehicleType){
        return false;
    }

    //assigns a random direction to ranConnections
    public char randomConnection(){
        switch(ranNum){

            case 1:
                ranConnection =  connections[0];
                break;

            case 2:
                ranConnection =  connections[1];
                break;

            case 3:
                ranConnection =  connections[2];
                break;

            case 4:
                ranConnection = connections[3];
                break;

        }
        return ranConnection;
    }

    //checks if the light is red
    public char redLight(){
        return 'A';
    }


    //GETS AND SETS!!!!
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
