public class Cell {

    private final static String DEFAULT_REP = "|   ";
    private String representation = DEFAULT_REP;

    private void setRepresentation(String representation) {
        this.representation = representation;
    }

    /**
     * Verifie si une cellule est occupee retourne false sinon modifie la cellule avec le symbole passée en param
     * @param : symbole de type String
     * @return : boolean
     * */

    public boolean updateRep(String symbole){
        if (isOccupied()){
            return false;
        }else {
            setRepresentation("| "+symbole + " ");
            return  true;
        }
    }

    /**
     * Renvoie la representation du cellule
     * @return : String
     * */
    public String getRepresentation(){
        return this.representation;
    }

    /**
     * Verifie si une cellule est occupee ou pas
     * @return : boolean
     * */
    public boolean isOccupied(){
        return !DEFAULT_REP.equals(representation);
    }

}
