package org.example;

import java.util.List;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
// Δημιουργία κλάσης Result
public class Result {
    // Στοιχεία για μια ερώτηση
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    /**
     * Κατασκευαστής χωρίς παραμέτρους για χρήση στη διαδικασία αποσειροποίησης.
     */
    public Result() {
    }
    // Κατασκευαστής με παραμέτρους για αρχικοποίηση της κλάσης
    public Result(String type, String difficulty, String category, String question, String correct_answer, List<String> incorrect_answers) {
        super();
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }
    // Getters και Setters για τα πεδία της κλάσης
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }
    // Αναθεώρηση της μεθόδου toString για καλύτερη εμφάνιση της κλάσης
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("type");
//        sb.append('=');
//        sb.append(((this.type == null)?"<null>":this.type));
//        sb.append(',');
//        sb.append("difficulty");
//        sb.append('=');
//        sb.append(((this.difficulty == null)?"<null>":this.difficulty));
//        sb.append(',');
//        sb.append("category");
//        sb.append('=');
//        sb.append(((this.category == null)?"<null>":this.category));
//        sb.append(',');
//        sb.append("question");
//        sb.append('=');
//        sb.append(((this.question == null)?"<null>":this.question));
//        sb.append(',');
//        sb.append("correct_answer");
//        sb.append('=');
//        sb.append(((this.correct_answer == null)?"<null>":this.correct_answer));
//        sb.append(',');
//        sb.append("incorrect_answers");
//        sb.append('=');
//        sb.append(((this.incorrect_answers == null)?"<null>":this.incorrect_answers));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}