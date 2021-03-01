package cn.itcast.exception;

public class Sysexception extends Exception{
    private String massage;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Sysexception(String massage) {
        this.massage = massage;
    }
}
