 public class Driver {
     public static void main(String[] args) {
         BitMagic b = new BitMagic();
         System.out.println(b.check_kth_bit_setOrNot(5,2));
         System.out.println(b.count_set_bits1(13));
         System.out.println(b.count_set_bits2(13));
         System.out.println(b.count_set_bits3(13));
         System.out.println(b.power_of_two_or_not(16));
         System.out.println(b.power_set_using_bitwise_operator("abcd"));
         System.out.println((b.add(5,3)));
         System.out.println(b.turnOffRightmostSetBit(20));
         b.bin(3);
         System.out.println();
         System.out.println(b.decimalToBinary(4.47,3));
     }
}