package leetcode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PrisionCellsAfterNDays {
    public static void main(String[] args) {
        prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1},
                         7);
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        //Cell is fixed
        int numac = N;
        if (N < 1) {
            return cells;
        }
        Set<Integer> set = new LinkedHashSet();
        int[] local = new int[cells.length];
        System.arraycopy(cells,0,local,0,cells.length);
        int repeatAfter = 0;
        //cells[0] = 0; cells[7] = 0;
        while (N >= 0) {
            N--;
            String st = Arrays.stream(cells)
                    .mapToObj(j -> String.valueOf(j))
                    .collect(Collectors.joining());
            //lets make set of number  from binary
            int val = Integer.parseInt(st, 2);
            for (int i = 1; i < 7 ;i++ ){
                if(cells[i+1] == cells[i-1] ){
                    local[i] = 1;
                }else {
                    local[i] = 0;
                }
            }
            local[0] = 0; local[7] = 0;
            if(!set.add(val)){
                break;
            }
            int[] temp = local;
            local = cells;
            cells = temp;
            repeatAfter++;

        }
        int indexAt = 0; Integer val;
        Integer[] intee = set.toArray(new Integer[0]);
        //Given a number  N, if it repeats after k.
        if(repeatAfter <= 1){
            val = intee[intee.length -1];
        }else if(numac % (repeatAfter -1) == 0){
            val = intee[repeatAfter - 1 ];
        }else {
            indexAt = numac % repeatAfter;
            val = intee[indexAt -1];
        }

        int[] ch = Integer.toBinaryString(val)
                .chars()
                .mapToObj(j -> Character.getNumericValue(j))
                .mapToInt(k -> Integer.valueOf(k))
                .toArray();
        return ch;
    }
}
