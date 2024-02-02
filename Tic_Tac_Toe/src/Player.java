public class Player {
    private String representation;


    public Player(String representation){

        this.representation = representation;
    }

    /**
     * Renvoie la representation du player
     * @return : String
     * */
    public String getRepresentation(){
        return this.representation;
    }

    /**
     * Modifie la representation du player
     * */

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

}
