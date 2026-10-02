public class Gun {
    private final int maxBullets;
    private int bullets;

    public Gun(int maxBullets, int bullets){
        if (maxBullets <= 0){
            throw new IllegalArgumentException("Вместимость должна быть больше нуля: " + maxBullets);
        }
        if (bullets < 0 || bullets > maxBullets){
            throw new IllegalArgumentException("Патронов должно быть от 0 до " + maxBullets + ": " + bullets);
        }
        this.maxBullets = maxBullets;
        this.bullets = bullets;
    }

    public Gun(int bullets){
        this(bullets, bullets);
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

    public int reload(int count){
        if (count < 0){
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может: " + count);
        }
        int free = maxBullets - bullets;
        if (count > free){
            bullets = maxBullets;
            return count - free;
        }
        bullets += count;
        return 0;
    }

    public int unload(){
        int returned = bullets;
        bullets = 0;
        return returned;
    }

    public int getMaxBullets(){
        return maxBullets;
    }

    public int getBullets(){
        return bullets;
    }

    public boolean isLoaded(){
        return bullets > 0;
    }
}
