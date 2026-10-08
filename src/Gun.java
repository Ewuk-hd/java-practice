public class Gun extends Weapon {
    private final int maxBullets;

    public Gun(int maxBullets, int bullets){
        super(bullets);
        if (maxBullets <= 0){
            throw new IllegalArgumentException("Вместимость должна быть больше нуля: " + maxBullets);
        }
        if (bullets > maxBullets){
            throw new IllegalArgumentException("Патронов должно быть от 0 до " + maxBullets + ": " + bullets);
        }
        this.maxBullets = maxBullets;
    }

    public Gun(int bullets){
        this(bullets, bullets);
    }

    public Gun(){
        this(5);
    }

    @Override
    public void shoot(){
        if (getAmmo()){
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int count){
        if (count < 0){
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может: " + count);
        }
        int free = maxBullets - ammo();
        if (count > free){
            load(maxBullets);
            return count - free;
        }
        load(ammo() + count);
        return 0;
    }

    public int unload(){
        int returned = ammo();
        load(0);
        return returned;
    }

    public int getMaxBullets(){
        return maxBullets;
    }

    public int getBullets(){
        return ammo();
    }

    public boolean isLoaded(){
        return ammo() > 0;
    }
}
