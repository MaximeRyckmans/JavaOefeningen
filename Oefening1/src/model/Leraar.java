/**
 * 
 */
package model;

/**
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public enum Leraar {
        JoskeVermeulen("Joske", "Vermeulen"),
        JanJanssen("Jan","Janssen"), 
        SaraSamson("Sara","Samson"), 
        PietSnot("Piet","Snot"), 
        PieterPetersen("Pieter","Petersen");
        
        private String voorNaam;
        private String familieNaam;
        
        Leraar(String voorNaam, String familieNaam){
                this.setVoorNaam(voorNaam);
                this.setFamilieNaam(familieNaam);
        }

        public String getVoorNaam() {
                return voorNaam;
        }

        public void setVoorNaam(String voorNaam) {
                this.voorNaam = voorNaam;
        }

        public String getFamilieNaam() {
                return familieNaam;
        }

        public void setFamilieNaam(String familieNaam) {
                this.familieNaam = familieNaam;
        }
}
