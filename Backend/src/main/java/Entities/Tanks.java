package Entities;

public class Tanks {
    private String name;
    private int power;
    private int power_reserve;
    private int speed;
    private String photo;

    public Tanks(String name, int power, int power_reserve, int speed, String photo) {
        this.name = name;
        this.power = power;
        this.power_reserve = power_reserve;
        this.speed = speed;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower_reserve() {
        return power_reserve;
    }

    public void setPower_reserve(int power_reserve) {
        this.power_reserve = power_reserve;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Tanks{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", power_reserve=" + power_reserve +
                ", speed=" + speed +
                ", photo='" + photo + '\'' +
                '}';
    }
}
