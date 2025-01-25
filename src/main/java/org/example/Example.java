package org.example;

import java.util.List;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
// Δημιουργία κλάσης Example που περιέχει δεδομένα για την απόκριση API
public class Example {
    // Στοιχεία της απόκρισης API
    private long responseCode;
    private List<Result> results;

    /**
     * Κατασκευαστής χωρίς παραμέτρους για χρήση στη διαδικασία αποσειροποίησης
     */
    public Example() {
    }
    // Κατασκευαστής με παραμέτρους για αρχικοποίηση των πεδίων της κλάσης
    public Example(long responseCode, List<Result> results) {
        super();
        this.responseCode = responseCode;
        this.results = results;
    }
    // Getter για το πεδίο responseCode
    public long getResponseCode() {
        return responseCode;
    }
    // Setter για το πεδίο responseCode
    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }
    // Getter για το πεδίο results
    public List<Result> getResults() {
        return results;
    }
    // Setter για το πεδίο results
    public void setResults(List<Result> results) {
        this.results = results;
    }
    // Αναθεώρηση της μεθόδου toString για εμφάνιση της κλάσης ως συμβολοσειρά
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Example.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("responseCode");
        sb.append('=');
        sb.append(this.responseCode);
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        // Έλεγχος για να αφαιρεθεί το τελευταίο κόμμα
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}