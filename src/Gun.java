public class Gun {
    int bullets;

    public Gun(int bullets){
        this.bullets = bullets;
    }

    public Gun(){
        this(5);
    }

    public void shoot(){
        if (bullets > 0){
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }
}
