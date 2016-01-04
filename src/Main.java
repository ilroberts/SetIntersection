
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        while ((line = buffer.readLine()) != null) {

            line = line.trim();
            String []input = line.split(";");

            Set<Integer> first = convertToSet(input[0]);
            Set<Integer> second = convertToSet(input[1]);

            Set<Integer> intersection = new HashSet<>(first);
            intersection.retainAll(second);
            printResults(new TreeSet(intersection));
        }
    }

    private static void printResults(Set<Integer> input) {

        Iterator iter = input.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if(iter.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
    private static Set<Integer> convertToSet(String set) {

        Set<Integer> output = new HashSet<>();
        String[] values = set.split(",");
        for (int i=0;i<values.length;i++) {
            output.add(new Integer(Integer.parseInt(values[i])));
        }
        return(output);
    }
}
