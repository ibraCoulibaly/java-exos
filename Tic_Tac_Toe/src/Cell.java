public class Cell {

    private final static String DEFAULT_REP = "|   ";
    private String representation = DEFAULT_REP;

    private void setRepresentation(String representation) {
        this.representation = representation;
    }

    public boolean updateRep(String symbole){
        if (isOccupied()){
            return false;
        }else {
            setRepresentation("| "+symbole + " ");
            return  true;
        }
    }

    public String getRepresentation(){
        return this.representation;
    }

    public boolean isOccupied(){
        return !DEFAULT_REP.equals(representation);
    }

}
