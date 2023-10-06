package problemSolving.array_hashing;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int count = 0, pre = 0, next = 0;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {
                pre = (i == 0) ? 0 : flowerbed[i - 1];
                next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                if (pre == 0 && next == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
    
}
