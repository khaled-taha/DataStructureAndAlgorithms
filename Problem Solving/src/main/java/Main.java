import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSystem system = new ParkingSystem(1, 1, 0);
        System.out.println(system.addCar(1));
        System.out.println(system.addCar(2));
        System.out.println(system.addCar(3));
        System.out.println(system.addCar(1));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] freq1 = new int[2002];
        int[] freq2 = new int[2002];

        for (int num : nums1) {
            if (num >= 0) freq1[num]++;
            else freq1[1002 + num]++;
        }

        for (int num : nums2) {
            if (num >= 0) freq2[num]++;
            else freq2[1002 + num]++;
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());

        for (int num : nums1) {
            int index = (num >= 0) ? num : 2001 + num;
            if (freq1[index] > 0 && freq2[index] == 0) {
                lists.get(0).add(num);
                freq1[index] = -1;
            }
        }

        for (int num : nums2) {
            int index = (num >= 0) ? num : 2001 + num;
            if (freq2[index] > 0 && freq1[index] == 0) {
                lists.get(1).add(num);
                freq2[index] = -1;
            }
        }
        return lists;
    }





}

class ParkingSystem {
    List<Integer> slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = Arrays.asList(big, medium, small);
    }

    public boolean addCar(int carType) {
        for (int i = 0; i < this.slots.size(); i++) {
            if(this.slots.get(i) > 0 && this.slots.get(i) <= carType){
                this.slots.set(i, this.slots.get(i) - 1);
                return true;
            }
        }
        return false;
    }
}