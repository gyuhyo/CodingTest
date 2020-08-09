import java.util.*;

class SecretMap {
    public static String[] getMap(String[] arr1, String[] arr2) {
        String[] maps = new String[arr1.length];
        String arrElement;
        for (int i = 0; i < arr1.length; i++) {
            arrElement = "";
            for (int j = 0; j < arr1[i].length(); j++) {
                if (arr1[i].substring(j, j+1).equals("0")) {
                    if (arr2[i].substring(j, j+1).equals("0")) {
                        arrElement += " ";
                    } else {
                        arrElement += "#";
                    }
                } else {
                    if (arr1[i].substring(j, j+1).equals("1")) {
                        arrElement += "#";
                    } else {
                        arrElement += " ";
                    }
                }
            }
            maps[i] = arrElement;
        }

        return maps;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] tmpArr1, tmpArr2;
        tmpArr1 = new String[n];
        tmpArr2 = new String[n];

        String tmpBinary;
        int lenBinary;

        for (int i = 0; i < n; i++) {
            tmpBinary = Integer.toBinaryString(arr1[i]);
            lenBinary = n - tmpBinary.length();
            if (lenBinary > 0) {
                for (int j=0; j<lenBinary; j++) tmpBinary = "0" + tmpBinary;
            }
            tmpArr1[i] = tmpBinary;

            tmpBinary = Integer.toBinaryString(arr2[i]);
            lenBinary = n - tmpBinary.length();
            if (lenBinary > 0) {
                for (int j=0; j<lenBinary; j++) tmpBinary = "0" + tmpBinary;
            }
            tmpArr2[i] = tmpBinary;
        }

        System.out.println(Arrays.toString(tmpArr1));
        System.out.println(Arrays.toString(tmpArr2));

        return getMap(tmpArr1, tmpArr2);
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1_1 = new int[]{9, 20, 28, 18, 11};
        int[] arr1_2 = new int[]{30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr2_1 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr2_2 = new int[]{27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution(n1, arr1_1, arr1_2)));
        System.out.println(Arrays.toString(solution(n2, arr2_1, arr2_2)));
    }
}
