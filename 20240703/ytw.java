public static void hw20240703(int[] input1, int[] input2) {
    int[] 11 = input1;
    int[] 12 = input2;
    
    // First number as string
    String str1 = "";
    for (int i = 11.length - 1; i >= 0; i--) {
        str1 += 11[i];
    }
    
    // Second number as string
    String str2 = "";
    for (int i = 12.length - 1; i >= 0; i--) {
        str2 += 12[i];
    }
    
    // Convert strings to integers and sum them
    int int1 = Integer.parseInt(str1);
    int int2 = Integer.parseInt(str2);
    int int_result = int1 + int2;
    
    // Convert the result back to string and reverse it
    String str_result = String.valueOf(int_result);
    String reverse_result = "";
    for (int i = str_result.length() - 1; i >= 0; i--) {
        reverse_result += str_result.substring(i, i + 1);
    }
    
    // Convert the reversed result back to an integer array
    int[] resultArray = new int[reverse_result.length()];
    for (int i = 0; i < reverse_result.length(); i++) {
        resultArray[i] = Integer.parseInt(reverse_result.substring(i, i + 1));
    }
    
    // Create result node and print
    CC resultNode = new CC(resultArray);
    System.out.println(resultNode);
}

public class CC {
    private int[] ii;

    public CC(int[] input) {
        this.ii = input;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < ii.length; i++) {
            result += String.valueOf(ii[i]) + ", ";
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
