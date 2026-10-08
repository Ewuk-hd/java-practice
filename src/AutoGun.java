public class AutoGun extends Gun {
    private final int fireRate;

    public AutoGun(){
        this(30, 30);
    }

    public AutoGun(int maxBullets){
        this(maxBullets, maxBullets / 2);
    }

    public AutoGun(int maxBullets, int fireRate){
        super(maxBullets, maxBullets);
        if (fireRate <= 0){
            throw new IllegalArgumentException("Скорострельность должна быть больше нуля: " + fireRate);
        }
        this.fireRate = fireRate;
    }

    public int getFireRate(){
        return fireRate;
    }

    @Override
    public void shoot(){
        for (int i = 0; i < fireRate; i++){
            super.shoot();
        }
    }

    public void shoot(int seconds){
        for (int i = 0; i < seconds; i++){
            shoot();
        }
    }
}
