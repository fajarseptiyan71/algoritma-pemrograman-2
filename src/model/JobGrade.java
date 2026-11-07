package model;

public class JobGrade {
    private Integer id;
    private String code;
    private Integer amount; 

    public JobGrade(Integer id, String code, Integer amount) {
        this.id = id;
        this.code = code;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Integer getAmount() {
        return amount;
    }
}
